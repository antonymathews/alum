/**
 * <!-- 
Author - Antony Mathews IMIT, Cuttack, Odisha, India, batch-2001
With inputs from 
Biajay Sahoo			batch-2001
Sundeep Mohanty (Tutu)	batch-2001
Sambit Satpathy			batch-2000
Soumya Mohanty (Bapi) 	batch-2001
Kamalesh Nayak			batch-2001
 -->

 */

package in.co.antony.alum.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import in.co.antony.alum.form.MemberForm;
import in.co.antony.alum.form.SearchMemberForm;
import in.co.antony.alum.model.Member;
import in.co.antony.alum.model.Role;
import in.co.antony.alum.service.MemberService;
import in.co.antony.alum.service.RoleService;
import in.co.antony.alum.util.EncryptPassword;

@Controller
@RequestMapping("/")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	Environment environment;
	
	@RequestMapping(value = { "/admin-member-list" }, method = RequestMethod.GET)
	public String listMembers(ModelMap model) {
		SearchMemberForm smf = new SearchMemberForm();
		model.addAttribute("searchMemberForm", smf);
		List<Member> members = service.findAllMembers();
		model.addAttribute("members", members);
		return "allMembers";
	}
	@RequestMapping(value = { "/admin-member-list", "/member-{type}-{search}-list" }, method = RequestMethod.POST)
	public String listMembers(@Valid SearchMemberForm searchMemberForm, BindingResult result, ModelMap model) {
		model.addAttribute("searchMemberForm", searchMemberForm);
		List<Member> members = service.findAllMembers(searchMemberForm.getType(),
				searchMemberForm.getSearch());
		model.addAttribute("members", members);
		return "allMembers";
	}
	
	@RequestMapping(value = { "/admin-member-new-list" }, method = RequestMethod.GET)
	public String registeredMembers(ModelMap model) {

		List<Member> members = service.findAllMembers();	//TODO only new members
		model.addAttribute("members", members);
		return "allMembers";
	}
	
	@RequestMapping(value = { "/member-{type}-{search}-list" }, method = RequestMethod.GET)
	public String searchMembers(@PathVariable String type, 
			@PathVariable String search, ModelMap model) {

		if(null != search && search.equals("year")) {
			Object principal  = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UserDetails userDetails = null;
			if (principal instanceof UserDetails) {
			  userDetails = (UserDetails) principal;
			}
			Member member = service.getIdFromUserName(userDetails.getUsername());
			search = member.getBatchYear()+"";
		}
		List<Member> members = service.findAllMembers(type, search);
		model.addAttribute("members", members);
		SearchMemberForm smf = new SearchMemberForm();
		model.addAttribute("searchMemberForm", smf);
		return "allMembers";
	}
	
	/**
	 * New member addition 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String newMember(ModelMap model) {
		MemberForm memberForm = new MemberForm();
		//Member member = new Member();
		model.addAttribute("memberForm", memberForm);
		model.addAttribute("edit", false);
		return "changeMember";
	}
	
	@RequestMapping(value =  "/signup", method = RequestMethod.POST)
	public String saveMember(@Valid MemberForm memberForm, BindingResult result,
			ModelMap model) {
		Member member = new Member(memberForm);
		
		member.setRegistrationDate(new LocalDate(new DateTime()));	// registration date today
		
		member.setEnabled(false);	//first time disabled
		if (result.hasErrors()) {
			return "changeMember";
		}
	    
		writePhoto(memberForm);
        
		service.saveMember(member);
		model.addAttribute("success", "Member " + member.getName() + " registered successfully");
		model.addAttribute("type", "member");
		return "success";
	}

	private synchronized void  writePhoto(MemberForm memberForm) {
		System.out.println("Fetching file");
		if(null == memberForm.getFile().getOriginalFilename()
				|| memberForm.getFile().getOriginalFilename().isEmpty()) {
			return;	//Do not delete the photo if no photo is uploaded
		}
        File uploadedFile = new File( environment.getRequiredProperty("image.jpg.path") 
				+ memberForm.getId()+ "-photo.JPG");
        try {
        	FileCopyUtils.copy(memberForm.getFile().getBytes(), uploadedFile);
        } catch (IOException ioerr) {
        	System.out.println(" Error in writing photo :"+ioerr);
        }
	}
	
	@RequestMapping(value =  {"/admin-edit-{id}-member"}, method = RequestMethod.GET)
	public String editMember(@PathVariable int id, ModelMap model) {
		MemberForm memberForm = new MemberForm(service.findById(id));
		memberForm.setAdmin(true);
		Role role = roleService.findByUserName(memberForm.getUserName());
		if(null != role) {
			memberForm.setRole(role.getRole());
		}
		model.addAttribute("memberForm", memberForm);
		model.addAttribute("edit", true);
		return "changeMember";
	}
	
	@RequestMapping(value = { "/admin-edit-{id}-member" }, method = RequestMethod.POST)
	public String editMember(@Valid MemberForm memberForm, BindingResult result,
			ModelMap model, @PathVariable String id) {
		Member member = new Member(memberForm);
		if (result.hasErrors()) {
			return "changeMember";
		}
		writePhoto(memberForm);
		service.updateMember(member, true);
		
		Role role = roleService.findByUserName(memberForm.getUserName());
		if(null == role) {
			role = new Role();
			role.setUserName(memberForm.getUserName());
			role.setRole(memberForm.getRole());
			roleService.saveRole(role);
		} else {
			role.setRole(memberForm.getRole());
			roleService.updateRole(role);
		}
		model.addAttribute("success", "Member " + member.getName()	+ " updated successfully");
		model.addAttribute("type", "member");
		return "success";
	}
	
	/*
	 * This method will delete an bank by it's SSN value.
	 */
	@RequestMapping(value = { "/admin-delete-{id}-member" }, method = RequestMethod.GET)
	public String deleteMember(@PathVariable int id) {
		roleService.deleteRoleById(id);
		service.deleteMemberById(id);
		return "redirect:/member-list";
	}

	@RequestMapping(value =  {"/edit"}, method = RequestMethod.GET)
	public String edit(ModelMap model) {
		Object principal  = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		MemberForm memberForm = new MemberForm(
				service.getIdFromUserName(userDetails.getUsername()));
		
		model.addAttribute("memberForm", memberForm);
		model.addAttribute("edit", true);
		return "changeMember";
	}
	
	@RequestMapping(value = { "/edit" }, method = RequestMethod.POST)
	public String edit(@Valid MemberForm memberForm, BindingResult result,
			ModelMap model) {
		Member member = new Member(memberForm);
		if (result.hasErrors()) {
			return "changeMember";
		}
		writePhoto(memberForm);
        
		service.updateMember(member, false);

		model.addAttribute("success", "Member " + member.getName()	+ " updated successfully");
		model.addAttribute("type", "member");
		return "success";
	}
	
	@RequestMapping(value =  {"/view"}, method = RequestMethod.GET)
	public String view(ModelMap model) {
		Object principal  = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		MemberForm memberForm = new MemberForm(
				service.getIdFromUserName(userDetails.getUsername()));
		
		model.addAttribute("memberForm", memberForm);
		model.addAttribute("edit", false);
		return "viewMember";
	}	
	
	@RequestMapping(value =  {"/member-{id}-view"}, method = RequestMethod.GET)
	public String view(@PathVariable int id, ModelMap model) {
		MemberForm memberForm = new MemberForm(service.findById(id));
		
		model.addAttribute("memberForm", memberForm);
		model.addAttribute("edit", false);
		return "viewMember";
	}	

}

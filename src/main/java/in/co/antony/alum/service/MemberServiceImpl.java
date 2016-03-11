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

package in.co.antony.alum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.antony.alum.dao.MemberDao;
import in.co.antony.alum.model.Member;

@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao dao;
	
	@Override
	public Member findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveMember(Member member) {
		System.out.println(">>>>> save member");
		dao.saveMember(member);
		
	}

	@Override
	public void updateMember(Member member, boolean admin) {
		System.out.println(" in update member service id:"+member.getId());
		Member entity = dao.findById(member.getId());
		if(null != entity) {
			entity.setBatchYear(member.getBatchYear());
			//entity.setUserName(member.getUserName());
			entity.setPassword(member.getPassword());
			entity.setName(member.getName());
			//entity.setRegistrationDate(member.getRegistrationDate());
			entity.setContactEmail(member.getContactEmail());
			entity.setRollNumber(member.getRollNumber());
			if(admin) {
				entity.setEnabled(member.isEnabled());	//only for Admin
			}
			entity.setLocation(member.getLocation());
			entity.setAboutYou(member.getAboutYou());
			entity.setProfession(member.getProfession());
			entity.setHobby(member.getHobby());
			entity.setContactAddress(member.getContactAddress());
			entity.setContactNumber(member.getContactNumber());
			entity.setDisplayContact(member.isDisplayContact());
		}
	}

	@Override
	public void deleteMemberById(int id) {
		dao.deleteMemberById(id);		
	}

	@Override
	public List<Member> findAllMembers() {
		return dao.findAllMembers();
	}

	@Override
	public List<Member> findAllMembers(String type, String search) {
		return dao.findAllMembers(type, search);
	}

	@Override
	public Member getIdFromUserName(String userName) {
		return dao.getIdFromUserName(userName);
	}

}

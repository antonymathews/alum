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

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AppController {
	@Autowired
	MessageSource messageSource;

	@Autowired
    private Environment environment;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "welcome";
	}

	@RequestMapping(value = "/member-home", method = RequestMethod.GET)
	public String memberHome(ModelMap model) {
		model.addAttribute("success", "Profile view");
		return "redirect:/view";
	}
	
	//Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(ModelMap model) {
		model.addAttribute("success", " Admin Page to manage members ");
		return "admin";
	}
	
	@RequestMapping(value = "/image/{imageId}")
	@ResponseBody
	public byte[] getImage(@PathVariable int imageId) {
		String imagePathName=
				environment.getRequiredProperty("image.jpg.path")+imageId+"-photo.JPG";
		String defaultPathName=
				environment.getRequiredProperty("image.jpg.path")+"0-photo.JPG";
		try {
			return fileToBytes(imagePathName);
		} catch (IOException ioe) {
			try {
				return fileToBytes(defaultPathName);
			} catch (IOException ierr) {
				System.out.println(" default photo error : "+ierr);
			}
			System.out.println(" photo error : "+ioe);
		}
		return null;
	}

	private byte[] fileToBytes(String imagePathName) throws IOException {
		BufferedImage originalImage = ImageIO.read(new File(imagePathName));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write( originalImage, "jpg", baos );
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();
		return imageInByte;
	}
}

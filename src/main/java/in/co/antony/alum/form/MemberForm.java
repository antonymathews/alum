/**
 * <!-- 
Author - Antony Mathews IMIT, Cuttack, Odisha, India, batch-2001
With inputs from 
Biajay Sahoo			batch-2001
Sundeep Mohanty (Tutu)	batch-2001
Sambit Satpathy			batch-2000
Soumya Ranjan Parida (Bapi) 	batch-2001
Kamalesh Nayak			batch-2001
 -->

 */

package in.co.antony.alum.form;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import in.co.antony.alum.model.Member;

public class MemberForm {
	
	MultipartFile file;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min=3, max=25)
	@Column(name = "username", nullable = false)
	private String userName;
	@Column(name = "password", nullable = false)
	private String password;
	private String previousPassword;
	@Size(min=2, max=100)
	@Column(name = "name", nullable = false)
	private String name;
	@Size(min=2, max=50)
	@Column(name = "roll_no")
	private String rollNumber;
	@Min(2000)
	@Column(name = "batch_yr", nullable = false)
	private int batchYear;
	@Column(name = "enabled", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean enabled;
	@NotEmpty @Email
	@Column(name = "contact_email", nullable = false) 
	private String contactEmail;
	@Column(name = "role", nullable = false)
	private String role;
	private boolean admin;
	
	private String location;
	private String aboutYou;
	private String profession;
	private String hobby;
	private String contactAddress;
	private String contactNumber;
	@Column(name = "display_contact", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean displayContact;

	
	public MemberForm() {
	}

	public MemberForm(Member member) {
		setId(member.getId());
		setUserName(member.getUserName());
		setName(member.getName());
		setPreviousPassword(member.getPassword());
		setRollNumber(member.getRollNumber());
		setBatchYear(member.getBatchYear());
		setContactEmail(member.getContactEmail());
		setEnabled(member.isEnabled());
		setLocation(member.getLocation());
		setAboutYou(member.getAboutYou());
		setProfession(member.getProfession());
		setHobby(member.getHobby());
		setContactAddress(member.getContactAddress());
		setContactNumber(member.getContactNumber());
		setDisplayContact(member.isDisplayContact());
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPreviousPassword() {
		return previousPassword;
	}

	public void setPreviousPassword(String previousPassword) {
		this.previousPassword = previousPassword;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public int getBatchYear() {
		return batchYear;
	}
	public void setBatchYear(int batchYear) {
		this.batchYear = batchYear;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAboutYou() {
		return aboutYou;
	}

	public void setAboutYou(String aboutYou) {
		this.aboutYou = aboutYou;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public boolean isDisplayContact() {
		return displayContact;
	}

	public void setDisplayContact(boolean displayContact) {
		this.displayContact = displayContact;
	}
}

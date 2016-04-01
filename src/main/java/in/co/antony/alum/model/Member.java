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

package in.co.antony.alum.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import in.co.antony.alum.form.MemberForm;
import in.co.antony.alum.util.EncryptPassword;

@Entity
@Table(name="member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(min=3, max=25)
	@Column(name = "username", nullable = false)
	private String userName;
	
	@Size(min=2, max=100)
	@Column(name = "name", nullable = false)
	private String name;
	
	@Size(min=3, max=100)
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "reg_date", nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate registrationDate;
	
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
	
	@Column(name = "location", nullable = true) 
	private String location;
	@Column(name = "about_you", nullable = true) 
	private String aboutYou;
	@Column(name = "profession", nullable = true) 
	private String profession;
	@Column(name = "hobby", nullable = true) 
	private String hobby;
	@Column(name = "contact_address", nullable = true) 
	private String contactAddress;
	@Column(name = "contact_no", nullable = true) 
	private String contactNumber;
	@Column(name = "display_contact", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean displayContact;
	
	public Member() {
	}

	public Member(MemberForm memberForm) {
		setId(memberForm.getId());
		setUserName(memberForm.getUserName());
		if(null == memberForm.getPassword() || memberForm.getPassword().isEmpty()) {
			setPassword(memberForm.getPreviousPassword());
		} else {
			setPassword(EncryptPassword.encrypt(memberForm.getPassword()));
		}
		setName(memberForm.getName());
		setRollNumber(memberForm.getRollNumber());
		setBatchYear(memberForm.getBatchYear());
		setContactEmail(memberForm.getContactEmail());
		setEnabled(memberForm.isEnabled());
		setLocation(memberForm.getLocation());
		setAboutYou(memberForm.getAboutYou());
		setProfession(memberForm.getProfession());
		setHobby(memberForm.getHobby());
		setContactAddress(memberForm.getContactAddress());
		setContactNumber(memberForm.getContactNumber());
		setDisplayContact(memberForm.isDisplayContact());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
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

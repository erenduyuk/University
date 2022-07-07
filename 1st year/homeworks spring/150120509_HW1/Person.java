//Import calendar
import java.util.Calendar;

//Eren Duyuk 150120509

/*The purpose of this class is to create person object and manage person related operations*/

public class Person {
	
	private int id;
	private String firstName;
	private String lastName;
	private byte gender;
	private java.util.Calendar birthDate;
	private byte maritalStatus;
	private boolean hasDriverLicence;
	
	
	//Construct person
	public Person(int id, String firstName, String lastName, String gender, 
			Calendar birthDate, String maritalStatus, String hasDriverLicence) throws Exception {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		
		if (gender.equals("Woman"))
			this.gender = 1;
		else if (gender.equals("Man"))
			this.gender = 2;
		else
			throw new Exception("Gender must be 'Man' or 'Woman'!");
		
		
		this.birthDate = birthDate;
		
		if (maritalStatus.equals("Single"))
			this.maritalStatus = 1;
		else if (maritalStatus.equals("Married"))
			this.maritalStatus = 2;
		else
			throw new Exception("Marital status must be 'Married' or 'Single'!");
		
		if (hasDriverLicence.equals("Yes"))
			this.hasDriverLicence = true;
		else if (hasDriverLicence.equals("No"))
			this.hasDriverLicence = false;
		else
			throw new Exception("HasDriverLicence must be 'Yes' or 'No'!");
	}
	//set gender
	public void setGender(String gender) throws Exception {
		if (gender.length() < 3)
			throw new Exception("Input cannot be no less 3 symbols!");
		if (gender.equals("Woman"))
			this.gender = 1;
		else if(gender.equals("Man"))
			this.gender = 2;
		else
			throw new Exception("Gender must be 'Man' or 'Woman'!");
	}
	//get gender
	public String getGender() {
		if (gender == 1)
			return "Woman";
		else if (gender == 2)
			return "Man";
		else
			return "Invalid gender!";
	}
	//set maritalStatus
	public void setMaritalStatus(String status) throws Exception {
		if (status.length() < 3)
			throw new Exception("Input cannot be no less 3 symbols!");
		if (status.equals("Single"))
			maritalStatus = 1;
		else if (status.equals("Married"))
			maritalStatus = 2;
		else
			throw new Exception("Marital status must be 'Married' or 'Single'!");
	}
	//get maritalStatus
	public String getMaritalStatus() {
		if (maritalStatus == 1)
			return "Single";
		else if (maritalStatus == 2)
			return "Married";
		else
			return "Invalid marital status";
	}
	//set hasDriverLicence
	public void setHasDriverLicence(String info) throws Exception {
		if (info.length() < 3 && !(info.equals("No")))
			throw new Exception("Input cannot be no less 3 symbols!"); 
		if (info.equals("Yes"))
			hasDriverLicence = true;
		else if (info.equals("No"))
			hasDriverLicence = false;
		else
			throw new Exception("HasDriverLicence must be 'Yes' or 'No'!");
	}
	//get hasDriverLicence
	public String getHasDriverLicence() {
		if (hasDriverLicence)
			return "Yes";
		else if (!hasDriverLicence)
			return "No";
		else
			return "Invalid information about driver licence";
	}
	
	//get id
	public int getId() {
		return id;
	}
	//set id
	public void setId(int id) throws Exception {
		if (id <= 0)
			throw new Exception("Id cannot be negative!");
		this.id = id;
	}
	//get firstName
	public String getFirstName() {
		return firstName;
	}
	//set firstName
	public void setFirstName(String firstName) throws Exception {
		if (firstName.length() < 3)
			throw new Exception("Input cannot be no less 3 character!"); 
		this.firstName = firstName;
	}
	//Get lastName
	public String getLastName() {
		return lastName;
	}
	//Set lastName
	public void setLastName(String lastName) throws Exception {
		if (lastName.length() < 3)
			throw new Exception("Input cannot be no less 3 character!"); 
		this.lastName = lastName;
	}
	//Get birthDate
	public java.util.Calendar getBirthDate() {
		return birthDate;
	}
	//Set birthDate
	public void setBirthDate(java.util.Calendar birthDate) {
		this.birthDate = birthDate;
	}
	
	

	//return string information about person
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + getGender()
				+ ", birthDate=" + birthDate.get(Calendar.DATE) + "/" + (birthDate.get(Calendar.MONTH) + 1) + "/" + birthDate.get(Calendar.YEAR) + ", maritalStatus=" + getMaritalStatus() + ", hasDriverLicence="
				+ getHasDriverLicence() + "]";
	}
	
}

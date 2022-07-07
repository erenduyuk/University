import java.util.Calendar;


//Eren Duyuk 150120509

/*The purpose of this class is to create employee object and manage employee related operations*/

public class Employee extends Person {
	private double salary;
	private java.util.Calendar hireDate;
	private Department department;
	public static int numberofEmployees;
	
	
	//construct employee
	public Employee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
		this.salary = salary;
		this.hireDate = hireDate;
		this.department = department;
		numberofEmployees++;
	}
	//construct employee with person object
	public Employee(Person person, double salary, Calendar hireDate, Department department) throws Exception {
		super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(),
				person.getMaritalStatus(), person.getHasDriverLicence());
		this.salary = salary;
		this.hireDate = hireDate;
		this.department = department;
		numberofEmployees++;
	}
	//raise employee's salary with given percent
	public double raiseSalary(double percent) {
		salary = salary + salary * percent;
		return salary;
	}
	//raise employee's salary with given amount
	public double raiseSalary(int amount) {
		salary = salary + amount;
		return salary;
	}
	//get salary
	public double getSalary() {
		return salary;
	}
	//set salary
	public void setSalary(double salary) throws Exception {
		if (salary <= 0)
			throw new Exception("Id cannot be negative!");
			
		this.salary = salary;
	}
	//get hireDate
	public java.util.Calendar getHireDate() {
		return hireDate;
	}
	//set hireDate
	public void setHireDate(java.util.Calendar hireDate) {
		this.hireDate = hireDate;
	}
	//get department
	public Department getDepartment() {
		return department;
	}
	//set department
	public void setDepartment(Department department) {
		this.department = department;
	}
	//get numberOfEmployees
	public static int getNumberofEmployees() {
		return numberofEmployees;
	}
	//set numberOfEmployees
	public static void setNumberofEmployees(int numberofEmployees) throws Exception {
		if (numberofEmployees <= 0)
			throw new Exception("Id cannot be negative!");
		Employee.numberofEmployees = numberofEmployees;
	}
	//return string information about employee
	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", hireDate=" + hireDate.get(Calendar.DATE) + "/" + hireDate.get(Calendar.MONTH) + "/" + hireDate.get(Calendar.YEAR)  + ", department=" + department.getDepartmentName() + "]";
	}

	
	
	
}

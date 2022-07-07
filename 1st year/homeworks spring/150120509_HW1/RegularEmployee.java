import java.util.Calendar;


//Eren Duyuk 150120509

/*The purpose of this class is to create regularEmployee object and manage regularEmployee related operations*/

public class RegularEmployee extends Employee{
	private double performanceScore;
	private double bonus;
	
	
	//construct RegularEmployee
	public RegularEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department, double performanceScore) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
		this.performanceScore = performanceScore;
	}
	//construct RegularEmployee with employee object
	public RegularEmployee(Employee employee, double perfScore) throws Exception {
		super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(),
				employee.getMaritalStatus(), employee.getHasDriverLicence(), employee.getSalary(), employee.getHireDate(),
				employee.getDepartment());
		performanceScore = perfScore;
	}

	
	//get performanceScore
	public double getPerformanceScore() {
		return performanceScore;
	}
	//set performanceScore
	public void setPerformanceScore(double performanceScore) throws Exception {
		if (performanceScore <= 0)
			throw new Exception("Id cannot be negative!");
		this.performanceScore = performanceScore;
	}
	//get bonus
	public double getBonus() {
		return bonus;
	}
	//set bonus
	public void setBonus(double bonus) throws Exception {
		if (bonus <= 0)
			throw new Exception("Id cannot be negative!");
		this.bonus = bonus;
	}
	//return string information about RegularEmployee
	@Override
	public String toString() {
		return "\t\t\t\tPerson Info [id=" + getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", gender=" + getGender() + "]\n" + 
				"\t\t\t\tEmployee Info [salary=" + getSalary() + ", hireDate=" + getHireDate().get(Calendar.DATE) + "/" + (getHireDate().get(Calendar.MONTH) + 1) + "/" + getHireDate().get(Calendar.YEAR) + "]\n" + 
				"\t\t\t\tRegularEmployee Info [performanceScore=" + getPerformanceScore() + ", bonus=" + getBonus() + "]";
	}

	
	
	
	
}

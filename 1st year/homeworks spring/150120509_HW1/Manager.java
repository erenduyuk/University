import java.util.ArrayList;
import java.util.Calendar;


//Eren Duyuk 150120509

/*The purpose of this class is to create manager object and manage manager related operations*/

public class Manager extends Employee{
	private ArrayList<RegularEmployee> regularEmployees = new ArrayList<RegularEmployee>();
	private double bonusBudget;
	
	//construct manager
	public Manager(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department, double bonusBudget) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
		this.bonusBudget = bonusBudget;
	}
	//construct manager with employee object
	public Manager(Employee employee, double bonusBudget) throws Exception {
		super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(),
				employee.getMaritalStatus(), employee.getHasDriverLicence(), employee.getSalary(), employee.getHireDate(),
				employee.getDepartment());
		this.bonusBudget = bonusBudget;
	}
	
	
	//adds Regular Employee to the manager's regularEmployees list
	public void addEmployee(RegularEmployee e) {
		regularEmployees.add(e);
	}
	//removes Regular Employee to the manager's regularEmployees list
	public void removeEmployee(RegularEmployee e) {
		regularEmployees.remove(e);
	}
	
	//to distribute it to the regular employees working in his/her department
	public void distributeBonusBudget() throws Exception {
		double unit = 0;
		double totalSalaryPerformanceScore = 0;
		double bonus = 0;
		for (int i = 0; i < regularEmployees.size(); i++)
			totalSalaryPerformanceScore += regularEmployees.get(i).getSalary() * regularEmployees.get(i).getPerformanceScore();
			
		unit = bonusBudget / totalSalaryPerformanceScore;
		
		for (int i = 0; i < regularEmployees.size(); i++) {
			bonus = unit * regularEmployees.get(i).getSalary() * regularEmployees.get(i).getPerformanceScore();
			bonus = Math.round(bonus * 100) / 100.0;
			regularEmployees.get(i).setBonus(bonus);
		}
	}
	//get regularEmployees
	public ArrayList<RegularEmployee> getRegularEmployees() {
		return regularEmployees;
	}
	//set regularEmployees
	public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {
		this.regularEmployees = regularEmployees;
	}
	//get bonusBudget
	public double getBonusBudget() {
		return bonusBudget;
	}
	//set bonusBudget
	public void setBonusBudget(double bonusBudget) throws Exception {
		if (bonusBudget <= 0)
			throw new Exception("Id cannot be negative!");
		this.bonusBudget = bonusBudget;
	}
	//return string information about manager
	@Override
	public String toString() {
		return "	Manager [id: " + getId() + ", " + getFirstName() + " " + getLastName(); 
				
	}

	
	
}

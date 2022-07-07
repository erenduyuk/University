//Eren Duyuk 150120509

/*the purpose of this class is to determine the payroll of the employee*/
public class Payroll {

	private int workHour;
	private int itemCount;
	
	//Construct a payroll
	public Payroll(int workHour, int itemCount) {
		this.workHour = workHour;
		this.itemCount = itemCount;
	}
	
	//Calculate salary of the employee
	public int calculateSalary() {
		int salary = 0;
		salary = workHour * 3 + itemCount * 2;
		return salary;
	}
	
	//Transcribing information about the employee
	public String toString() {
		return "The work hour is " + workHour + " and the produced item count is " + itemCount + ".";
	}

	
	
}

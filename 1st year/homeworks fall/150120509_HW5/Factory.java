//Eren Duyuk 150120509

/*The purpose of this class is to create factory object and manage factory related operations*/
public class Factory {
	private String name;
	private Employee[] employees;
	private Storage storage;
	private Payroll[] payrolls;
	private double itemPrice;
	
	public Factory(String name, int capacity, double itemPrice) {
		this.name = name;
		storage = new Storage(capacity);
		this.itemPrice = itemPrice;
		employees = new Employee[0];
		payrolls = new Payroll[0];
	}
	
	//Calculate the revenue of the factory
	public double getRevenue() {
		return itemPrice * storage.getItems().length;
	}
	
	//Calculating the total salary due to employees
	public double getPaidSalaries() {
		double sum = 0;
		for(int i = 0; i < payrolls.length; i++) {
			sum += payrolls[i].calculateSalary();
		}
		return sum;
	}
	
	/*This method enables the employee added to the employees array to produce an item with 
	the startShift method and then stores it in the storage.*/
	public void addEmployee(Employee employee) {
		Item[] items = employee.startShift();
		Employee[] newEmployees = employees;
		employees = new Employee[employees.length + 1];
		
		for(int i = 0; i < newEmployees.length; i++) {		
			employees[i] = newEmployees[i];
		}
		employees[employees.length - 1] = employee;
		
		for(int i = 0; i < items.length; i++) {
			storage.addItem(items[i]);
		}
		
	}
	
	/*this method removes a employee with the given id from the employees array 
	 and adds his payroll to the payroll array, if there is no employee 
	 matching the given id, it will warn*/
	public Employee removeEmployee(int id) {
		
		boolean isEmployee = false;
		int index = 0;
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getId() == id) {
				isEmployee = true;
				index = i;
			}
		}
		if (employees.length == 0) { 
			System.out.println("There are no employees!");
			return null;
		}
		else if (!(isEmployee)) {
			System.out.println("Employee does not exist!");
			return null; 
		}
		else {
			Employee[] newEmployees = employees;
			employees = new Employee[employees.length - 1];
			
			for (int i = 0; i < index; i++) {
				employees[i] = newEmployees[i];
			}
			for (int i = index; i < employees.length; i++) {
				employees[i] = newEmployees[i + 1];
			}
			
			addPayroll(newEmployees[index].endShift());
			return newEmployees[index];
			
		}
	}
	
	//Adds the employee's payroll to the payroll array
	private void addPayroll(Payroll payroll) {
		Payroll[] newPayrolls = new Payroll[payrolls.length + 1];
		
			for(int i = 0; i < payrolls.length; i++) {
				newPayrolls[i] = payrolls[i];
			}
			newPayrolls[newPayrolls.length - 1] = payroll;
			payrolls = newPayrolls;
	}
	
}

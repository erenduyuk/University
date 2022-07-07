import java.util.ArrayList;
import java.util.Calendar;

//Eren Duyuk 150120509

/*The purpose of this class is to create salesEmployee object and manage salesEmployee related operations*/

public class SalesEmployee extends RegularEmployee {
	private ArrayList<Product> sales = new ArrayList<Product>();
	public static int numberOfSalesEmployees;
	
	//construct salesEmployee
	public SalesEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department, double performanceScore, ArrayList<Product> sales) throws Exception {
		super(id, firstName, lastName,gender, birthDate,maritalStatus,
			hasDriverLicence, salary, hireDate, department,performanceScore);
		this.sales = sales;
		numberOfSalesEmployees++;
	}
	//construct salesEmployee with regularEmployee object
	public SalesEmployee(RegularEmployee re, ArrayList<Product> sales) throws Exception {
		super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(),
				re.getMaritalStatus(), re.getHasDriverLicence(), re.getSalary(), re.getHireDate(),
				re.getDepartment(), re.getPerformanceScore());
		this.sales = sales;
		numberOfSalesEmployees++;
	}
	//adds product to the salesEmployee's products list
	public boolean addSale(Product sale) {
		return sales.add(sale);
		
	}
	//removes product to the salesEmployee's products list
	public boolean removeSale(Product sale) {
		return sales.remove(sale);
	}
	//get sales list
	public ArrayList<Product> getSales() {
		return sales;
	}
	//set sales list
	public void setSales(ArrayList<Product> sales) {
		this.sales = sales;
	}
	//get numberOfSalesEmployees
	public static int getNumberOfSalesEmployees() {
		return numberOfSalesEmployees;
	}
	//set numberOfSalesEmployees
	public static void setNumberOfSalesEmployees(int numberOfSalesEmployees) throws Exception {
		if (numberOfSalesEmployees <= 0)
			throw new Exception("Id cannot be negative!");
		SalesEmployee.numberOfSalesEmployees = numberOfSalesEmployees;
	}
	//return string information about salesEmployee
	@Override
	public String toString() {
		String productsToString = "";
		for (int i = 0; i < sales.size(); i++) {
			productsToString += sales.get(i).toString();
			if (i != sales.size() - 1)
				productsToString += ", ";
		}
		return "\t\t\t\tPerson Info [id=" + getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", gender=" + getGender() + "]\n" + 
				"\t\t\t\tEmployee Info [salary=" + getSalary() + ", hireDate=" + getHireDate().get(Calendar.DATE) + "/" + (getHireDate().get(Calendar.MONTH) + 1) + "/" + getHireDate().get(Calendar.YEAR) + "]\n" + 
				"\t\t\t\tRegularEmployee Info [performanceScore=" + getPerformanceScore() + ", bonus=" + getBonus() + "]\n" + 
				"\t\t\t\t[" + productsToString + "]";
	}

	
	
	
}

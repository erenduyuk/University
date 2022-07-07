import java.util.ArrayList;
import java.util.Calendar;

//Eren Duyuk 150120509

/*The purpose of this class is to create customer object and manage customer related operations*/

public class Customer extends Person {
	private  ArrayList<Product> products = new ArrayList<Product>();
	
	//construct customer
	public Customer(int id, String firstName, String lastName, String gender, Calendar birthDate, 
			String maritalStatus,String hasDriverLicence, ArrayList<Product> products) throws Exception {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
		this.products = products;
	}
	
	//construct customer with person object
	public Customer(Person person, ArrayList<Product> products) throws Exception {
		super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(),
				person.getMaritalStatus(), person.getHasDriverLicence());
		this.products = products;
	}
	//get products
	public ArrayList<Product> getProducts() {
		return products;
	}
	//set products
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	//return string information about customer
	@Override
	public String toString() {
		String productsToString = "";
		for (int i = 0; i < products.size(); i++) {
			productsToString += products.get(i).toString();
			if (i != products.size() - 1)
				productsToString += ", ";
		}
		return "Customer [id: " + getId() + " products=[" + productsToString + "]]";
	}

	
	
	
	
	
}

//import io and util
import java.io.*;
import java.util.*;

//Eren Duyuk 150120509

/*The purpose of this class is to test if other classes work.*/

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//create File and scanner for input
		File f = new File("input");
		Scanner input = new Scanner(f);
		
		//create arraylists	
		ArrayList<Person> persons = new ArrayList<Person>();
		ArrayList<Department> departments = new ArrayList<Department>();
		ArrayList<Product> products = new ArrayList<Product>();
		ArrayList<Project> projects = new ArrayList<Project>();
		
	//try block to find error
	try {	
		//create obejects
		while(input.hasNext()) {
			String type = input.next();
			
			//create department object and add list
			if (type.equals("Department")) {
				departments.add(new Department(input.nextInt(), input.next()));
			}
			
			//create project objects and add list
			else if (type.equals("Project")) {
				String name = input.next();
				String startDate = input.next();
				String state = input.next();
				
				//format calendar
				Calendar calendar = new GregorianCalendar();
				String[] splitDate = new String[3];
				splitDate = startDate.split("/");
				calendar.set(Integer.parseInt(splitDate[2]), Integer.parseInt(splitDate[1]) - 1, Integer.parseInt(splitDate[0]));
						
				projects.add(new Project(name, calendar, state));
			}
			
			//create product objects and add list
			else if (type.equals("Product")) {
				String name = input.next();
				String saleDate = input.next();
				double price = input.nextDouble();
				
				//format calendar
				Calendar calendar = new GregorianCalendar();
				String[] splitDate = new String[3];
				splitDate = saleDate.split("/");
				calendar.set(Integer.parseInt(splitDate[2]), Integer.parseInt(splitDate[1]) - 1, Integer.parseInt(splitDate[0]));
				
				products.add(new Product(name, calendar, price));
			}
			
			//create person objects and add list
			else if (type.equals("Person")) {
				String firstName = input.next();
				String lastName = input.next();
				int id = input.nextInt();
				String gender = input.next();
				String birthDate = input.next();
				String maritalStatus = input.next();
				String driverLicence = input.next();
				
				
				//format calendar
				Calendar calendar = new GregorianCalendar();
				String[] splitDate = new String[3];
				splitDate = birthDate.split("/");
				calendar.set(Integer.parseInt(splitDate[2]), Integer.parseInt(splitDate[1]) - 1, Integer.parseInt(splitDate[0]));
				
				persons.add(new Person(id, firstName, lastName, gender, calendar, maritalStatus, driverLicence));
				
			}
			
			//create employee objects and add list
			else if (type.equals("Employee")) {
				int id = input.nextInt();
				double salary = input.nextDouble();
				String hireDate = input.next();
				String department = input.next();
				
				//format calendar
				Calendar calendar = new GregorianCalendar();
				String[] splitDate = new String[3];
				splitDate = hireDate.split("/");
				calendar.set(Integer.parseInt(splitDate[2]), Integer.parseInt(splitDate[1]) - 1, Integer.parseInt(splitDate[0]));
				
				
				for (Person person : persons) {
					if (person.getId() == id) {
						for (Department dep : departments) {
							if (dep.getDepartmentName().equals(department)) {
									
								persons.add(new Employee(person, salary, calendar, dep));
								persons.remove(person);
							}
						}
						break;
					}
				}
			}
			
			//create manager objects and add list
			else if (type.equals("Manager")) {
				int id = input.nextInt();
				double bonusBudget = input.nextDouble();
				
				
				for (Person person : persons) {
					if (person.getId() == id) {
						persons.add(new Manager((Employee)person, bonusBudget));
						persons.remove(person);
						break;
					}
				}
				
				
				
			}
			
			//create regular employee objects and add list
			else if (type.equals("RegularEmployee")) {
				int id = input.nextInt();
				double performanceScore = input.nextDouble();
				
				for (Person person : persons) {
					if (person.getId() == id) {
						persons.add(new RegularEmployee((Employee)person, performanceScore));
						persons.remove(person);
						break;
					}		
				}
			}
			
			//create sales employee objects and add list
			else if (type.equals("SalesEmployee")) {
				int id = input.nextInt();
				String productName = input.nextLine();
				String[] splitProduct = productName.split(" ");
				ArrayList<Product> productSales = new ArrayList<Product>();
				
				for (int i = 0; i < splitProduct.length; i++) {
					for (Product product : products) {
						if (splitProduct[i].equals(product.getProductName()))
							productSales.add(product);
					}
				}
				
				for (Person person : persons) {
					if (person.getId() == id) {
						persons.add(new SalesEmployee((RegularEmployee)person, productSales));
						persons.remove(person);
						break;
					}
						
			}	
				}
			
			//create developer objects and add list
			else if (type.equals("Developer")) {
				int id = input.nextInt();
				String projectName = input.nextLine();
				String[] splitProject = projectName.split(" ");
				ArrayList<Project> projectsDeveloper = new ArrayList<Project>();
				
				for (int i = 0; i < splitProject.length; i++) {
					for (Project project : projects) {
					if (splitProject[i].equals(project.getProjectName()))
						projectsDeveloper.add(project);
					}
				}
				
				
				for (Person person : persons) {
					if (person.getId() == id) {
						persons.add(new Developer((RegularEmployee)person, projectsDeveloper));
						persons.remove(person);
						break;
					}
						
			}
				
				
				
			}
			
			//create customer objects and add list
			else if (type.equals("Customer")) {
				int id = input.nextInt();
				String productName = input.nextLine();
				String[] splitProduct = productName.split(" ");
				ArrayList<Product> productSales = new ArrayList<Product>();
				
				for (int i = 0; i < splitProduct.length; i++) {
					for (Product product : products) {
						if (splitProduct[i].equals(product.getProductName()))
							productSales.add(product);
					}
				}
			
				for (Person person : persons) {
					if (person.getId() == id) {
						persons.add(new Customer(person, productSales));
						persons.remove(person);
						break;
					}		
			}			
			}			
		}
		
		//close the input
		input.close();
		
		//add regular employee in same department to manager's regularEmployee list
		for (Person manager : persons) {
			if (manager instanceof Manager) {
				for (Person regularEmployee : persons) {
					if (regularEmployee instanceof RegularEmployee && ((Manager) manager).getDepartment().equals(((RegularEmployee) regularEmployee).getDepartment())) {
						((Manager) manager).addEmployee((RegularEmployee) regularEmployee);	
					}
				}
			}
		}
		
		//raise salary for manager
		for (Person manager : persons) {
			if (manager instanceof Manager) {
				((Manager) manager).distributeBonusBudget();
				((Manager) manager).raiseSalary(0.2);
			}
		}
		
		//raise salary for regular employee
		for (Person reEmployee : persons) {
			if (reEmployee instanceof RegularEmployee && !(reEmployee instanceof Developer) && !(reEmployee instanceof SalesEmployee)) {
				((RegularEmployee) reEmployee).raiseSalary(0.3);
			}
		}
		
		//raise salary for developer
		for (Person developer : persons) {
			if (developer instanceof Developer) {
				((Developer) developer).raiseSalary(0.23);
			}
		}
		
		//raise salary for salesEmployee
		for (Person saEmployee : persons) {
			if (saEmployee instanceof SalesEmployee) {
				((SalesEmployee) saEmployee).raiseSalary(0.18);
			}
		}
		
		//raise salary for salesEmployee who has maximum value of sales
		double saleValue = 0;
		double tempSaleValue = 0;
		for (Person saEmployee : persons) {
			if (saEmployee instanceof SalesEmployee) {
				for (Product product : ((SalesEmployee) saEmployee).getSales()) {
					tempSaleValue += product.getPrice();
				}
				if (tempSaleValue > saleValue) {
					saleValue = tempSaleValue;
					tempSaleValue = 0;
				}
			}
		}
		double tempSaleValue2 = 0;
		for (Person saEmployee : persons) {
			if (saEmployee instanceof SalesEmployee) {
				for (Product product : ((SalesEmployee) saEmployee).getSales()) {
					tempSaleValue2 += product.getPrice();
				}
				if (tempSaleValue2 == saleValue) {
					((SalesEmployee) saEmployee).raiseSalary(1000);		
				}
			}
		}
	}
	//catch for exception
	catch(Exception ex) {
		System.out.println(ex.getMessage());
	}
		//create file and printWriter
		java.io.File file = new java.io.File("output");
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		
		//print department information
		for (Department department : departments) {
		output.println("************************************************");
		output.println(department.toString());
		
		//print manager information
		for (Person person : persons) {
			if (person instanceof Manager && ((Manager) person).getDepartment().equals(department)) {
				output.println(person.toString());
			} 	
		}
		
		//print numberEmployeeInDepartment
		int numberOfEmployeeInDepartment = 0;
		for (Person person : persons) {
			if (person instanceof RegularEmployee && ((RegularEmployee) person).getDepartment().equals(department)) {
				
				numberOfEmployeeInDepartment++;
			}
		}
		output.println("\t\t# of Employees: " + numberOfEmployeeInDepartment + "]");
		int queueOfEmployee = 1;
			
			//print developer information
			for (Person person : persons) {
				if (person instanceof Developer && ((Developer) person).getDepartment().equals(department)) {
					output.println("\t\t\t" + queueOfEmployee + ". Developer");
					queueOfEmployee++;
					output.println(person.toString());	
				}	
			}
			//print salesEmployee information
			for (Person person : persons) {
				if (person instanceof SalesEmployee && ((SalesEmployee) person).getDepartment().equals(department)) {
					output.println("\t\t\t" + queueOfEmployee + ". SalesEmployee");
					queueOfEmployee++;
					output.println(person.toString());
				}
				
			}
			
			//print regularEmployee information
			for (Person person : persons) {
				if (person instanceof RegularEmployee && !(person instanceof Developer) && !(person instanceof SalesEmployee) && ((RegularEmployee) person).getDepartment().equals(department)) {
					output.println("\t\t\t" + queueOfEmployee + ". RegularEmployee");
					queueOfEmployee++;
					output.println(person.toString());	
				}
			}
			output.println();
		}
		
		//print customer information
		output.println("\n\n**********************CUSTOMERS************************");
		for (Person person : persons) {
			if (person instanceof Customer) {
				output.println(person.toString());
			}
		}
		
		//print people information
		output.println("\n\n**********************PEOPLE************************");
		for (Person person : persons) {
			if (!(person instanceof Employee) && !(person instanceof Customer)) {
				output.println(person.toString());
			}
		}
		//close the output
		output.close();
	}	
}

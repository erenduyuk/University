//Eren Duyuk 150120509

/*the purpose of this class is to create employee object 
 and hold worker related methods and information*/
public class Employee {

	private int id;
	private String name;
	private String surname;
	private int workHour;
	private int speed;
	private Item[] items;
	private Payroll payroll;
	
	//Construct employee
	public Employee(int id, String name, String surname, int workHour, int speed) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.workHour = workHour;
		this.speed = speed;
		items = new Item[0];
	}
	
	//To create the items that the employee produces during his working time, using the item class
	public Item[] startShift() {
		items = new Item[workHour * speed];
		
		for (int i = 0; i < items.length; i++) {
			items[i] = new Item((int)(Math.random() * 100 + 1));
		}
		return items;
	}
	
	//Create payroll for the employee using payroll class
	public Payroll endShift() {
		payroll = new Payroll(workHour, items.length);
		return payroll;
	}
	
	//Transcribing information about the employee
	public String toString() {
		return "This is the employee with id " + id + " speed " + speed + ". " + payroll.toString();
		}
	
	// Get the id number of the employee
	public int getId() {
		return id;
	}

	
	
}

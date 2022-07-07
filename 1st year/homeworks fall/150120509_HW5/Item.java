//Eren Duyuk 150120509

/*the purpose of this class is to declare and create the product object 
besides to determine the number of products produced*/
public class Item {
	
	private int id;
	public static int numberOfItems;
	
	//Construct a item and increase the number of products
	public Item(int id) {
		this.id = id;
		numberOfItems++;
	}

	
}

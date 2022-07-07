//Eren Duyuk 150120509

/*The purpose of this class is to determine the capacity of 
 the factory and to transfer the items to the storage*/
public class Storage {
	private int capacity;
	private Item[] Items;
	
	public Storage(int capacity) {
		this.capacity = capacity;
		Items = new Item[0];
	}
	
	//To transfer the items to the strorage
	public void addItem(Item item) {
		Item[] newItem = Items;
		Items = new Item[newItem.length + 1];
		
		for (int i = 0; i < newItem.length ; i++) {
			Items[i] = newItem[i];
		}
		Items[Items.length - 1]	= item;
	}

	
	// Get the id number of items in storage
	public Item[] getItems() {
		return Items;
	}

	
	
}

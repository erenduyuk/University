// Eren Çetin 150120008
// Eren Duyuk 150120509
// This class holds the information and methods of the cells on the game board.
public class InfoNode {
	
	 private int id;
	 private String type;
	 private String property;
	
	// Constructor of cell
	public InfoNode(int id, String type, String property) {
		this.id = id;
		this.type = type;
		this.property = property;
	}
	// Getter and setter methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
	

}

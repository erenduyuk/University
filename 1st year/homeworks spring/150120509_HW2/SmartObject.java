//Eren Duyuk 150120509

/*The purpose of this abstract class is to include methods of smart objects*/


public abstract class SmartObject {
	private String alias;
	private String macId;
	private String IP;
	private boolean connectionStatus;
	
	//construct SmartObject
	public SmartObject() {
		
	}
	//connect SmartObject to SmartHome
	public boolean connect(String IP) {
		this.IP = IP;
		System.out.println(alias + " connection established");
		connectionStatus = true;
		return true;
	}
	//disconnect SmartObject to SmartHome
	public boolean disconnect() {
		connectionStatus = false;
		IP = "";
		System.out.println(alias + " disconnected");
		return true;
	}
	//print information of SmartObject
	public void SmartObjectToString() {
		String whatDevice = "";
		if (alias.contains("Light"))
			whatDevice = "SmartLight";
		else if (alias.contains("Plug"))
			whatDevice = "SmartPlug";
		else if (alias.contains("Camera"))
			whatDevice = "SmartCamera";
		System.out.println("This is " + whatDevice + " device " + alias);
		System.out.println("\tMacId: " + macId);
		System.out.println("\tIP: " + IP);
	}
	//check connection between SmartObject and SmartHome
	public boolean controlConnection() {
		if (connectionStatus == false) {
			System.out.println("This device is not connected. " + alias);
			return false;
		}
		else
			return true;
	}
	//abstract methods
	public abstract boolean testObject();
		
	
	public abstract boolean shutDownObject();
	
	
	//getter and setter methods
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getMacId() {
		return macId;
	}

	public void setMacId(String macId) {
		this.macId = macId;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public boolean isConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(boolean connectionStatus) {
		this.connectionStatus = connectionStatus;
	}
		
	
	
}

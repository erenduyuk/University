//Eren Duyuk 150120509

/*The purpose of this class is to create SmartCamera object and manage SmartCamera related operations*/


public class SmartCamera extends SmartObject implements MotionControl, Comparable<SmartCamera> {
	private boolean status;
	private int batteryLife;
	private boolean nightVision;
	
	//construct smartcamera
	public SmartCamera(String alias, String macId, boolean nightVision, int batteryLife) {
		setAlias(alias);
		setMacId(macId);
		this.batteryLife = batteryLife;
		this.nightVision = nightVision;
	}
	//if camera has night vision and isDay is false, record on camera if isDay is false, record on camera and print information
	public void recordOn(boolean isDay) {
		if (!super.getIP().equals("")) {
			if (isDay == false && nightVision == false) {
				System.out.println("Sorry! Smart Camera - " + getAlias() + " does not have night vision feature.");
				status = false;
			}
			else if (status) {
				System.out.println("Smart Camera - " + getAlias() + " has been already turned on");
			}
			else if (!status) {
				System.out.println("Smart Camera - " + getAlias() + " is turned on now");
				status = true;
			}
		}
	}
	//record off camera and print information
	public void recordOff() {
		if (!status) {
			System.out.println("Smart Camera - " + getAlias() + " has been already turned off");
		}
		else if (status) {
			System.out.println("Smart Camera - " + getAlias() +  " is turned off now");
			status = false;
		}
	}
	//test connection, turn on ,turn off and print information about smartcamera
	public boolean testObject() {
		if (!super.getIP().equals("")) {
			System.out.println("Test is starting for SmartCamera");
			super.SmartObjectToString();
			System.out.println("Test is starting for SmartCamera day time");
			recordOn(true);
			recordOff();
			System.out.println("Test is starting for SmartCamera night time");
			recordOn(false);
			recordOff();
			System.out.println("Test completed for SmartCamera\n");
			return true;
		}
		else {
			return false;
		}
	}
	//if smartcamera has light turned, it will record off
	public boolean shutDownObject() {
		if (super.getIP().equals("")) {
			recordOff();
			super.SmartObjectToString();
			return true;
		}
		else {
			return false;
		}
	}
	//check motion and print information
	public boolean controlMotion(boolean hasMotion, boolean isDay) {
		if (hasMotion == false) {
			System.out.println("Motion not detected!");
			return false;
		}
		else {
			System.out.println("Motion detected!");
			recordOn(isDay);
			return true;
		}
	}
	//compare battery of smart cameras
	public int compareTo(SmartCamera smartCamera) {
		if (this.getBatteryLife() > smartCamera.getBatteryLife())
			return 1;
		else if (this.getBatteryLife() == smartCamera.getBatteryLife())
			return 0;
		else 
			return -1;
	}
	//print information about smart camera
	public String toString() {
		return "SmartCamera -> " + getAlias() + "'s battery life is " + batteryLife + " status is recording";
	}
	
	
	//getter and setter methods
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getBatteryLife() {
		return batteryLife;
	}

	public void setBatteryLife(int batteryLife) {
		this.batteryLife = batteryLife;
	}

	public boolean isNightVision() {
		return nightVision;
	}

	public void setNightVision(boolean nightVision) {
		this.nightVision = nightVision;
	}
	
	
}

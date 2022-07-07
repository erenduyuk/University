import java.util.ArrayList;

//Eren Duyuk 150120509

/*The purpose of this class is to create SmartHome object and manage SmartHome related operations*/


public class SmartHome {
	private ArrayList<SmartObject> smartObjectList = new ArrayList<>();
	
	//construct smarthome
	public SmartHome() {
		
	}
	//add new smartobject to smartObjectList, assigns IP and test smartobject
	public boolean addSmartObject(SmartObject smartObject) {
		System.out.println("--------------------------------------------------------------------------\n" +
				"--------------------------------------------------------------------------\n" + 
				"Adding new SmartObject\n" +
				"--------------------------------------------------------------------------");
		smartObjectList.add(smartObject);
		String IP = "10.0.0." + (100 + smartObjectList.indexOf(smartObject));
		smartObject.connect(IP);
		smartObject.testObject();
		if (smartObjectList.contains(smartObject))
			return true;
		else
			return false;
	}
	
	//remove the smartobject from smartObjectList
	public boolean removeSmartObject(SmartObject smartObject) {
		System.out.println("--------------------------------------------------------------------------\n" +
				"--------------------------------------------------------------------------\n" + 
				"Removing a SmartObject\n" +
				"--------------------------------------------------------------------------");
		smartObject.disconnect();
		smartObjectList.remove(smartObject);
		if (!smartObjectList.contains(smartObject))
			return true;
		else
			return false;
	}
	
	//invoke methods of LocationControl interface
	public void controlLocation(boolean onCome) {
		if (onCome) {
			System.out.println("--------------------------------------------------------------------------\n" +
					"--------------------------------------------------------------------------\n" + 
					"LocationControl: OnCome\n" +
					"--------------------------------------------------------------------------");
			for (SmartObject light : smartObjectList) {
				if (light instanceof SmartLight) {
					((SmartLight) light).onCome();
				}
			}
		}
		else if (!onCome) {
			System.out.println("--------------------------------------------------------------------------\n" +
					"--------------------------------------------------------------------------\n" + 
					"LocationControl: OnLeave\n" +
					"--------------------------------------------------------------------------");
			for (SmartObject light : smartObjectList) {
				if (light instanceof SmartLight) {
					((SmartLight) light).onLeave();
				}
			}
		}
	}
	//invoke methods of MotionControl interface
	public void controlMotion(boolean hasMotion, boolean isDay) {
		System.out.println("--------------------------------------------------------------------------\n" +
				"--------------------------------------------------------------------------\n" + 
				"MotionControl: HasMotion, isDay\n" +
				"--------------------------------------------------------------------------");
		for (SmartObject camera : smartObjectList) {
			if (camera instanceof SmartCamera) {
				((SmartCamera) camera).controlMotion(hasMotion, isDay);
			}
		}
	}
	//invoke methods of Programmable interface
	public void controlProgrammable() {
		System.out.println("--------------------------------------------------------------------------\n" +
				"--------------------------------------------------------------------------\n" + 
				"Programmable: runProgram\n" +
				"--------------------------------------------------------------------------");
		for (SmartObject light : smartObjectList) {
			if (light instanceof SmartLight && ((SmartLight) light).isProgramAction()) {
				((SmartLight) light).runProgram();

			}
		}
		for (SmartObject plug : smartObjectList) {
			if (plug instanceof SmartPlug && ((SmartPlug) plug).isProgramAction()) {
				((SmartPlug) plug).runProgram();
			}
		}
	}
	//invoke set timer method in smartplug and smartlight with given seconds
	public void controlTimer(int seconds) {
		System.out.println("--------------------------------------------------------------------------\n" +
				"--------------------------------------------------------------------------\n" + 
				"Programmable: Timer = 10 seconds\n" +
				"--------------------------------------------------------------------------");
		for (SmartObject light : smartObjectList) {
			if (light instanceof SmartLight) {
				((SmartLight) light).setTimer(seconds);
			}
		}
		for (SmartObject plug : smartObjectList) {
			if (plug instanceof SmartPlug) {
				((SmartPlug) plug).setTimer(seconds);
			}
		}
	}
	//invoke set timer method in smartplug and smartlight with 5 or 10 seconds randomly
	public void controlTimerRandomly() {
		System.out.println("--------------------------------------------------------------------------\n" +
				"--------------------------------------------------------------------------\n" + 
				"Programmable: Timer = Programmable: Timer = 5 or 10 seconds randomly\n" +
				"--------------------------------------------------------------------------");
		int[] randomlyTime = { 5, 10};
		for (SmartObject light : smartObjectList) {
			if (light instanceof SmartLight) {
				((SmartLight) light).setTimer(randomlyTime[(int)(Math.random() * randomlyTime.length)]);
			}
		}
		for (SmartObject plug : smartObjectList) {
			if (plug instanceof SmartPlug) {
				((SmartPlug) plug).setTimer(randomlyTime[(int)(Math.random() * randomlyTime.length)]);
			}
		}
	}
	
	//sorts cameras by battery
	public void sortCameras() {
		System.out.println("--------------------------------------------------------------------------\n" +
				"--------------------------------------------------------------------------\n" + 
				"Sort Smart Cameras\n" +
				"--------------------------------------------------------------------------");
		for (SmartObject camera : smartObjectList) {
			if (camera instanceof SmartCamera) {
				for (SmartObject camera2 : smartObjectList) {
					if (camera2 instanceof SmartCamera) {
						if (((SmartCamera) camera).compareTo((SmartCamera)camera2) == 1) {
							smartObjectList.set(smartObjectList.indexOf(camera), camera2);
							smartObjectList.set(smartObjectList.lastIndexOf(camera2), camera);
						}
					}
				}
			}
		}
		for (SmartObject camera : smartObjectList) {
			if (camera instanceof SmartCamera) {
				System.out.println(camera.toString());
			}
		}
	}
	
	
	//getter and setter methods
	public ArrayList<SmartObject> getSmartObjectList() {
		return smartObjectList;
	}

	public void setSmartObjectList(ArrayList<SmartObject> smartObjectList) {
		this.smartObjectList = smartObjectList;
	}
	
	
}	

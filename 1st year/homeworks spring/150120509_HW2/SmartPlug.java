import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

//Eren Duyuk 150120509

/*The purpose of this class is to create SmartPlug object and manage SmartPlug related operations*/


public class SmartPlug extends SmartObject implements Programmable {
	private boolean status;
	private Calendar programTime = new GregorianCalendar();
	private boolean programAction;
	
	//construct SmartPlug
	public SmartPlug(String alias, String macId) {
		setAlias(alias);
		setMacId(macId);
	}
	//turn on plug and print information about when turn on
	public void turnOn() {
		if (controlConnection()) {
			setProgramTime(new GregorianCalendar());
			if (status) {
				System.out.println("Smart Plug - " + getAlias() + " has been already turned on");
			}
			else if (!status) {
				System.out.println("Smart Plug - " + getAlias() + " is turned on now (Current time: " + programTime.get(Calendar.HOUR_OF_DAY) + ":" + programTime.get(Calendar.MINUTE) + 
						":" + programTime.get(Calendar.SECOND) + ")" );
				status = true;
			
			}
		}
	}
	//turn off plug and print information about when turn off
	public void turnOff() {
		if (controlConnection()) {
			setProgramTime(new GregorianCalendar());
			if (!status) {
				System.out.println("Smart Plug - " + getAlias() + " has been already turned off");
			}
			else if (status) {
				System.out.println("Smart Plug - " + getAlias() + " is turned off now (Current time: " + programTime.get(Calendar.HOUR_OF_DAY) + ":" + programTime.get(Calendar.MINUTE) + 
						":" + programTime.get(Calendar.SECOND) + ")" );
				status = false;
			}
		}
	}
	//test connection, turn on ,turn off and print information about smartplug
	public boolean testObject() {
		if (controlConnection()) {
			System.out.println("Test is starting for SmartPlug");
			super.SmartObjectToString();
			turnOn();
			turnOff();
			System.out.println("Test completed for SmartPlug\n");
			return true;
		}
		else {
			return false;
		}
	}
	//if smartplug has light turned, it will turn off
	public boolean shutDownObject() {
		if (super.getIP().equals("")) {
			turnOff();
			super.SmartObjectToString();
			return true;
		}
		else {
			return false;
		}
	}
	//set time for next action that turn off or turn on
	public void setTimer(int seconds) {
		if (controlConnection()) {
			setProgramTime(new GregorianCalendar());
			if (status) {
				System.out.println("Smart Plug - " + getAlias() + " will be turned off " + seconds + " seconds later! (Current time: " + programTime.get(Calendar.HOUR_OF_DAY) + ":" + programTime.get(Calendar.MINUTE) + 
						":" + programTime.get(Calendar.SECOND) + ")" );
				programTime.add(Calendar.SECOND, seconds);
				status = false;
				programAction = true;
			}
			else if (!status) {
				System.out.println("Smart Plug - " + getAlias() + " will be turned on " + seconds + " seconds later! (Current time: " + programTime.get(Calendar.HOUR_OF_DAY) + ":" + programTime.get(Calendar.MINUTE) + 
						":" + programTime.get(Calendar.SECOND) + ")" );
				programTime.add(Calendar.SECOND, seconds);
				status = true;
				programAction = true;
			}
		}
	}
	//cancel timer and programTime will be null
	public void cancelTimer() {
		if (controlConnection()) {
			setProgramTime(null);
			programAction = false;
		}
	}
	//run program and if smartlight has light turned, it will turn off or if smartlight hasn't light turned, it will turn on
	public void runProgram() {
		if ( getProgramTime().get(Calendar.SECOND) == new GregorianCalendar().get(Calendar.SECOND)&&
				getProgramTime().get(Calendar.MINUTE) == new GregorianCalendar().get(Calendar.MINUTE))
			programAction = false;
		if (controlConnection() && getProgramTime().get(Calendar.SECOND) == new GregorianCalendar().get(Calendar.SECOND) && 
				 getProgramTime().get(Calendar.MINUTE) == new GregorianCalendar().get(Calendar.MINUTE) && !programAction) {
			System.out.println("RunProgram -> Smart Plug - " + getAlias());
			if (status == true && !programTime.equals(null)) {
				turnOff();
				setProgramTime(null);
			}
			else if (status == false && !programTime.equals(null)) {
				turnOn();
				setProgramTime(null);
			}
		}
	}
	
	
	//getter and setter methods
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Calendar getProgramTime() {
		return programTime;
	}

	public void setProgramTime(Calendar programTime) {
		this.programTime = programTime;
	}

	public boolean isProgramAction() {
		return programAction;
	}

	public void setProgramAction(boolean programAction) {
		this.programAction = programAction;
	}
	
	
}

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


//Eren Duyuk 150120509

/*The purpose of this class is to create SmartLight object and manage SmartLight related operations*/

public class SmartLight extends SmartObject implements LocationControl, Programmable {
	private boolean hasLightTurned;
	private Calendar programTime = new GregorianCalendar();
	private boolean programAction;
	
	//construct SmartLight
	public SmartLight(String alias, String macId) {
		setAlias(alias);
		setMacId(macId);
	}
	//turn on light and print information about when turn on
	public void turnOnLight() {
		if (controlConnection()) {
			setProgramTime(new GregorianCalendar());
			if (hasLightTurned) {
				System.out.println("Smart Light - " + getAlias() + " has been already turned on");
			}
			else if (!hasLightTurned) {
				System.out.println("Smart Light - " + getAlias() + " is turned on now (Current time: " + programTime.get(Calendar.HOUR_OF_DAY) + ":" + programTime.get(Calendar.MINUTE) + 
						":" + programTime.get(Calendar.SECOND) + ")" );
				hasLightTurned = true;	
				
			}
		}
	}
	//turn off light and print information about when turn off
	public void turnOffLight() {
		if (controlConnection()) {
			setProgramTime(new GregorianCalendar());
			if (!hasLightTurned) {
				System.out.println("Smart Light - " + getAlias() + " has been already turned off");
			}
			else if (hasLightTurned) {
				System.out.println("Smart Light - " + getAlias() + " is turned off now (Current time: " + programTime.get(Calendar.HOUR_OF_DAY) + ":" + programTime.get(Calendar.MINUTE) + 
						":" + programTime.get(Calendar.SECOND) + ")" );
				hasLightTurned = false;
				
			}
		}
	}
	//test connection, turn on ,turn off and print information about smartlight
	public boolean testObject() {
		if (controlConnection()) {
			System.out.println("Test is starting for SmartLight");
			super.SmartObjectToString();
			turnOnLight();
			turnOffLight();
			System.out.println("Test completed for SmartLight\n");
			return true;
		}
		else {
			return false;
		}
	}
	//if smartlight has light turned, it will turn off
	public boolean shutDownObject() {
		if (super.getIP().equals("")) {
			turnOffLight();
			super.SmartObjectToString();
			return true;
		}
		else {
			return false;
		}
	}
	//print information about smartlight and turn off smartlight
	public void onLeave() {
		if (controlConnection()) {
			System.out.println("On Leave -> Smart Light - " + getAlias());
			turnOffLight();
		}
	}
	//print information about smartlight and turn on smartlight
	public void onCome() {
		if (controlConnection()) {
			System.out.println("On Come -> Smart Light - " + getAlias());
			turnOnLight();
		}
	}
	//set time for next action that turn off or turn on
	public void setTimer(int seconds) {
		if (controlConnection()) {
			setProgramTime(new GregorianCalendar());
			if (hasLightTurned) {
				setProgramTime(new GregorianCalendar());
				System.out.println("Smart light - " + getAlias() + " will be turned off " + seconds + " seconds later! (Current time: " + programTime.get(Calendar.HOUR_OF_DAY) + ":" + programTime.get(Calendar.MINUTE) + 
						":" + programTime.get(Calendar.SECOND) + ")" );
				programTime.add(Calendar.SECOND, seconds);
				programAction = true;
			}
			else if (!hasLightTurned) {
				setProgramTime(new GregorianCalendar());
				System.out.println("Smart light - " + getAlias() + " will be turned on " + seconds + " seconds later! (Current time: " + programTime.get(Calendar.HOUR_OF_DAY) + ":" + programTime.get(Calendar.MINUTE) + 
						":" + programTime.get(Calendar.SECOND) + ")" );
				programTime.add(Calendar.SECOND, seconds);
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
		if (getProgramTime().get(Calendar.SECOND) == new GregorianCalendar().get(Calendar.SECOND) && 
				 getProgramTime().get(Calendar.MINUTE) == new GregorianCalendar().get(Calendar.MINUTE))
			programAction = false;
		if (controlConnection() && getProgramTime().get(Calendar.SECOND) == new GregorianCalendar().get(Calendar.SECOND) && 
				 getProgramTime().get(Calendar.MINUTE) == new GregorianCalendar().get(Calendar.MINUTE) && !programAction) {
			System.out.println("RunProgram -> Smart Light - " + getAlias());
			if (hasLightTurned == true && !programTime.equals(null)) {
				turnOffLight();
				setProgramTime(null);
			}
			else if (hasLightTurned == false && !programTime.equals(null)) {
				turnOnLight();
				setProgramTime(null);
			}
		}
	}
	
	//getter and setter methods
	public boolean isHasLightTurned() {
		return hasLightTurned;
	}

	public void setHasLightTurned(boolean hasLightTurned) {
		this.hasLightTurned = hasLightTurned;
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

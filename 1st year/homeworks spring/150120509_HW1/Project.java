import java.util.Calendar;


//Eren Duyuk 150120509

/*The purpose of this class is to create project object and manage project related operations*/

public class Project {
	private String projectName;
	private java.util.Calendar startDate;
	private boolean state;
	
	
	//construct project
	public Project(String pName, Calendar startDate, String state) {
		projectName = pName;
		this.startDate = startDate;
		if (state.equals("Open"))
			this.state = true;
		else if (state.equals("Close"))
			this.state = false;
		else 
			System.out.println("Invalid state of project");			
	}
	//set state
	public void setState(String state) {
		if (state.equals("Open"))
			this.state = true;
		else if (state.equals("Close"))
			this.state = false;
		else 
			System.out.println("Invalid state of project");
	}
	//get state
	public String getState() {
		if (state)
			return "Open";
		else if (!state)
			return "Close";
		else
			return "Invalid";
	}
	//close the state
	public void close() {
		if (state)
			state = false;
	}
	//get projectName
	public String getProjectName() {
		return projectName;
	}
	//set projectName
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	//get startDate
	public java.util.Calendar getStartDate() {
		return startDate;
	}
	//set startDate
	public void setStartDate(java.util.Calendar startDate) {
		this.startDate = startDate;
	}
	//return string information about project
	@Override
	public String toString() {
		return "Project [projectName=" + projectName + ", startDate=" + startDate.get(Calendar.DATE) + "/" + (startDate.get(Calendar.MONTH) + 1) + "/" + startDate.get(Calendar.YEAR) + ", state=" + state + "]";
	}
	
	
}

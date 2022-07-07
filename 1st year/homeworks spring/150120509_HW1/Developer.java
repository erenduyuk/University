import java.util.ArrayList;
import java.util.Calendar;

//Eren Duyuk 150120509

/*The purpose of this class is to create developer object and developer person related operations*/

public class Developer extends RegularEmployee {
	private ArrayList<Project> projects = new ArrayList<Project>();
	public static int numberOfDevelopers;
	
	//construct developer
	public Developer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department, double performanceScore, ArrayList<Project> projects) throws Exception {
		super(id, firstName, lastName,gender, birthDate,maritalStatus,
			hasDriverLicence, salary, hireDate, department,performanceScore);
		this.projects = projects;
		numberOfDevelopers++;
	}
	
	//construct developer with regularemployee object
	public Developer(RegularEmployee re, ArrayList<Project> projects) throws Exception {
		super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(),
				re.getMaritalStatus(), re.getHasDriverLicence(), re.getSalary(), re.getHireDate(),
				re.getDepartment(), re.getPerformanceScore());
		this.projects = projects;
		numberOfDevelopers++;
	}
	
	//adds project to the developer's projects list
	public boolean addProject(Project project) {
		return projects.add(project);	
	}
	//removes project to the developer's projects list
	public boolean removeProject(Project project) {
		return projects.remove(project);
		
	}
	//get projects list
	public ArrayList<Project> getProjects() {
		return projects;
	}
	//set projects list
	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}
	//get numberOfDevelopers
	public static int getNumberOfDevelopers() {
		return numberOfDevelopers;
	}
	//set numberOfDevelopers
	public static void setNumberOfDevelopers(int numberOfDevelopers) throws Exception {
		if (numberOfDevelopers <= 0)
			throw new Exception("Id cannot be negative!");
		Developer.numberOfDevelopers = numberOfDevelopers;
	}
	//return string information about developer
	@Override
	public String toString() {
		String projectsToString = "";
		for (int i = 0; i < projects.size(); i++) {
			projectsToString += projects.get(i).toString();
			if (i != projects.size() - 1)
				projectsToString += ", ";
		}
		return "\t\t\t\tPerson Info [id=" + getId() + ", firstName=" + getFirstName() + ", lastName=" + getLastName() + ", gender=" + getGender() + "]\n" + 
	"\t\t\t\tEmployee Info [salary=" + getSalary() + ", hireDate=" + getHireDate().get(Calendar.DATE) + "/" + (getHireDate().get(Calendar.MONTH) + 1) + "/" + getHireDate().get(Calendar.YEAR) + "]\n" + 
	"\t\t\t\tRegularEmployee Info [performanceScore=" + getPerformanceScore() + ", bonus=" + getBonus() + "]\n" + 
	"\t\t\t\t[" + projectsToString + "]";
	}

	
	
}

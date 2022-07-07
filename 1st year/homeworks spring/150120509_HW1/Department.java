//Eren Duyuk 150120509

/*The purpose of this class is to create department object and manage department related operations*/

public class Department {
	private int departmentId;
	private String departmentName;
	
	
	//construct department
	public Department(int departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
	//get departmentId
	public int getDepartmentId() {
		return departmentId;
	}
	//set departmentId
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	//get departmentName
	public String getDepartmentName() {
		return departmentName;
	}
	//set departmentName
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	//return string information about department
	@Override
	public String toString() {
		return "Department [departmentId=" + getDepartmentId() + ", departmentName=" + getDepartmentName() +"]";
	}
	
	
}

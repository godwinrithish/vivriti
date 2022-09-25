package employeeapi;

public class employees {
	private int User_Id;
	private String First_Name;
	private String Last_Name;
	private int Mobile_Number;
	private String Address;
	private String Department;
	public employees() {}
	public employees(int User_Id,String First_Name,String Last_Name,int Mobile_Number,String Address,String Department) {
		this.User_Id=User_Id;
		this.First_Name=First_Name;
		this.Last_Name=Last_Name;
		this.Mobile_Number=1234567809;
		this.Address="Address data shown";
		this.Department="CSE";
	}
	public String getAddress() {
		return Address;
	}public String getDepartment() {
		return Department;
	}public String getFirst_Name() {
		return First_Name;
	}public String getLast_Name() {
		return Last_Name;
	}public int getMobile_Number() {
		return Mobile_Number;
	}public int getUser_Id() {
		return User_Id;
	}public void setAddress(String address) {
		Address = address;
	}public void setDepartment(String department) {
		Department = department;
	}public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}public void setMobile_Number(int mobile_Number) {
		Mobile_Number = mobile_Number;
	}public void setUser_Id(int user_Id) {
		User_Id = user_Id;
	}
}

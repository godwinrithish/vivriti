package employeeapi;

import java.util.*;
import java.sql.*;
public class employeerepository 
{
	Connection con=null;
	public employeerepository() {
		String url="jdbc:postgresql://localhost/test";
		String user="postgres";
		String password="password";	
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(url,user,password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Created a employee db where user_id is the primary key
	public List<employees> getEmployees(){
		System.out.println("Selecting all records through employee repo");
		List<employees> emplist=new ArrayList<>();
		String sql="SELECT * FROM employeedb";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				employees employee=new employees();
				employee.setUser_Id(rs.getInt(1));
				employee.setFirst_Name(rs.getString(2));
				employee.setLast_Name(rs.getString(3));
				employee.setMobile_Number(rs.getInt(4));
				employee.setAddress(rs.getString(5));
				employee.setDepartment(rs.getString(6));	
				emplist.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emplist;
	}
	public employees getEmployee(int user_id) {
		List<employees> emplist=new ArrayList<>();
		String sql="SELECT * FROM employeedb WHERE user_id="+user_id;
		employees employee=new employees();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if(rs.next()) {
				employee.setUser_Id(rs.getInt(1));
				employee.setFirst_Name(rs.getString(2));
				employee.setLast_Name(rs.getString(3));
				employee.setMobile_Number(rs.getInt(4));
				employee.setAddress(rs.getString(5));
				employee.setDepartment(rs.getString(6));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}
	public void create(employees emp) {
		// TODO Auto-generated method stub
		System.out.println("Inserting record through employee repo");
		String sql="INSERT INTO employeedb VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, emp.getUser_Id());
			st.setString(2,emp.getFirst_Name());
			st.setString(3,emp.getLast_Name());
			st.setInt(4, emp.getMobile_Number());
			st.setString(5,emp.getAddress());
			st.setString(6,emp.getDepartment());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update(employees emp) {
		// TODO Auto-generated method stub
		System.out.println("Updating record through employee repo");
		String sql="UPDATE employeedb SET first_name=? WHERE user_id=?";
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,emp.getFirst_Name());
			st.setInt(2, emp.getUser_Id());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete(int user_id) {
		System.out.println("Deleting record through employee repo");
		String sql="DELETE FROM employeedb WHERE user_id=?";
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, user_id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

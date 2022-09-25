package employeeapi;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("employees")
public class employeeresource {
	employeerepository employee=new employeerepository();
	
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public List<employees> getEmployees() {
		System.out.println("Inside the Read employees resource");		
		List<employees> emplist=employee.getEmployees();
		return emplist;
	}
	
	@GET
	@Path("getemp/{user_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public employees getEmployee(@PathParam("user_id") int user_id) {
		return employee.getEmployee(user_id);
	}

	@POST
	@Path("addemp")
	@Consumes(MediaType.APPLICATION_JSON)
	public employees empcreate(employees emp) {
		employee.create(emp);
		return emp;
	}
	
	@PUT
	@Path("updateemp")
	@Consumes(MediaType.APPLICATION_JSON)
	public employees updateemp(employees emp) {
		if(employee.getEmployee(emp.getUser_Id()).getUser_Id()==0) {
			System.out.println("Since the record did not exist,we are creating a new record");
			employee.create(emp);
		}else {
			employee.update(emp);
		}
		return emp;
	}
	
	@DELETE
	@Path("deleteemp/{user_id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteemp(@PathParam("user_id") int user_id) {
		String message;
		employees deletingemp=employee.getEmployee(user_id);
		if(deletingemp.getUser_Id()!=0) {
			employee.delete(user_id);
			message="User -"+user_id+" Deleted successfully";
		}else {
			message="No such recond found to be deleted";
		}
		return message;
	}
}

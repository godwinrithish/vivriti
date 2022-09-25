package employeeapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("myresource")
public class myresource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got the api running";
	}
}

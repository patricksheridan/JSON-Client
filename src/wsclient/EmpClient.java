package wsclient;



import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import employee_stuff.Employee;

public class EmpClient {

	public static void main (String[] args)
	{
		ClientConfig cnf = new DefaultClientConfig();
		cnf.getFeatures().put(
				JSONConfiguration.FEATURE_POJO_MAPPING,
				Boolean.TRUE);
		WebResource wr = Client.create(cnf).resource( 
				"http://localhost:10080/WebServices/rest/hello/emp");
		Employee emp = wr.accept(MediaType.APPLICATION_JSON)
				.get(Employee.class);
		System.out.println(emp.getName() + " earns " + emp.calcPay() + " per month");
	}

}

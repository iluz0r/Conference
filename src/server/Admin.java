package server;

import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

import com.sun.xml.ws.developer.Stateful;
import com.sun.xml.ws.developer.StatefulWebServiceManager;

@WebService
@Stateful
@Addressing
public class Admin extends User {

	public static StatefulWebServiceManager<Admin> manager;
	
	public Admin(String username, String password, String name, String surname) {
		super(username, password, name, surname, true);
	}

	@Override
	public boolean equals(Object o) {
		User user = (User) o;
		return getUsername().equals(user.getUsername());
	}

}

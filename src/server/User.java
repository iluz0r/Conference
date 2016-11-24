package server;

import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

import com.sun.xml.ws.developer.Stateful;
import com.sun.xml.ws.developer.StatefulWebServiceManager;

@WebService
@Stateful
@Addressing
public abstract class User {

	public static StatefulWebServiceManager<User> manager;
	private String username;
	private String password;
	private String name;
	private String surname;
	private boolean isAdmin;

	public User(String username, String password, String name, String surname, boolean isAdmin) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.isAdmin = isAdmin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

}

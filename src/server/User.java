package server;

import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

import com.sun.xml.ws.developer.Stateful;

@WebService
@Stateful
@Addressing
public abstract class User {

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

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public abstract boolean equals(Object o);

}

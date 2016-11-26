package server;

public class Admin extends User {

	public Admin(String username, String password, String name, String surname) {
		super(username, password, name, surname, true);
	}

	@Override
	public boolean equals(Object o) {
		User user = (User) o;
		return getUsername().equals(user.getUsername());
	}

}

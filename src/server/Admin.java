package server;

public class Admin extends User implements Comparable<User> {

	public Admin(String username, String password, String name, String surname, boolean isAdmin) {
		super(username, password, name, surname, isAdmin);
	}

	@Override
	public int compareTo(User user) {
		return getUsername().compareTo(user.getUsername());
	}

}

package server;

public class Participant extends User {

	private String idPaper;

	public Participant(String username, String password, String name, String surname, String idPaper) {
		super(username, password, name, surname, false);
		this.idPaper = idPaper;
	}

	public String getIdPaper() {
		return idPaper;
	}

	@Override
	public boolean equals(Object o) {
		User user = (User) o;

		if (user.isAdmin())
			return getUsername().equals(user.getUsername());
		else {
			Participant p = (Participant) user;
			return getUsername().equals(user.getUsername()) || idPaper.equals(p.getIdPaper());
		}
	}

}

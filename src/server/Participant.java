package server;

public class Participant extends User implements Comparable<User> {

	private String idPaper;

	public Participant(String username, String password, String name, String surname, String idPaper) {
		super(username, password, name, surname, false);
		this.idPaper = idPaper;
	}

	public String getIdPaper() {
		return idPaper;
	}

	@Override
	public int compareTo(User user) {
		// Se lo user ha lo stesso username, allora sono uguali
		if (getUsername().equals(user.getUsername()))
			return 0;

		// Se lo user non è un admin, dunque è un Participant che possiede un
		// idPaper, e l'idPaper è uguale, allora sono uguali
		if (!user.isAdmin()) {
			Participant participant = (Participant) user;
			if (idPaper.equals(participant.getIdPaper()))
				return 0;
		}

		return getUsername().compareTo(user.getUsername());
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

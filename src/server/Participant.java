package server;

public class Participant extends User {

	private String idPaper;

	public Participant(String username, String password, String name, String surname, String idPaper) {
		super(username, password, name, surname);
		this.idPaper = idPaper;
	}
	
	public String getIdPaper() {
		return idPaper;
	}

}

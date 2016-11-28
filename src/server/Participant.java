package server;

import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

import com.sun.xml.ws.developer.Stateful;
import com.sun.xml.ws.developer.StatefulWebServiceManager;

@WebService
@Stateful
@Addressing
public class Participant extends User {

	public static StatefulWebServiceManager<Participant> manager;
	private String idPaper;
	private String titlePaper;

	public Participant(String username, String password, String name, String surname, String idPaper,
			String titlePaper) {
		super(username, password, name, surname, false);
		this.idPaper = idPaper;
		this.titlePaper = titlePaper;
	}

	public String getIdPaper() {
		return idPaper;
	}

	public String getTitlePaper() {
		return titlePaper;
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

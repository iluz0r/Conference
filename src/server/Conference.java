package server;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.xml.ws.wsaddressing.W3CEndpointReference;

@WebService
public class Conference {

	private List<User> users;

	public Conference() {
		users = new ArrayList<>();
		users.add(new Admin("admin", "admin", "Sigismondo", "Malatesta"));
	}

	public void register(String username, String password, String name, String surname, String idPaper) {
		Participant p = new Participant(username, password, name, surname, idPaper);
		// La users.indexOf(user) funziona grazie all'override del metodo
		// equals nella classe Participant. In sostanza, la indexOf non
		// sfrutta pi� il metodo equals implementato in Object ma quello
		// implementato in Participant.
		if (users.indexOf(p) == -1)
			users.add(p);
		else
			throw new RuntimeException("Already registered user/id paper.");
	}

	public W3CEndpointReference login(String username, String password) {
		for (User u : users) {
			if (u.getUsername().equals(username)) {
				if (u.getPassword().equals(password)) {
					if (u.isAdmin())
						return Admin.manager.export((Admin) u);
					else
						return Participant.manager.export((Participant) u);
				} else
					throw new RuntimeException("Wrong password.");
			}
		}
		throw new RuntimeException("User not registered.");
	}

	public boolean isRegistered(String username, String idPaper) {
		for (User u : users) {
			if (!u.isAdmin()) {
				Participant p = (Participant) u;
				if (p.getUsername().equals(username) || p.getIdPaper().equals(idPaper))
					return true;
			}
		}
		return false;
	}

}

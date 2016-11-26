package server;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.xml.ws.wsaddressing.W3CEndpointReference;

@WebService
public class Conference {

	private List<User> users = new ArrayList<>();

	public W3CEndpointReference register(String username, String password, String name, String surname,
			String idPaper) {
		User user;
		if (username.equals("admin") && password.equals("admin")) {
			user = new Admin(username, password, name, surname);
			return Admin.manager.export((Admin) user);
		} else {
			user = new Participant(username, password, name, surname, idPaper);

			// La users.indexOf(user) funziona grazie all'override del metodo
			// equals nella classe Participant. In sostanza, la indexOf non
			// sfrutta pi� il metodo equals implementato in Object ma quello
			// implementato in Participant.
			if (users.indexOf(user) == -1) {
				users.add(user);
				return Participant.manager.export((Participant) user);
			} else
				throw new RuntimeException("Username or paper already registered.");
		}
	}

}

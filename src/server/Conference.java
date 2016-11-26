package server;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.xml.ws.wsaddressing.W3CEndpointReference;

@WebService
public class Conference {

	private List<Participant> users = new ArrayList<>();

	public W3CEndpointReference register(String username, String password, String name, String surname,
			String idPaper) {
		User user;
		if (username.equals("admin") && password.equals("admin")) {
			Admin admin = new Admin(username, password, name, surname);
			return User.manager.export(admin);
		} else {
			Participant p = new Participant(username, password, name, surname, idPaper);

			// La users.indexOf(user) funziona grazie all'override del metodo
			// equals nella classe Participant. In sostanza, la indexOf non
			// sfrutta più il metodo equals implementato in Object ma quello
			// implementato in Participant.
			if (users.indexOf(p) == -1) {
				users.add(p);
				return User.manager.export(p);
			} else
				throw new RuntimeException("Username or paper already registered.");
		}
	}

}

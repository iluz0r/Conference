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
		User user = null;

		if (username.equals("admin") && password.equals("admin"))
			user = new Admin(username, password, name, surname);
		else {
			user = new Participant(username, password, name, surname, idPaper);

			// La users.indexOf(user) funziona grazie all'override del metodo
			// equals nella classe Participant. In sostanza, la indexOf non
			// sfrutta più il metodo equals implementato in Object ma quello
			// implementato in Participant.
			if (users.indexOf(user) == -1) {
				users.add(user);
				System.out.println("Utente " + username + " aggiunto alla lista partecipanti.");
			} else
				System.out.println("Utente " + username + " risulta già iscritto alla conferenza.");
		}

		return User.manager.export(user);
	}

}

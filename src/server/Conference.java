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
		if (username.equals("admin") && password.equals("admin")) {
			user = new Admin(username, password, name, surname);
			if (users.indexOf(user) == -1) {
				users.add(user);
				System.out.println("Utente aggiunto alla lista");
			} else
				System.out.println("Utente trovato. Utenti presenti in lista: " + users.size());
		}
		return User.manager.export(user);
	}

}

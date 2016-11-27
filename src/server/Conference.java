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
		// sfrutta più il metodo equals implementato in Object ma quello
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

	public List<String> getIdPapers(W3CEndpointReference ref) {
		Admin user = Admin.manager.resolve(ref);
		if (user != null) {
			List<String> idPaperList = new ArrayList<>();

			for (User u : users) {
				if (!u.isAdmin())
					idPaperList.add(((Participant) u).getIdPaper());
			}

			return idPaperList;
		} else
			throw new RuntimeException("Only admins can request the id papers list.");
	}
	
	public List<ParticipantBean> getAllParticipants(W3CEndpointReference ref) {
		Admin user = Admin.manager.resolve(ref);
		if (user != null) {
			List<ParticipantBean> participantList = new ArrayList<>();

			for (User u : users) {
				if (!u.isAdmin()) {
					Participant p = (Participant) u;
					ParticipantBean pb = new ParticipantBean();
					pb.username = p.getUsername();
					pb.password = p.getPassword();
					pb.name = p.getName();
					pb.surname = p.getSurname();
					pb.idPaper = p.getIdPaper();
					pb.isAdmin = p.isAdmin();
					participantList.add(pb);
				}
			}

			return participantList;
		} else
			throw new RuntimeException("Only admins can request the participants list.");
	}

}

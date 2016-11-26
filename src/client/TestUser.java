package client;

import javax.xml.ws.wsaddressing.W3CEndpointReference;

import stub.Conference;
import stub.ConferenceService;
import stub.Admin;
import stub.AdminService;
import stub.Participant;
import stub.User;
import stub.UserService;

public class TestUser {

	public static void main(String[] args) {
		ConferenceService conferenceService = new ConferenceService();
		Conference conference = (Conference) conferenceService.getPort(Conference.class);
		UserService userService = new UserService();

		W3CEndpointReference ref = conference.register("admin", "admin", "Angelo", "Santoro", null);
		User user = userService.getPort(ref, User.class);

		W3CEndpointReference ref2 = conference.register("cyberguitar", "sergio90", "Vincenzo", "Giordano", "Scottex1");
		User user2 = (User) userService.getPort(ref2, User.class);
		//System.out.println("User " + user2.getUsername() + " with id paper " + user2.getIdPaper() + " registered.");

		W3CEndpointReference ref3 = conference.register("cyberguitar4", "sergio90", "Vincenzo", "Giordano", "1");
		User user3 = (User) userService.getPort(ref3, User.class);
		//System.out.println("User " + user3.getUsername() + " with id paper " + user3.getIdPaper() + " registered.");
	}

}

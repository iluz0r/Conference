package client;

import javax.xml.ws.wsaddressing.W3CEndpointReference;

import stub.Conference;
import stub.ConferenceService;
import stub.User;
import stub.UserService;

public class TestUser {

	public static void main(String[] args) {
		ConferenceService conferenceService = new ConferenceService();
		Conference conference = (Conference) conferenceService.getPort(Conference.class);
		UserService userService = new UserService();
		W3CEndpointReference ref = conference.register("admin", "admin", "Angelo", "Santoro", "Paper1");
		User user = userService.getPort(ref, User.class);
		
		System.out.println(user.getSurname());
	}

}

package client;

import javax.xml.ws.wsaddressing.W3CEndpointReference;

import stub.Conference;
import stub.ConferenceService;
import stub.Admin;
import stub.AdminService;
import stub.Participant;
import stub.ParticipantService;

public class TestUser {

	public static void main(String[] args) {
		ConferenceService conferenceService = new ConferenceService();
		Conference conference = (Conference) conferenceService.getPort(Conference.class);
		ParticipantService participantService = new ParticipantService();
		AdminService adminService = new AdminService();
		
		W3CEndpointReference ref = conference.register("admin", "admin", "Angelo", "Santoro", null);
		Admin admin = adminService.getPort(ref, Admin.class);

		W3CEndpointReference ref2 = conference.register("cyberguitar", "sergio90", "Vincenzo", "Giordano", "Scottex1");
		Participant user2 = participantService.getPort(ref2, Participant.class);
		System.out.println("User " + user2.getUsername() + " with id paper " + user2.getIdPaper() + " registered.");

		W3CEndpointReference ref3 = conference.register("cyberguitar4", "sergio90", "Vincenzo", "Giordano", "1");
		Participant user3 = participantService.getPort(ref3, Participant.class);
		System.out.println("User " + user3.getUsername() + " with id paper " + user3.getIdPaper() + " registered.");
	}

}

package client;

import javax.xml.ws.wsaddressing.W3CEndpointReference;

import stub.Conference;
import stub.ConferenceService;
import stub.Exception_Exception;
import stub.Admin;
import stub.AdminService;
import stub.Participant;
import stub.ParticipantService;

public class TestUser {

	public static void main(String[] args) {
		ConferenceService conferenceService = new ConferenceService();
		Conference conference = (Conference) conferenceService.getPort(Conference.class);
		AdminService adminService = new AdminService();
		ParticipantService participantService = new ParticipantService();
		
		W3CEndpointReference ref;
		try {
			ref = conference.register("admin", "admin", "Angelo", "Santoro", null);
			Admin user = adminService.getPort(ref, Admin.class);
		} catch (Exception_Exception e) {
			e.printStackTrace();
		}

		W3CEndpointReference ref2;
		try {
			ref2 = conference.register("cyberguitar", "sergio90", "Vincenzo", "Giordano", "Scottex1");
			Participant user2 = participantService.getPort(ref2, Participant.class);
			System.out.println("User " + user2.getUsername() + " with id paper " + user2.getIdPaper() + " registered.");
		} catch (Exception_Exception e) {
			e.printStackTrace();
		}

		W3CEndpointReference ref3;
		try {
			ref3 = conference.register("cyberguitar4", "sergio90", "Vincenzo", "Giordano", "1");
			Participant user3 = participantService.getPort(ref3, Participant.class);
			System.out.println("User " + user3.getUsername() + " with id paper " + user3.getIdPaper() + " registered.");
		} catch (Exception_Exception e) {
			e.printStackTrace();
		}
	}

}

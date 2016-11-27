package client;

import java.util.ArrayList;
import java.util.List;

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

		try {
			W3CEndpointReference ref = conference.login("admin", "admin");
			Admin admin = adminService.getPort(ref, Admin.class);
			System.out.println("Logged in as: " + admin.getUsername());
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}

		try {
			conference.register("cyberguitar", "vespone", "Vincenzo", "Giordano", "Scottex");
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}

		try {
			W3CEndpointReference ref2 = conference.login("cyberguitar", "vespone");
			Participant user2 = participantService.getPort(ref2, Participant.class);
			System.out.println("User " + user2.getUsername() + " with id paper " + user2.getIdPaper() + " logged in.");
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}
		
		List<String> idPaperList = conference.getIdPapers();
		System.out.println("\nPapers list:\n");
		for(String idPaper : idPaperList) {
			System.out.println(idPaper);
		}
	}

}

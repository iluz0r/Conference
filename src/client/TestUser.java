package client;

import java.util.List;

import javax.xml.ws.wsaddressing.W3CEndpointReference;

import stub.*;

public class TestUser {

	public static void main(String[] args) {
		ConferenceService conferenceService = new ConferenceService();
		Conference conference = (Conference) conferenceService.getPort(Conference.class);
		ParticipantService participantService = new ParticipantService();
		AdminService adminService = new AdminService();

		Admin admin = null;
		W3CEndpointReference ref = null;
		try {
			ref = conference.login("admin", "admin");
			admin = adminService.getPort(ref, Admin.class);
			System.out.println("Logged in as " + admin.getUsername());
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}

		try {
			conference.register("cyberguitar", "vespone", "Vincenzo", "Giordano", "Scottex");
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}

		Participant user2 = null;
		W3CEndpointReference ref2 = null;
		try {
			ref2 = conference.login("cyberguitar", "vespone");
			user2 = participantService.getPort(ref2, Participant.class);
			System.out.println("User " + user2.getUsername() + " with id paper " + user2.getIdPaper() + " logged in.");
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}

		try {
			List<String> idPaperList = conference.getAllIdPapers(ref2);
			System.out.println("\nPapers list:");
			for (String idPaper : idPaperList) 
				System.out.println("- " + idPaper);
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			List<ParticipantBean> participantList = conference.getAllParticipants(ref);
			System.out.println("\nUsers list:");
			for (ParticipantBean participant : participantList) 
				System.out.println("- " + participant.getUsername());
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}
	}

}

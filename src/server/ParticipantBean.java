package server;

import javax.jws.WebService;
import javax.xml.bind.annotation.*;

@WebService
@XmlRootElement(name="yourRootElementName")
@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantBean {

	public String username;
	public String password;
	public String name;
	public String surname;
	public String idPaper;
	public boolean isAdmin;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getIdPaper() {
		return idPaper;
	}

	public void setIdPaper(String idPaper) {
		this.idPaper = idPaper;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
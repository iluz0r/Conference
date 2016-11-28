
package stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per participantBean complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="participantBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="surname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idPaper" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="titlePaper" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isAdmin" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "participantBean", propOrder = {
    "username",
    "password",
    "name",
    "surname",
    "idPaper",
    "titlePaper",
    "isAdmin"
})
public class ParticipantBean {

    protected String username;
    protected String password;
    protected String name;
    protected String surname;
    protected String idPaper;
    protected String titlePaper;
    protected boolean isAdmin;

    /**
     * Recupera il valore della proprietà username.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Imposta il valore della proprietà username.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Recupera il valore della proprietà password.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Imposta il valore della proprietà password.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Recupera il valore della proprietà name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il valore della proprietà name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Recupera il valore della proprietà surname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Imposta il valore della proprietà surname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurname(String value) {
        this.surname = value;
    }

    /**
     * Recupera il valore della proprietà idPaper.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPaper() {
        return idPaper;
    }

    /**
     * Imposta il valore della proprietà idPaper.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPaper(String value) {
        this.idPaper = value;
    }

    /**
     * Recupera il valore della proprietà titlePaper.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitlePaper() {
        return titlePaper;
    }

    /**
     * Imposta il valore della proprietà titlePaper.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitlePaper(String value) {
        this.titlePaper = value;
    }

    /**
     * Recupera il valore della proprietà isAdmin.
     * 
     */
    public boolean isIsAdmin() {
        return isAdmin;
    }

    /**
     * Imposta il valore della proprietà isAdmin.
     * 
     */
    public void setIsAdmin(boolean value) {
        this.isAdmin = value;
    }

}

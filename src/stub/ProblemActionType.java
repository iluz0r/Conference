
package stub;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Classe Java per ProblemActionType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ProblemActionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.w3.org/2005/08/addressing}Action" minOccurs="0"/>
 *         &lt;element name="SoapAction" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProblemActionType", namespace = "http://www.w3.org/2005/08/addressing", propOrder = {
    "action",
    "soapAction"
})
public class ProblemActionType {

    @XmlElement(name = "Action", namespace = "http://www.w3.org/2005/08/addressing")
    protected AttributedURIType action;
    @XmlElement(name = "SoapAction", namespace = "http://www.w3.org/2005/08/addressing")
    @XmlSchemaType(name = "anyURI")
    protected String soapAction;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Recupera il valore della proprietÓ action.
     * 
     * @return
     *     possible object is
     *     {@link AttributedURIType }
     *     
     */
    public AttributedURIType getAction() {
        return action;
    }

    /**
     * Imposta il valore della proprietÓ action.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributedURIType }
     *     
     */
    public void setAction(AttributedURIType value) {
        this.action = value;
    }

    /**
     * Recupera il valore della proprietÓ soapAction.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoapAction() {
        return soapAction;
    }

    /**
     * Imposta il valore della proprietÓ soapAction.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoapAction(String value) {
        this.soapAction = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}

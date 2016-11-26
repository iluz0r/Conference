
package stub;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "User", targetNamespace = "http://server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface User {


    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "equals", targetNamespace = "http://server/", className = "stub.Equals")
    @ResponseWrapper(localName = "equalsResponse", targetNamespace = "http://server/", className = "stub.EqualsResponse")
    @Action(input = "http://server/User/equalsRequest", output = "http://server/User/equalsResponse")
    public boolean equals(
        @WebParam(name = "arg0", targetNamespace = "")
        Object arg0);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getName", targetNamespace = "http://server/", className = "stub.GetName")
    @ResponseWrapper(localName = "getNameResponse", targetNamespace = "http://server/", className = "stub.GetNameResponse")
    @Action(input = "http://server/User/getNameRequest", output = "http://server/User/getNameResponse")
    public String getName();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "setName", targetNamespace = "http://server/", className = "stub.SetName")
    @ResponseWrapper(localName = "setNameResponse", targetNamespace = "http://server/", className = "stub.SetNameResponse")
    @Action(input = "http://server/User/setNameRequest", output = "http://server/User/setNameResponse")
    public void setName(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUsername", targetNamespace = "http://server/", className = "stub.GetUsername")
    @ResponseWrapper(localName = "getUsernameResponse", targetNamespace = "http://server/", className = "stub.GetUsernameResponse")
    @Action(input = "http://server/User/getUsernameRequest", output = "http://server/User/getUsernameResponse")
    public String getUsername();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getSurname", targetNamespace = "http://server/", className = "stub.GetSurname")
    @ResponseWrapper(localName = "getSurnameResponse", targetNamespace = "http://server/", className = "stub.GetSurnameResponse")
    @Action(input = "http://server/User/getSurnameRequest", output = "http://server/User/getSurnameResponse")
    public String getSurname();

    /**
     * 
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "isAdmin", targetNamespace = "http://server/", className = "stub.IsAdmin")
    @ResponseWrapper(localName = "isAdminResponse", targetNamespace = "http://server/", className = "stub.IsAdminResponse")
    @Action(input = "http://server/User/isAdminRequest", output = "http://server/User/isAdminResponse")
    public boolean isAdmin();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "setAdmin", targetNamespace = "http://server/", className = "stub.SetAdmin")
    @ResponseWrapper(localName = "setAdminResponse", targetNamespace = "http://server/", className = "stub.SetAdminResponse")
    @Action(input = "http://server/User/setAdminRequest", output = "http://server/User/setAdminResponse")
    public void setAdmin(
        @WebParam(name = "arg0", targetNamespace = "")
        boolean arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "setSurname", targetNamespace = "http://server/", className = "stub.SetSurname")
    @ResponseWrapper(localName = "setSurnameResponse", targetNamespace = "http://server/", className = "stub.SetSurnameResponse")
    @Action(input = "http://server/User/setSurnameRequest", output = "http://server/User/setSurnameResponse")
    public void setSurname(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "setPassword", targetNamespace = "http://server/", className = "stub.SetPassword")
    @ResponseWrapper(localName = "setPasswordResponse", targetNamespace = "http://server/", className = "stub.SetPasswordResponse")
    @Action(input = "http://server/User/setPasswordRequest", output = "http://server/User/setPasswordResponse")
    public void setPassword(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "setUsername", targetNamespace = "http://server/", className = "stub.SetUsername")
    @ResponseWrapper(localName = "setUsernameResponse", targetNamespace = "http://server/", className = "stub.SetUsernameResponse")
    @Action(input = "http://server/User/setUsernameRequest", output = "http://server/User/setUsernameResponse")
    public void setUsername(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPassword", targetNamespace = "http://server/", className = "stub.GetPassword")
    @ResponseWrapper(localName = "getPasswordResponse", targetNamespace = "http://server/", className = "stub.GetPasswordResponse")
    @Action(input = "http://server/User/getPasswordRequest", output = "http://server/User/getPasswordResponse")
    public String getPassword();

}

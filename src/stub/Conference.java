
package stub;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import javax.xml.ws.wsaddressing.W3CEndpointReference;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Conference", targetNamespace = "http://server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Conference {


    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg4
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "register", targetNamespace = "http://server/", className = "stub.Register")
    @ResponseWrapper(localName = "registerResponse", targetNamespace = "http://server/", className = "stub.RegisterResponse")
    @Action(input = "http://server/Conference/registerRequest", output = "http://server/Conference/registerResponse")
    public void register(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        String arg4);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns javax.xml.ws.wsaddressing.W3CEndpointReference
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://server/", className = "stub.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://server/", className = "stub.LoginResponse")
    @Action(input = "http://server/Conference/loginRequest", output = "http://server/Conference/loginResponse")
    public W3CEndpointReference login(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getIdPapers", targetNamespace = "http://server/", className = "stub.GetIdPapers")
    @ResponseWrapper(localName = "getIdPapersResponse", targetNamespace = "http://server/", className = "stub.GetIdPapersResponse")
    @Action(input = "http://server/Conference/getIdPapersRequest", output = "http://server/Conference/getIdPapersResponse")
    public List<String> getIdPapers(
        @WebParam(name = "arg0", targetNamespace = "")
        W3CEndpointReference arg0);

}

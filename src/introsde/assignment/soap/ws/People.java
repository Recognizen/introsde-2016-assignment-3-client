
package introsde.assignment.soap.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "People", targetNamespace = "http://ws.soap.assignment.introsde/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface People {


    /**
     * 
     * @return
     *     returns java.util.List<introsde.assignment.soap.ws.Person>
     */
    @WebMethod
    @WebResult(name = "people", targetNamespace = "")
    @RequestWrapper(localName = "readPersonList", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.ReadPersonList")
    @ResponseWrapper(localName = "readPersonListResponse", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.ReadPersonListResponse")
    @Action(input = "http://ws.soap.assignment.introsde/People/readPersonListRequest", output = "http://ws.soap.assignment.introsde/People/readPersonListResponse")
    public List<Person> readPersonList();

    /**
     * 
     * @param personId
     * @return
     *     returns introsde.assignment.soap.ws.Person
     */
    @WebMethod
    @WebResult(name = "person", targetNamespace = "")
    @RequestWrapper(localName = "readPerson", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.ReadPerson")
    @ResponseWrapper(localName = "readPersonResponse", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.ReadPersonResponse")
    @Action(input = "http://ws.soap.assignment.introsde/People/readPersonRequest", output = "http://ws.soap.assignment.introsde/People/readPersonResponse")
    public Person readPerson(
        @WebParam(name = "personId", targetNamespace = "")
        long personId);

    /**
     * 
     * @param person
     */
    @WebMethod
    @RequestWrapper(localName = "updatePerson", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.UpdatePerson")
    @ResponseWrapper(localName = "updatePersonResponse", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.UpdatePersonResponse")
    @Action(input = "http://ws.soap.assignment.introsde/People/updatePersonRequest", output = "http://ws.soap.assignment.introsde/People/updatePersonResponse")
    public void updatePerson(
        @WebParam(name = "person", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<Person> person);

    /**
     * 
     * @param person
     */
    @WebMethod
    @RequestWrapper(localName = "createPerson", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.CreatePerson")
    @ResponseWrapper(localName = "createPersonResponse", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.CreatePersonResponse")
    @Action(input = "http://ws.soap.assignment.introsde/People/createPersonRequest", output = "http://ws.soap.assignment.introsde/People/createPersonResponse")
    public void createPerson(
        @WebParam(name = "person", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<Person> person);

    /**
     * 
     * @param personId
     */
    @WebMethod
    @RequestWrapper(localName = "deletePerson", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.DeletePerson")
    @ResponseWrapper(localName = "deletePersonResponse", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.DeletePersonResponse")
    @Action(input = "http://ws.soap.assignment.introsde/People/deletePersonRequest", output = "http://ws.soap.assignment.introsde/People/deletePersonResponse")
    public void deletePerson(
        @WebParam(name = "personId", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<Long> personId);

    /**
     * 
     * @param personId
     * @param measureType
     * @return
     *     returns java.util.List<introsde.assignment.soap.ws.HealthMeasureHistory>
     */
    @WebMethod
    @WebResult(name = "healthHistory", targetNamespace = "")
    @RequestWrapper(localName = "readPersonHistory", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.ReadPersonHistory")
    @ResponseWrapper(localName = "readPersonHistoryResponse", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.ReadPersonHistoryResponse")
    @Action(input = "http://ws.soap.assignment.introsde/People/readPersonHistoryRequest", output = "http://ws.soap.assignment.introsde/People/readPersonHistoryResponse")
    public List<HealthMeasureHistory> readPersonHistory(
        @WebParam(name = "personId", targetNamespace = "")
        long personId,
        @WebParam(name = "measureType", targetNamespace = "")
        String measureType);

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(name = "measureTypes", targetNamespace = "")
    @RequestWrapper(localName = "readMeasureTypes", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.ReadMeasureTypes")
    @ResponseWrapper(localName = "readMeasureTypesResponse", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.ReadMeasureTypesResponse")
    @Action(input = "http://ws.soap.assignment.introsde/People/readMeasureTypesRequest", output = "http://ws.soap.assignment.introsde/People/readMeasureTypesResponse")
    public List<String> readMeasureTypes();

    /**
     * 
     * @param mid
     * @param personId
     * @param measureType
     * @return
     *     returns introsde.assignment.soap.ws.HealthMeasureHistory
     */
    @WebMethod
    @WebResult(name = "measure", targetNamespace = "")
    @RequestWrapper(localName = "readPersonMeasure", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.ReadPersonMeasure")
    @ResponseWrapper(localName = "readPersonMeasureResponse", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.ReadPersonMeasureResponse")
    @Action(input = "http://ws.soap.assignment.introsde/People/readPersonMeasureRequest", output = "http://ws.soap.assignment.introsde/People/readPersonMeasureResponse")
    public HealthMeasureHistory readPersonMeasure(
        @WebParam(name = "personId", targetNamespace = "")
        long personId,
        @WebParam(name = "measureType", targetNamespace = "")
        String measureType,
        @WebParam(name = "mid", targetNamespace = "")
        long mid);

    /**
     * 
     * @param measure
     * @param personId
     * @return
     *     returns introsde.assignment.soap.ws.Person
     */
    @WebMethod
    @WebResult(name = "measure", targetNamespace = "")
    @RequestWrapper(localName = "savePersonMeasure", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.SavePersonMeasure")
    @ResponseWrapper(localName = "savePersonMeasureResponse", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.SavePersonMeasureResponse")
    @Action(input = "http://ws.soap.assignment.introsde/People/savePersonMeasureRequest", output = "http://ws.soap.assignment.introsde/People/savePersonMeasureResponse")
    public Person savePersonMeasure(
        @WebParam(name = "personId", targetNamespace = "")
        long personId,
        @WebParam(name = "measure", targetNamespace = "")
        Measure measure);

    /**
     * 
     * @param measure
     * @param personId
     */
    @WebMethod
    @RequestWrapper(localName = "updatePersonMeasure", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.UpdatePersonMeasure")
    @ResponseWrapper(localName = "updatePersonMeasureResponse", targetNamespace = "http://ws.soap.assignment.introsde/", className = "introsde.assignment.soap.ws.UpdatePersonMeasureResponse")
    @Action(input = "http://ws.soap.assignment.introsde/People/updatePersonMeasureRequest", output = "http://ws.soap.assignment.introsde/People/updatePersonMeasureResponse")
    public void updatePersonMeasure(
        @WebParam(name = "personId", targetNamespace = "")
        long personId,
        @WebParam(name = "measure", targetNamespace = "", mode = WebParam.Mode.INOUT)
        Holder<HealthMeasureHistory> measure);

}
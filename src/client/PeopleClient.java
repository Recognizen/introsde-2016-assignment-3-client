package client;

import java.util.List;

import javax.xml.ws.Holder;

import introsde.assignment.soap.ws.*;

public class PeopleClient{
    public static void main(String[] args) throws Exception {
        PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();
        
        //Task 1 
        List<Person> pList = people.readPersonList();
        System.out.println("Result ==> "+pList);
        System.out.println("First Person in the list ==> "+pList.get(0).getFirstname());
        
        //Task 2
        Person p = people.readPerson(3);
        System.out.println("Result ==> "+p.getFirstname());
        
        //Task 3
        p.setFirstname("HOLDER");
		Holder<Person> personHolder = new Holder<Person>(p);
        people.updatePerson(personHolder);
        
        //Task 2
        Person newP = people.readPerson(3);
        System.out.println("Result ==> "+newP.getFirstname());
        
        //Task 4
        newP.setFirstname("Jim");
        personHolder = new Holder<Person>(newP);
        people.createPerson(personHolder);
        /*
        //Task 5
        people.deletePerson(jim.getPersonId());
        
        //Task 6
       // System.out.println(people.readPersonHistory(3,"weight").get(0).getMeasureValue());
        
        //Task 7
        for(String s : people.readMeasureTypes()){
        	System.out.println(s);
        }
        
        //Task 8
        System.out.println("1 "+ people.readPersonMeasure(3, "weight", 1));
        System.out.println("2 "+ people.readPersonMeasure(3, "height", 1));
        
        MeasureDefinition mDef = new MeasureDefinition();
        mDef.setTid(3);
        mDef.setMeasureType("steps");
        
        Measure m = new Measure();
        m.setMeasureDefinition(mDef);
        m.setMeasureValue("20");
        //Task 9
     //   people.savePersonMeasure(3, m);
        /*
        m.setMeasureValue("777");
        m.setMid(786);
        //Task 10
        people.updatePersonMeasure(3, m);
        
        HealthMeasureHistory historyM = new HealthMeasureHistory();
        historyM.setMeasureValue("333");
        historyM.setMeasureDefinition(mDef);
        historyM.setMid(153);
        people.updatePersonMeasure(3, historyM);
    }*/
    }
}
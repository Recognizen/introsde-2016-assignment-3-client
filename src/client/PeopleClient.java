package client;

import java.util.List;

import javax.xml.ws.Holder;

import introsde.assignment.soap.ws.*;


public class PeopleClient{
	
    public static void main(String[] args) throws Exception {
    	
    	long personId = 0;
    	
        PeopleService service = new PeopleService();
        People people = service.getPeopleImplPort();

        //-------------------- URL ----------------------------
        System.out.println(service.getWSDLDocumentLocation());
        

        //-------------------- Task 1 ----------------------------
        System.out.println("\n--------------------Task1: readPersonList() --------------------\n");
        
        //get and print all the person in the database
        List<Person> personList = people.readPersonList();
        for(Person p : personList)
        	printPerson(p);
        
        //save first person for future operations
        if(!personList.isEmpty())
        	personId = personList.get(0).getPersonId();
        
       

        //-------------------- Task 2 ----------------------------
        System.out.println("\n--------------------Task2: readPerson("+personId+")--------------------\n");
        
        Person p = people.readPerson(personId);
    	printPerson(p);
    	


        //-------------------- Task 3 ----------------------------
        System.out.println("\n-------------------- Task3: updatePerson(Person p) ----------------------------\n");

        System.out.println("Updating first name of "+p.getFirstname() + ".\n");

        p.setFirstname(p.getFirstname() + " jr.");
        Holder<Person> personHolder = new Holder<Person>(p);
        people.updatePerson(personHolder);
        //print first person of the list after re-requesting it
        Person updateP = personHolder.value;
        printPerson(updateP);


        //-------------------- Task 4 ----------------------------
        System.out.println("\n-------------------- Task4: createPerson(Person p) ----------------------------\n");

        System.out.println("Adding a new person with firstname Jim.\n");
        
        updateP.setFirstname("Jim");
        personHolder = new Holder<Person>(updateP);
        people.createPerson(personHolder);
        //reprint the person to see if it was updated
        Person newPerson = personHolder.value;
        printPerson(newPerson);

        

        //-------------------- Task 5 ----------------------------
        System.out.println("\n-------------------- Task5: deletePerson("+newPerson.getPersonId()+") ----------------------------\n");
        
        System.out.println("Deleting the person added in step 4 having new id: "+newPerson.getPersonId()+"\n");

        Holder<Long> idHolder = new Holder<Long>(newPerson.getPersonId());
        people.deletePerson(idHolder);
        System.out.println("Running readPerson("+newPerson.getPersonId()+"):");
        //retrying to print the person to see if it still exists (if something was returned)
        printPerson(people.readPerson(newPerson.getPersonId()));
        
        
        //-------------------- Task 6 ----------------------------
        System.out.println("\n-------------------- Task6: readPersonHistory("+personId+",steps) ----------------------------\n");
        
        //the history does not include the current healthprofile
        List<HealthMeasureHistory> history = people.readPersonHistory(personId, "steps");
        if(!history.isEmpty()){
        	int i = 0;
	        for(HealthMeasureHistory hm : history){
	        	i++;
	        	System.out.println("Measure "+i+": ");
	        	printMeasure(hm); 	
	        }
        } else {
        	System.out.println("\t No measures of type steps for Person with id: "+personId);
        }

        
        
        //-------------------- Task 7 ----------------------------
        System.out.println("\n-------------------- Task7: readMeasureTypes() ----------------------------\n");
        
        System.out.println("Measure Types:");
        for(String s : people.readMeasureTypes()){
        	System.out.println("\t"+s);
        }
        System.out.println("");        
        
        
        //-------------------- Task 8 ----------------------------
        System.out.println("\n-------------------- Task8: readPersonMeasure("+personId+", steps , 153) ----------------------------\n");

        System.out.println("Measure with mid 153:\n");
        HealthMeasureHistory measure = people.readPersonMeasure(personId, "steps", 153);
        printMeasure(measure);     
        
        
        //-------------------- Task 9 ----------------------------
        System.out.println("\n-------------------- Task9: savePersonMeasure("+personId+", measure) ----------------------------\n");

        Measure newMeasure = new Measure();
        newMeasure.setMeasureValue(measure.getMeasureValue()+"1");
        newMeasure.setMeasureDefinition(measure.getMeasureDefinition());

        System.out.println("Adding/Replacing measure of type "+measure.getMeasureDefinition().getMeasureType()+" to person having id: "+personId +"\n");

        //returning the person on whose healthprofile the measure was added
        Person personT9 = people.savePersonMeasure(personId, newMeasure);
        //print the person to see if he has a new measure
        printPerson(personT9);
        
        
        //-------------------- Task 10 ----------------------------
        System.out.println("\n-------------------- Task10: updatePersonMeasure("+personId+", measure) ----------------------------\n");

        
        newMeasure = null;
    	//Getting a measure from the person (since we added one before it should exist)
        if(personT9.getCurrentHealth().getMeasure() != null){
        	newMeasure =  (Measure)personT9.getCurrentHealth().getMeasure().get(0);
        	//modify the value of the measure
        	newMeasure.setMeasureValue(newMeasure.getMeasureValue()+"1");
            people.updatePersonMeasure(personId, newMeasure);
            //reprint the people to see the differences
            System.out.println("Updating measure with mid: "+ newMeasure.getMid() +" of person having id: "+personId +"\n");
            printPerson(people.readPerson(personT9.getPersonId()));
        } else {
        	System.out.println("Measure not found.");
        }
    }
    
    //Prints the given and current healthprofile
    public static void printPerson(Person p) {

       	if(p != null){
			System.out.println("");
			
			System.out.println(" ==> PersonId: " + p.getPersonId());
			System.out.println(" ==> Firstname: " + p.getFirstname());
			System.out.println(" ==> Lastname: " + p.getLastname());
			System.out.println(" ==> Birthdate: " + p.getBirthdate());
			System.out.println(" ==> Email: " + p.getEmail());
			System.out.println(" ==> Username: " + p.getUsername());
			System.out.println(" ==> Current Health Profile:\n");
			if(!p.getCurrentHealth().getMeasure().isEmpty()){
				int i = 0;
				for (Measure m : p.getCurrentHealth().getMeasure()) {
					i++;
					System.out.println("\t  Measure "+i+"");
					printMeasure(m);
					
				}
			} else {
				System.out.println("\t No Measures");
			}
			System.out.println("");
       	} else{
       		System.out.println("\tPerson not found.");
       	}
   	}
    
    //prints a given measure from the history
	public static void printMeasure(HealthMeasureHistory m) {
		
		if(m != null){
			
			System.out.println("\t ==> Mid: " + m.getMid());
			System.out.println("\t ==> Date Registered: " + m.getDateRegistered());
			System.out.println("\t ==> Measure Value: " + m.getMeasureValue());
			System.out.println("\t ==> Measure Type: " + m.getMeasureDefinition().getMeasureType());
			System.out.println("\t ==> Measure Value Type: " + m.getMeasureDefinition().getMeasureValueType());
			
			System.out.println("");
	   	} else{
	   		System.out.println("\tNo measure");
	   	}
	}
	
	//prints a given measure from the current profile
	public static void printMeasure(Measure m) {
		
		if(m != null){
			
			System.out.println("\t ==> Mid: " + m.getMid());
			System.out.println("\t ==> Date Registered: " + m.getDateRegistered());
			System.out.println("\t ==> Measure Value: " + m.getMeasureValue());
			System.out.println("\t ==> Measure Type: " + m.getMeasureDefinition().getMeasureType());
			System.out.println("\t ==> Measure Value Type: " + m.getMeasureDefinition().getMeasureValueType());
			
			System.out.println("");
	   	} else{
	   		System.out.println("\tNo measure");
	   	}
	}

}
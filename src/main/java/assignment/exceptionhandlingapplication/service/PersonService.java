package assignment.exceptionhandlingapplication.service;

import assignment.exceptionhandlingapplication.customexception.CustomException;
import assignment.exceptionhandlingapplication.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    List<Person> personList;

    public PersonService(){
        personList = new ArrayList<>();
    }

    public boolean doesPersonExist (Long id){
        for (Person p : personList){
            if (p.getId() == id)
                return true;
        }
        return false;
    }

    public Person addPerson (Person person) throws CustomException {

        if (person.getAge() < 0 ){
            throw new CustomException("Error! Age can not be negative!");
        }

        else if (person.getAge() < 18 && person.getAge()>0 ){
            throw new CustomException("Your age "+person.getAge() +" is illegal age for driving. Must be over 18");
        }

        else if (doesPersonExist(person.getId())){
            throw new CustomException("Id " + person.getId() +" already exists");
        }

        else {
            personList.add(person);
            return person;
        }
    }

    public boolean deletePerson(Long id) {
        Person existingPerson = null;
        boolean isFound = false;
        for (Person p: personList){
            if (p.getId() == id){
                existingPerson = p;
                isFound = true;
            }
        }
        if (!personList.remove(existingPerson))
            throw new NullPointerException("Person with id = "+id+ " not found! Could not delete.");
        return true;
    }

    public List<Person> getAll() {
        if (personList.isEmpty()){
            throw new NullPointerException ("No data found!");
        }
        return personList;
    }

    public Float doDivision(float a, float b){
        if (b==0) throw new ArithmeticException("Math error. Can not divide by zero!");
        else return a/b;
    }
}

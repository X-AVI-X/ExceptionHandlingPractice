package assignment.exceptionhandlingapplication.controller;

import assignment.exceptionhandlingapplication.customexception.ActionResponse;
import assignment.exceptionhandlingapplication.customexception.CustomException;
import assignment.exceptionhandlingapplication.model.Person;
import assignment.exceptionhandlingapplication.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPerson(@RequestBody Person person) throws CustomException {
        Person addedPerson = personService.addPerson(person);
        return new ResponseEntity<>(addedPerson, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePerson (@PathVariable Long id){
        if (personService.deletePerson(id))
            return new ResponseEntity<>(new ActionResponse("Deleted person with id = "+id), HttpStatus.OK);
        else return new ResponseEntity<>("Failed! Not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity <List<Person>> getAllPersons (){
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/do-division")
    public ResponseEntity<ActionResponse> doDivision (@RequestParam Float a, @RequestParam Float b){
        return new ResponseEntity<>(
                new ActionResponse(personService.doDivision(a,b).toString())
                ,HttpStatus.OK
        );
    }
}


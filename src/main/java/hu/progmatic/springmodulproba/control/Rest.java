package hu.progmatic.springmodulproba.control;

import hu.progmatic.springmodulproba.model.Person;
import hu.progmatic.springmodulproba.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
@AllArgsConstructor
public class Rest {
    private EntityService entityService;



   @GetMapping("/persons")
    public List<Person> getAllPerson(){
       return entityService.getAllPersons();

   }



}

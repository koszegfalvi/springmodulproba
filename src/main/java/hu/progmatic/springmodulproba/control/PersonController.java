package hu.progmatic.springmodulproba.control;

import hu.progmatic.springmodulproba.model.Person;
import hu.progmatic.springmodulproba.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {
    private EntityService entityService;

    @GetMapping("/{id}")
    public String getPersonById(Model model, @PathVariable Integer id) {
        Person person = entityService.getPersonById(id);
        model.addAttribute("expenses", entityService.getAllExpensesByPerson(person));
        model.addAttribute("person", person);
        return "person";
    }

    @GetMapping("/new")
    public String createPerson(Model model) {
        model.addAttribute("person", new Person());
        return "person_form";
    }

    @PostMapping("/add")
    public String createPerson(@ModelAttribute("person") Person person) {
        entityService.savePerson(person);
        return "redirect:/home";
    }

    @PostMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") Integer id) {
        entityService.deleteExpensesByPerson(entityService.getPersonById(id));
        entityService.deletePersonById(id);
        return "redirect:/home";
    }

    @GetMapping("/update/{id}")
    public String updatePerson(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("person", entityService.getPersonById(id));
        return "person_update";
    }

    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable("id") Integer id, @ModelAttribute("person") Person updated) {
        entityService.savePerson(updated);
        return "redirect:/person/" + id;
    }

    @GetMapping("/most-expense")
    public String getMostExpense(Model model) {
        Person person = entityService.getMostExpensesPerson();
        model.addAttribute("person", person);
        model.addAttribute("expenses", entityService.getAllExpensesByPerson(person));
        return "person";
    }
}
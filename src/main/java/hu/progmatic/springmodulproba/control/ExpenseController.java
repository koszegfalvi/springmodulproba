package hu.progmatic.springmodulproba.control;

import hu.progmatic.springmodulproba.model.Expense;
import hu.progmatic.springmodulproba.model.Person;
import hu.progmatic.springmodulproba.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/expense")
public class ExpenseController {
 private EntityService entityService;


    @GetMapping("/new{person_id}")
    public  String createExpense(Model model,@PathVariable("person_id")Integer personId){
      model.addAttribute("personId",personId);
        model.addAttribute("expense", new Expense());

        return "expense_form";
    }
    @PostMapping("/add")
    public  String createExpense(@ModelAttribute("expense")Expense expense,@PathVariable("person_id")Integer personId){
       expense.setOwner(entityService.getPersonById(personId));
        entityService.saveExpense(expense);
        return  "redirect:/home";
    }

}

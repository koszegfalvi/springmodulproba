package hu.progmatic.springmodulproba.control;

import hu.progmatic.springmodulproba.model.Person;
import hu.progmatic.springmodulproba.service.EntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.Period;


@Controller
@AllArgsConstructor
public class PageController {
    private EntityService entityService;

    @GetMapping({"","/","/home"})
    public String getHome(Model model){
        model.addAttribute("persons", entityService.getAllPerson());
        return "home";
    }


}
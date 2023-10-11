package hu.progmatic.springmodulproba.service;

import hu.progmatic.springmodulproba.model.Expense;
import hu.progmatic.springmodulproba.model.Person;
import hu.progmatic.springmodulproba.repo.ExpenseRepo;
import hu.progmatic.springmodulproba.repo.PersonRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EntityService {
    private PersonRepo personRepo;
    private ExpenseRepo expenseRepo;

    public List<Person> getAllPersons(){
        return personRepo.findAll();

    }
    public  List<Expense> getAllExpenses(){
        return  expenseRepo.findAll();
    }

public  Person getPersonById(Integer id){
        return personRepo.findById(id).orElse(null);
}
}

package hu.progmatic.springmodulproba.repo;

import hu.progmatic.springmodulproba.model.Expense;
import hu.progmatic.springmodulproba.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense,Integer> {
    List<Expense>getExpensesByOwner(Person person);

   Integer deleteAllByOwner(Person person);

}

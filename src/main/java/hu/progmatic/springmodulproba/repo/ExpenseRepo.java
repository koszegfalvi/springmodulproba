package hu.progmatic.springmodulproba.repo;

import hu.progmatic.springmodulproba.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense,Integer> {
}

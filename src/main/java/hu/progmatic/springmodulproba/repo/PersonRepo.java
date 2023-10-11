package hu.progmatic.springmodulproba.repo;

import hu.progmatic.springmodulproba.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository <Person,Integer> {
}

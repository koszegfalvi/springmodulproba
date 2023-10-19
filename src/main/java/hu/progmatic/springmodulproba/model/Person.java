package hu.progmatic.springmodulproba.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue

    private Integer id;
    private  String name;
    private  String birthPlace;
    private Date birthDate;
    private String email;
@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
@JsonManagedReference
    private Set<Expense> expenses;
public  boolean addExpense(Expense expense){
    return expenses.add(expense);
}
}

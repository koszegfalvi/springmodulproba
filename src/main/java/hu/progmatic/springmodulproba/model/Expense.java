package hu.progmatic.springmodulproba.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
    @Id
    @GeneratedValue
    private  int id;
    private int amount;
    private String place;
    @ManyToOne
    @JoinColumn(name = "people_id")
    private Person owner;




}

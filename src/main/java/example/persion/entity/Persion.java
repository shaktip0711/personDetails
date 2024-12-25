package example.persion.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="person")
public class Persion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double income;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Expenses> expenses = new ArrayList<>();

    public Persion() {}

    public Persion(String name, double income) {
        this.name = name;
        this.income = income;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public List<Expenses> getExpenses() {
        return expenses;
    }

    public double getRemainingAmount() {
        double totalExpenses = expenses.stream().mapToDouble(Expenses::getAmount).sum();
        return income - totalExpenses;
    }

    public void addExpense(Expenses expense) {
        expenses.add(expense);
        expense.setPerson(this);
    }
    
    public void removeExpense(Expenses expense) {
    	expenses.remove(expense);
    	expense.setPerson(null);
    }

    
}

package example.persion.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="expenses")
public class Expenses {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    @Enumerated(EnumType.STRING)
    private ExpensesType type;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Persion person;

    public Expenses() {}

    public Expenses( double amount, ExpensesType type) {
        this.amount = amount;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ExpensesType getType() {
        return type;
    }

    public void setType(ExpensesType type) {
        this.type = type;
    }

	public Persion getPerson() {
		return person;
	}

	public void setPerson(Persion person) {
		this.person = person;
	}
}

package example.persion.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example.persion.entity.Expenses;

@Repository
public interface ExpensesRepo extends JpaRepository<Expenses, Long> {

}

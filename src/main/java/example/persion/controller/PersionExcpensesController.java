package example.persion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.persion.entity.Expenses;
import example.persion.entity.Persion;
import example.persion.repo.PersonRepo;

@RestController
@RequestMapping("/api")
public class PersionExcpensesController {
	
	@Autowired
	private PersonRepo perR;
	
	@PostMapping("/save")
	public Persion savePerson(@RequestBody Persion persion) {
		return perR.save(persion);
	}

	@PutMapping("/update")
	public Persion updatePersion(@RequestBody Persion persion, @PathVariable Long id ) {
		Persion person = perR.findById(id).get();
		if (person != null) 
			person.setName(persion.getName());

		return perR.save(person);
	}
	
	@PostMapping("/{id}/expenses")
	public Persion addExpenseToPerson(@PathVariable Long id, @RequestBody Expenses expense) {
        Persion person = perR.findById(id).get();
        if(person != null)
        person.addExpense(expense);
        return perR.save(person);
    }
	
	@GetMapping("")
	public List<Persion> getPersion(){
		return perR.findAll();		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		perR.deleteById(id);
	}

}

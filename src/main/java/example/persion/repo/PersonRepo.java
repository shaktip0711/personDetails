package example.persion.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example.persion.entity.Persion;

@Repository
public interface PersonRepo extends JpaRepository<Persion, Long> {

}

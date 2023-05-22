package ac.kmgames.model.repository;

import ac.kmgames.model.entity.Cash;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CashRepository extends CrudRepository<Cash, Integer>{
    List<Cash> findAllByEmail(String email);
}

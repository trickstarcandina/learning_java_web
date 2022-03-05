package tacos.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tacos.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
	@Query(value="select * from Ingredient I where I.id='CARN'", nativeQuery=true)
	List<Ingredient> findIngredientCARN();
}

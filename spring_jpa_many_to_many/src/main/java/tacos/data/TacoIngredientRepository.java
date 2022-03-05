package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.TacoIngredient;
import tacos.TacoIngredientId;

public interface TacoIngredientRepository extends CrudRepository<TacoIngredient, TacoIngredientId> {
}


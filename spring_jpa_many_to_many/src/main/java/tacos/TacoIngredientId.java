package tacos;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@RequiredArgsConstructor
public class TacoIngredientId implements Serializable{
	private Long taco_id;
	private String ingredient_id;
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TacoIngredientId)) return false;
        TacoIngredientId that = (TacoIngredientId) o;
        return Objects.equals(taco_id, that.getTaco_id()) &&
                Objects.equals(ingredient_id, that.getIngredient_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(taco_id, ingredient_id);
    }

	public TacoIngredientId(Long taco_id, String ingredient_id) {
		super();
		this.taco_id = taco_id;
		this.ingredient_id = ingredient_id;
	}
}

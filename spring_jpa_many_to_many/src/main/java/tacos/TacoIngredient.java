package tacos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.*;
import tacos.Ingredient.Type;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Taco_Ingredients")
public class TacoIngredient implements Serializable{
	@EmbeddedId
	private TacoIngredientId id;
	
    @ManyToOne
    @MapsId("taco_id")
    @JoinColumn
    private Taco taco;
    
    @ManyToOne
    @MapsId("ingredient_id")
    @JoinColumn
    private Ingredient ingredient;

	public TacoIngredient(Taco taco, Ingredient ingredient) {
		this.taco = taco;
		this.ingredient = ingredient;
		this.id = new TacoIngredientId(taco.getId(), ingredient.getId());
	}    
}

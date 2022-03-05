package tacos;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import tacos.Ingredient.Type;

@Getter
@Setter
@Entity
public class Taco {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	private Long id;
	@NotNull
	@Size(min = 5, message = "Name must be at least 5 characters long")
	private String name;
	private Date createdAt;
	@OneToMany(mappedBy = "taco", cascade = CascadeType.ALL)
    private List<TacoIngredient> tacoIngredients = new ArrayList<TacoIngredient>();

	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}
	
	public void addIngredient(Ingredient ingredient) {
        TacoIngredient tacoIngredient = new TacoIngredient(this, ingredient);
        tacoIngredients.add(tacoIngredient);
        ingredient.getTacoIngredients().add(tacoIngredient);
    } 
}

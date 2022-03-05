package tacos;

import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Taco {
	private Long id;
	private String name;
	private Date createdAt;
	private List<Ingredient> ingredients;
}

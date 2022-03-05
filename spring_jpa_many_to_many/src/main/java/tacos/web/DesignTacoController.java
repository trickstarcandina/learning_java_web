package tacos.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import tacos.Taco;
import tacos.TacoIngredient;
import tacos.data.IngredientRepository;
import tacos.data.TacoIngredientRepository;
import tacos.data.TacoRepository;
import tacos.Ingredient;
import tacos.Ingredient.Type;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
	IngredientRepository ingredientRepo;
	private final TacoRepository tacoRepo;
	TacoIngredientRepository tacoIngredientRepo;

	@Autowired
	public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository tacoRepo, TacoIngredientRepository tacoIngredientRepo) {
		this.ingredientRepo = ingredientRepo;
		this.tacoRepo = tacoRepo;
		this.tacoIngredientRepo = tacoIngredientRepo;
	}
	
	@ModelAttribute
	public void addIngredientsToModel(Model model) {
		List<Ingredient> ingredients = new ArrayList<>();
		ingredientRepo.findAll().forEach(ingredients::add);
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}
	}
	
	@GetMapping
	public String showDesignForm(Model model) {
		model.addAttribute("taco", new Taco());
		return "design";
	}
	
	@PostMapping
	public String processDesign(@RequestParam("ingredients") String ingredientIds, @RequestParam("name") String name) {
		// Save the taco design...
		Taco taco = new Taco();
		taco.setName(name);
		List<TacoIngredient> tacoIngredients = new ArrayList<TacoIngredient>();
		for (String ingredientId : ingredientIds.split(",")) {
			Ingredient ingredient = ingredientRepo.findById(ingredientId).get();
			taco.addIngredient(ingredient);
		}
		tacoRepo.save(taco);
		log.info("Processing design: " + taco);
		return "redirect:/orders/current";
	}

	private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		List<Ingredient> ingrList = new ArrayList<Ingredient>();
		for (Ingredient ingredient: ingredients) {
			if (ingredient.getType().equals(type)) ingrList.add(ingredient);
		}
		return ingrList;
	}
}
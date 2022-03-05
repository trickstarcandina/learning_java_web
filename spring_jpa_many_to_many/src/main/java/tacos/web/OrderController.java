package tacos.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import tacos.Order;
import tacos.Taco;
import tacos.data.IngredientRepository;
import tacos.data.OrderRepository;
import tacos.data.TacoRepository;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
	private final OrderRepository orderRepo;
	@Autowired
	public OrderController(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}
	
	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("order", new Order());
		return "orderForm";
	}
	
	@PostMapping
    public String processOrder(Order order, @SessionAttribute("taco") Taco taco) {
		System.out.println(taco);
		List<Taco> tacos = new ArrayList<Taco>();
		tacos.add(taco);
		order.setTacos(tacos);
		orderRepo.save(order);
		log.info("Order submitted: " + order);
		return "redirect:/";
	}
}


package tacos;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Order {
	private String name;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String ccNumber;
	private String ccExpiration;
	private String ccCVV;
}
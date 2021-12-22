package az.developia.compshopNihatHeyderov.controller;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

	@GetMapping(path="/computers-shopping")
	public String showCustomerPage(Model model) {
		ArrayList<String> computers = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			computers.add("");
		}
		model.addAttribute("computers",computers);
		return "Customer";
	}
}

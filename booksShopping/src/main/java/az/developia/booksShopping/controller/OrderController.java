package az.developia.booksShopping.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.booksShopping.config.MySession;
import az.developia.booksShopping.dao.BookDAO;
import az.developia.booksShopping.dao.OrderDAO;
import az.developia.booksShopping.model.BasketBook;
import az.developia.booksShopping.model.Book;
import az.developia.booksShopping.model.Customer;
import az.developia.booksShopping.model.Order;
import az.developia.booksShopping.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private MySession mySession;

	@Autowired
	private OrderService orderService;

	@GetMapping(path = "/orders")
	public String showOrdersPage(Model model) {
		model.addAttribute("orders", orderDAO.findAllByUsername(mySession.getUsername()));
		return "orders";
	}

	@GetMapping(path = "/confirm-order")
	public String showConfirmOrderPage(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "confirm-order";
	}

	@GetMapping(path = "/order-confirmation-message")
	public String showOrderConfirmationPage() {

		return "order-confirmation-message";
	}

	@PostMapping(path = "/confirm-order-process")
	public String confirmOrderProcess(@Valid @ModelAttribute(name = "customer") Customer customer,
			BindingResult result) {
		if (result.hasErrors()) {
			return "confirm-order";
		}

		orderService.save(customer);
		
		return "redirect:/order-confirmation-message";
	}
}

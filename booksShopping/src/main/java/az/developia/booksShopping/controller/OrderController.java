package az.developia.booksShopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.booksShopping.config.MySession;
import az.developia.booksShopping.dao.BookDAO;
import az.developia.booksShopping.dao.OrderDAO;
import az.developia.booksShopping.model.Book;

@Controller
public class OrderController {
	
@Autowired
private OrderDAO orderDAO;

@Autowired
private MySession mySession;

@GetMapping(path="/orders")
public String showOrdersPage(Model model){
	model.addAttribute("orders",orderDAO.findAllByUsername(mySession.getUsername()));
	return "orders";
}
@GetMapping(path="/confirm-order")
public String showConfirmOrderPage(){
	
	return "confirm-order";
}
@GetMapping(path="/order-confirmation-message")
public String showOrderConfirmationPage(){
	
	return "order-confirmation-message";
}

}

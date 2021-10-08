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

import az.developia.booksShopping.dao.BookDAO;
import az.developia.booksShopping.model.Book;

@Controller
public class CustomController {
@Autowired
private BookDAO bookDAO;

@GetMapping(path="/customer")
public String showCustomerPage(){
	
	return "customer";
}


}
package az.developia.booksShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import az.developia.booksShopping.config.MySession;



@Controller
public class HomeController {
	
	@Autowired
	private MySession mySession;
	
@GetMapping(path={"/home","/"})
public String showHomePage() {

	return "home";
}
}

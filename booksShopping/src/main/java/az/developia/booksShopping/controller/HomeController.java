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
<<<<<<< Updated upstream
	System.out.println(mySession.getBasketbooks());
=======
<<<<<<< HEAD
	System.out.println(mySession.getBasketBooks());
=======
	System.out.println(mySession.getBasketbooks());
>>>>>>> 867e20b5f6c4b673c2bfa9b9a8927200eac97772
>>>>>>> Stashed changes
	return "home";
}
}

package az.developia.booksShopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.booksShopping.dao.BookDAO;
import az.developia.booksShopping.dao.UserDAO;
import az.developia.booksShopping.model.Book;
import az.developia.booksShopping.model.User;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	
	private boolean userCreated = false;
@GetMapping(path="/show-login")
public String showLoginPage(Model model) {
	if(userCreated) {
	model.addAttribute("userCreated", "");
	userCreated=false;
	}
	return "my-custom-login";
}

@GetMapping(path="/creat-account")
public String showCreatAccountPage(Model model) {
	User user = new User();
	model.addAttribute("user", user);
return "creat-account";
}


@PostMapping(path="/creat-account-process")
public String saveUser(@Valid @ModelAttribute(name="user")User user,
		BindingResult result,Model model) {
	if(result.hasErrors()) {
		return "creat-account";
	}
	//System.out.println(user);
    boolean userExits=userDAO.creatUser(user);
    if (userExits) {
    	model.addAttribute("userExits","");
		return "creat-account";
	}else {

		userDAO.creatUser(user);

	}
	userCreated = true;
	model.addAttribute("userCreated", "");
	return "redirect:/show-login";
	
	

}
}

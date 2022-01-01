package az.developia.compshopNihatHeyderov.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.compshopNihatHeyderov.dao.UserDAO;
import az.developia.compshopNihatHeyderov.model.User;

@Controller
public class UserController {

	@Autowired
  private UserDAO userDAO;
	
	private boolean userCreated = false;
	@GetMapping(path="/show-login")
	public String showLoginPage(Model model) {
		if(userCreated) {
			model.addAttribute("userCreated","");
			userCreated=false;
		}
			
		return "custom-login";
	}
	
	@GetMapping(path="/show-creataccount")
	public String showCreatAccountPage(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "creat-account";
	}
	
	
	@PostMapping(path="/new-creataccount-proccess")
	public String createNewAccount(@ModelAttribute(name="user")User user,Model model,BindingResult result) {
		if(result.hasErrors()) {
			return "show-creataccount";
		}
		boolean userExits = userDAO.createUser(user);
		if(userExits) {
			model.addAttribute("userExits","");
			return "creat-account";
		}else {
			userDAO.createUser(user);
		}
		userCreated=true;
		model.addAttribute("userCreated","");
		return "redirect:/custom-login";
	}
}

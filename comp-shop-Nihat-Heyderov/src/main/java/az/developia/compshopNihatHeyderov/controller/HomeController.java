package az.developia.compshopNihatHeyderov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import az.developia.compshopNihatHeyderov.config.MySession;

@Controller
public class HomeController {
	
	@Autowired
	private MySession mySession;
	
	
	@GetMapping(path="/")
	public String showHomePage(Model model) {
		model.addAttribute("username","İstifadəçi adı:"+mySession.getUsername());
	return "home";
}

}

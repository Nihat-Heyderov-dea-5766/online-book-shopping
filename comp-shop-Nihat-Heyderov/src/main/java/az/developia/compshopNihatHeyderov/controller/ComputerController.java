package az.developia.compshopNihatHeyderov.controller;

import java.util.Arrays;
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

import az.developia.compshopNihatHeyderov.dao.ComputerDAO;
import az.developia.compshopNihatHeyderov.model.Computer;



@Controller
public class ComputerController {

	@Autowired
private ComputerDAO computerDAO;
	

@GetMapping(path="/computers")
public String showComputers(Model model) {
	List<Computer> computers = computerDAO.findAll();
	model.addAttribute("computers",computers);
	
return "computers";
}

@GetMapping(path="/computers/new")
public String openNewCompPage(Model model) {
	Computer computer = new Computer();
	model.addAttribute("computer",computer);
	List<String> Liststatus = Arrays.asList("Yeni","Kohne");
	model.addAttribute("Liststatus",Liststatus);
	return "new-computer";
}

@PostMapping(path="/computers/new-computer-proccess")
public String saveComputer(@Valid @ModelAttribute(name="computer")Computer computer,BindingResult result,Model model) {											
	if(result.hasErrors()) {
		List<String> Liststatus = Arrays.asList("Yeni","Kohne");
		model.addAttribute("Liststatus",Liststatus);
		return "new-computer";
	}
	List<Computer> computers = computerDAO.findAll();
	model.addAttribute("computers",computers);
	computerDAO.save(computer);
	return "redirect:/computers";
	
}

@GetMapping(path="/computers/delete/{id}")
public String computerDelete(@PathVariable(name="id")Integer id,Model model) {
	boolean computerExits = computerDAO.findById(id).isPresent();
	if(computerExits) {
		computerDAO.deleteById(id);
	}
	List<Computer> computers = computerDAO.findAll();
	model.addAttribute("computers", computers);
	return "redirect:/computers";
}

@GetMapping(path="/computers/edit/{id}")
public String computerUpdate(@PathVariable(name="id")Integer id,Model model) {
   Optional<Computer> computerOptional = computerDAO.findById(id);
   boolean compExits = computerOptional.isPresent();
   Computer computer = new Computer();
	if(compExits) {
		computer = computerOptional.get();
	}
	model.addAttribute("computer",computer);
	return "new-computer";
}

}

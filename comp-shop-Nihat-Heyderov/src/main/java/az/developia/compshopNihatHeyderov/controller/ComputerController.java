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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import az.developia.compshopNihatHeyderov.config.MySession;
import az.developia.compshopNihatHeyderov.dao.ComputerDAO;
import az.developia.compshopNihatHeyderov.file.StorageService;
import az.developia.compshopNihatHeyderov.model.Computer;



@Controller
public class ComputerController {

	@Autowired
private ComputerDAO computerDAO;
	
	@Autowired
	private MySession mySession;

	@Autowired
	private StorageService storageService;
	
@GetMapping(path="/computers")
public String showComputers(Model model) {
	//List<Computer> computers = computerDAO.findAll();
	List<Computer> computers = computerDAO.findAllByUsername(mySession.getUsername());
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
public String saveComputer(@Valid @ModelAttribute(name="computer")Computer computer,BindingResult result,Model model
		,@RequestParam(value="imageFile",required=false)MultipartFile imageFile) {											

	if(result.hasErrors()) {
		List<String> Liststatus = Arrays.asList("Yeni","Kohne");
		model.addAttribute("Liststatus",Liststatus);
		return "new-computer";
	}
computer.setUsername(mySession.getUsername());

	if(imageFile.isEmpty() && computer.getId()!=null) {
		computer.setImage(computerDAO.findById(computer.getId()).get().getImage());}else {
		computer.setImage(storageService.store(imageFile));}
	
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
		 List<String> Liststatus = Arrays.asList("Yeni","Kohne");
	model.addAttribute("Liststatus",Liststatus);
		computer = computerOptional.get();
	}
	model.addAttribute("computer",computer);
	return "new-computer";
}

}

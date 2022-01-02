package az.developia.compshopNihatHeyderov.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import az.developia.compshopNihatHeyderov.config.MySession;
import az.developia.compshopNihatHeyderov.dao.ComputerDAO;
import az.developia.compshopNihatHeyderov.model.Computer;

@Controller
public class CustomerController {

	@Autowired
	private ComputerDAO computerDAO;
	
	@Autowired
	private MySession mySession;
	
	@GetMapping(path="/computers-shopping")
	public String showCustomerPage(Model model) {
		List<Computer> computers = computerDAO.findAllByUsername(mySession.getUsername());
		model.addAttribute("computers",computers);
		return "customer";
	}
	
	@GetMapping(path="/computers/details/{id}")
	public String showDetailsPage(@ModelAttribute(name="id")Integer id,Model model) {
  Optional<Computer> computersOptional= computerDAO.findById(id);
  boolean compExits = computersOptional.isPresent();
  Computer computers = new Computer();
  if(compExits) {
	  computers = computersOptional.get();
  }
	model.addAttribute("computers",computers);
		return "computer-details";
	}
}

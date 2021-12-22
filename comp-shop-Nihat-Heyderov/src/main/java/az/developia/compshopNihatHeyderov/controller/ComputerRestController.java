package az.developia.compshopNihatHeyderov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.compshopNihatHeyderov.dao.ComputerDAO;
import az.developia.compshopNihatHeyderov.model.Computer;

@RestController
@RequestMapping(path="/rest/computers")
public class ComputerRestController {

	@Autowired 
	private ComputerDAO computerDAO;
	
	@GetMapping
	public List<Computer> findAll(){
	return computerDAO.findAll();
	}
	@GetMapping(path="/computers/{id}")
	public Computer findById(@PathVariable(name="id")Integer id) {
	   return computerDAO.findById(id).get();
	}

}

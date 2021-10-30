package az.developia.booksShopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.booksShopping.dao.BookDAO;
import az.developia.booksShopping.model.Book;
import az.developia.booksShopping.model.SearchModel;

@RestController
@RequestMapping(path="/rest/books")
public class BooksController {
	 
	@Autowired
	private BookDAO bookDAO;
	
@GetMapping
public List <Book>findAll(){
	return bookDAO.findAll();
}

@GetMapping(path="/{id}")
public Book findById(@PathVariable(name="id")Integer id){
	return bookDAO.findById(id).get();
}

@PostMapping(path="/search")
public List<Book> findAllSearch(@RequestBody SearchModel search){
	return bookDAO.findAllSearchAllFields(search.getSearch());
}
@PostMapping(path="/search-find-partial")
public List<Book> findAllSearchFindPatrial(@RequestBody SearchModel search){
	return bookDAO.findAllSearchAllFieldsFindP(search.getSearch(), search.getBegin(), search.getLength());
}
}

package az.developia.booksShopping.controller;

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

import az.developia.booksShopping.config.MySession;
import az.developia.booksShopping.dao.BookDAO;
import az.developia.booksShopping.file.StorageService;
import az.developia.booksShopping.model.Book;

@Controller
public class BookController {
@Autowired
private BookDAO bookDAO;

@Autowired
private MySession mySession;

@Autowired
private StorageService storageService;

@GetMapping(path="/books")
public String showBooks(Model model){
	//List<Book> books = bookDAO.findAll();
	List<Book> books = bookDAO.findAllByUsername(mySession.getUsername());
	model.addAttribute("books", books);
	model.addAttribute("username", "Isdifadeci :"+mySession.getUsername());
	return "books";
}

@GetMapping(path="/books/new")
public String openNewPage(Model model) {
	Book book = new Book();
	model.addAttribute("book", book);
	model.addAttribute("header","yeni kitab");
	return "new-book";
	
}

@PostMapping(path="/books/new-book-process")
public String saveBook(@Valid @ModelAttribute(name="book")Book book,
		BindingResult result,
		@RequestParam(value="imageFile",required=true) MultipartFile imageFile,Model model) {
	System.out.println(imageFile);
	if(result.hasErrors()) {
		return "new-book";
	}
	//book.setImage("book.jpg");
	book.setUsername(mySession.getUsername());
	
	if(imageFile.isEmpty() && book.getId()!=null) {
		book.setImage(bookDAO.findById(book.getId()).get().getImage());
	}else {
		book.setImage(storageService.store(imageFile));}
	
	List<Book> books = bookDAO.findAll();
	model.addAttribute("books", books);
	bookDAO.save(book);
	return "redirect:/books";
	
	

}

@GetMapping(path="/books/delete/{id}")
public String deleteBook(@PathVariable(name="id") Integer id, Model model) {
	boolean bookExists = bookDAO.findById(id).isPresent();
	if(bookExists) {
		bookDAO.deleteById(id);
	}else {
	
	}
	List<Book> books = bookDAO.findAll();
	model.addAttribute("books", books);
	
	return "redirect:/books";
	
}

@GetMapping(path="/books/edit/{id}")
public String editBook(@PathVariable(name="id") Integer id,Model model) {
	Optional<Book> bookOptional =  bookDAO.findById(id);
	boolean bookExists =bookOptional.isPresent();
	Book book = new Book();
	if(bookExists) {
	book =bookOptional.get();
	}

	model.addAttribute("book", book);
	model.addAttribute("header","kitab redaktesi");
	return "new-book";
	
}
}

package az.developia.booksShopping.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.booksShopping.model.Book;



public interface BookDAO extends JpaRepository<Book, Integer> {
public List<Book> findAllByUsername(String username);
}

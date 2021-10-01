package az.developia.booksShopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.booksShopping.model.Book;



public interface BookDAO extends JpaRepository<Book, Integer> {

}

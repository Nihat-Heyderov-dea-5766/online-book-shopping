package az.developia.booksShopping.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.booksShopping.model.Book;
import az.developia.booksShopping.model.Order;



public interface OrderDAO extends JpaRepository<Order, Integer> {
public List<Order> findAllByUsername(String username);
}

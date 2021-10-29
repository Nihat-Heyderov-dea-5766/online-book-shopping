package az.developia.booksShopping.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.developia.booksShopping.model.Book;



public interface BookDAO extends JpaRepository<Book, Integer> {
public List<Book> findAllByUsername(String username);
@Query(value="select * from book where name like %?1%",nativeQuery=true)
public List<Book> findAllSearch(String search);
@Query(value="select * from book where name like %?1% or descrption like %?1% or page-count like %?1% or author like %?1%",nativeQuery=true)
public List<Book> findAllSearchAllFields(String search);
@Query(value="select * from book where name like %?1% or descrption like %?1% or page-count like %?1% or author like %?1% limit ?2,?3",nativeQuery=true)
public List<Book> findAllSearchAllFieldsFindP(String search,Integer begin,Integer lenght);
}

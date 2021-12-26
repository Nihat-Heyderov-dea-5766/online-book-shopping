package az.developia.compshopNihatHeyderov.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import az.developia.compshopNihatHeyderov.model.Computer;

public interface ComputerDAO extends JpaRepository<Computer,Integer>{
public List<Computer> findAllByUsername(String username);
  
}

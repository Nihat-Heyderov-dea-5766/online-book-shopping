package az.developia.compshopNihatHeyderov.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import az.developia.compshopNihatHeyderov.model.User;

@Component
public class UserDAO {
 
	@Autowired
 DataSource datasource;
	
  private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public boolean createUser(User user) {
	 boolean userExits=false;
	 try {
		 Connection conn = datasource.getConnection();
		 PreparedStatement ps = conn.prepareStatement("select username from users where  username=?");
		 ps.setString(1,user.getUsername());
		 ResultSet rs = ps.executeQuery();
		 if(rs.next()) {
			 userExits=true;
		rs.close();	 
		ps.close(); 
		 }else {
			 rs.close();	 
			 ps.close(); 
			 ps = conn.prepareStatement("Insert into users (username,password,email,phone,name,surname,enabled) values (?,?,?,?,?,?,?) ");
			 ps.setString(1, user.getUsername());
			 ps.setString(2, "{bcrypt}"+passwordEncoder.encode(user.getPassword()));
			 ps.setString(3, user.getEmail());
			 ps.setString(4, user.getPhone());
			 ps.setString(5, user.getName());
			 ps.setString(6, user.getSurname());
			 ps.setByte(7, (byte)1);
			 ps.executeUpdate();
			 
			 
			 ps = conn.prepareStatement("Insert into authorities (username,authority) values (?,?) ");
			 ps.setString(1, user.getUsername());
			 ps.setString(2, "seller");
			 
			 ps.executeUpdate();
			 
			 
			 ps.close();
			 ps = conn.prepareStatement("Insert into authorities (username,authority)values(?,?)");
			 ps.setString(1,user.getUsername());
			 ps.setString(2, "ROLE_ADMIN");
			 ps.executeUpdate();
			 ps.close();
		 }
		 conn.close();
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 return userExits;
	}
}

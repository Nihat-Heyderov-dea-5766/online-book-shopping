package az.developia.booksShopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import az.developia.booksShopping.model.User;

@Component
public class UserDAO {

	
	@Autowired
	private DataSource datasource;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public boolean creatUser(User user) {
	 boolean userExits = false; 
		try {
			Connection conn = datasource.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("Select username from users where username=?");
			ps.setString(1,user.getUsername());
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				userExits = true;
				rs.close();
				ps.close();
			}else {
				rs.close();
				ps.close();
				ps = conn.prepareStatement("insert into user(username,password,enabled)values (?,?,?);");
				ps.setString(1,user.getUsername());
				ps.setString(2,"{bcrypt}"+passwordEncoder.encode(user.getPassword()));
				ps.setByte(3,(byte)1);
				ps.executeUpdate();
				ps.close();
				ps = conn.prepareStatement("insert into authorihies(username,authorihies)values (?,?);");
				ps.setString(1,user.getUsername());
				ps.setString(2,"ROLE_ADMIN");
				ps.executeUpdate();
				ps.close();
			}
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userExits;
	}
}

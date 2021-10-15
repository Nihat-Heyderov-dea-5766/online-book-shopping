package az.developia.booksShopping.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
	@NotEmpty(message = "bos qoymaq olmaz")
	@Size(min=1,message="Isdifadeci adi minimum 1 simvol olmalidir")
	@Size(max=30,message="Isdifadeci adi maxsimum 30 simvol olmalidir")
public String username;
	@NotEmpty(message = "bos qoymaq olmaz")
	@Size(min=1,message="Sifre minimum 1 simvol olmalidir")
	@Size(max=30,message="Sifre maxsimum 30 simvol olmalidir")
public String password;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "User [username=" + username + ", password=" + password + "]";
}

}

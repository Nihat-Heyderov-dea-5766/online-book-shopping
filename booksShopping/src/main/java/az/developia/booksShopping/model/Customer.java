package az.developia.booksShopping.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message="bos qoymaq olmaz")
	@Size(min=2,max=30,message="Minimum 2  Maxsimum 30 simvol lazimdir")
	@Column(columnDefinition="varchar(30)")
	private String name;
	@NotEmpty(message="bos qoymaq olmaz")
	@Size(min=2,max=30,message="Minimum 2  Maxsimum 200 simvol lazimdir")
	@Column(columnDefinition="varchar(200)")
	private String address;	@NotEmpty(message="bos qoymaq olmaz")
	@NotEmpty(message="bos qoymaq olmaz")
	@Pattern(regexp="((\\(\\d{3}\\) ?)|(\\d{3}-))?\\d{3}-\\d{4}",message="Telefonu duzgun formada yazin. Meselen:000-000-0000")
	@Column(columnDefinition="varchar(20)")
	@Size(max=20,message="Maxsimum 20 simvol lazimdir")
	private String phone;
	@NotEmpty(message="bos qoymaq olmaz")
	@Email(regexp="[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$",message="Telefonu duzgun formada yazin")
	@Column(columnDefinition="varchar(100)")
	@Size(max=100,message="Maxsimum 100 simvol lazimdir")
	private String email;
	@Column(columnDefinition="varchar(100)")
	@Size(max=100,message="Maxsimum 100 simvol lazimdir")
	private String note;
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

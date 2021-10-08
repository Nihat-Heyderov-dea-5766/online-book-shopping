package az.developia.booksShopping.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message="bos qoymaq olmaz")
	@Size(min=2,max=30,message="Minimum 2  Maxsimum 30 simvol lazimdir")
	@Column(columnDefinition="varchar(30)")
	private String name;
	@Column(columnDefinition="varchar(300)")
	@Size(max=300,message="Maxsimum 300 simvol lazimdir")
	private String description;
	@Min(value=0,message="Minumum 0 yazmaq olar")
	@Max(value=1000,message="Maxsimum 1000 yazmaq olar")
	@NotNull(message="bos qoymaq olmaz")
	private Double price;
	@Column(columnDefinition="varchar(30)")
	@Size(max=30,message="Maxsimum 30 simvol lazimdir")
	private String author;
	@Min(value=0,message="Minumum 0 yazmaq olar")
	@Max(value=10000,message="Maxsimum 10000 yazmaq olar")
	private Integer pageCount;
	private String image;
	private String username;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	
}

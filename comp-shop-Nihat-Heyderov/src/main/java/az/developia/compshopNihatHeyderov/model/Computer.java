package az.developia.compshopNihatHeyderov.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Computer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
	@NotEmpty(message="bos qoymaq olmaz")
	@Size(min=1,max=30,message="1 simvoldan az 30 simvoldan coz ola bilmez")
  private String marka;
  private String model;
	@NotEmpty(message="bos qoymaq olmaz")
	@Size(min=0,max=10000,message="qiymet 10000 cox olam bilmez")
  private Integer price;
  private String description;
  private String status;
  
private String image;
  private Integer ram;
  private String cpu;
  private String rom;
  private String  cd;
  private String operationsystem;
  private String videocard;
  private String username;

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getMarka() {
	return marka;
}
public void setMarka(String marka) {
	this.marka = marka;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public Integer getPrice() {
	return price;
}
public void setPrice(Integer price) {
	this.price = price;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Integer getRam() {
	return ram;
}
public void setRam(Integer ram) {
	this.ram = ram;
}
public String getCpu() {
	return cpu;
}
public void setCpu(String cpu) {
	this.cpu = cpu;
}
public String getRom() {
	return rom;
}
public void setRom(String rom) {
	this.rom = rom;
}
public String getCd() {
	return cd;
}
public void setCd(String cd) {
	this.cd = cd;
}
public String getOperationsystem() {
	return operationsystem;
}
public void setOperationsystem(String operationsystem) {
	this.operationsystem = operationsystem;
}
public String getVideocard() {
	return videocard;
}
public void setVideocard(String videocard) {
	this.videocard = videocard;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
  public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
  
}

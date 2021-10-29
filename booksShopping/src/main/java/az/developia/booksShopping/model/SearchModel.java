package az.developia.booksShopping.model;

public class SearchModel {
private String search;
private Integer begin;
private Integer lenght;

public Integer getBegin() {
	return begin;
}

public void setBegin(Integer begin) {
	this.begin = begin;
}

public Integer getLenght() {
	return lenght;
}

public void setLenght(Integer lenght) {
	this.lenght = lenght;
}

public String getSearch() {
	return search;
}

public void setSearch(String search) {
	this.search = search;
}

}

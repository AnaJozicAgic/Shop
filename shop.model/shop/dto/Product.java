package shop.dto;

public class Product {
private int id;
private String name;
private double price;
private String description;
private String img;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description + ", img=" + img
			+ "]";
}


}

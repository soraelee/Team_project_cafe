package menu.dto;

public class MenuDTO {
	private String productid, product, coffee_type;
	private int price;
	
	public MenuDTO(String productid,  String product, String coffee_type, int price) {
		this.productid = productid;
		this.product = product;
		this.coffee_type = coffee_type;
		this.price = price;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getCoffee_type() {
		return coffee_type;
	}

	public void setCoffee_type(String coffee_type) {
		this.coffee_type = coffee_type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}

package stockDTO;


public class DTO {
	private String productld, product, price, coffee_type, cnt;
	
	public DTO() {
		
	}
	
	public DTO(String productld, String product, String coffee_type, String cnt, String price ) {
	this.productld = productld ; this.price = price; this.coffee_type = coffee_type;
	this.product = product; this.cnt = cnt;
}

	
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProductld() {
		return productld;
	}

	public void setProductld(String productld) {
		this.productld = productld;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCoffee_type() {
		return coffee_type;
	}

	public void setCoffee_type(String coffee_type) {
		this.coffee_type = coffee_type;
	}

	public String getCnt() {
		return cnt;
	}

	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	



	
}

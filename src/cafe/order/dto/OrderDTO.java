package cafe.order.dto;

public class OrderDTO {
	private String productId, product, coffee_type, cnt;
	private int price ;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
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
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
package cafe.payment.dto;

public class PaymentDTO {
	private String product, cnt, price, totCnt, totPrice;
//	private int price;
	
	public PaymentDTO() {}
	public PaymentDTO(String product, String cnt, String totCnt, String totPrice, String price) {
		this.product = product;
		this.cnt = cnt;
		this.totCnt = totCnt;
		this.totPrice = totPrice;
		this.price = price;
	}
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public String getTotCnt() {
		return totCnt;
	}
	public void setTotCnt(String totCnt) {
		this.totCnt = totCnt;
	}
	public String getTotPrice() {
		return totPrice;
	}
	public void setTotPrice(String totPrice) {
		this.totPrice = totPrice;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}	

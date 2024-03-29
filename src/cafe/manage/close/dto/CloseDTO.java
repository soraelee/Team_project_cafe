package cafe.manage.close.dto;

public class CloseDTO {
	private String productid, product, coffee_type, totcnt, totprice, managerid, customerid;

	
	public CloseDTO() {}
	public CloseDTO(String productid, String product, String coffee_type, String totcnt, String totprice, String managerid, String customerid) {
		this.productid = productid;
		this.product = product;
		this.coffee_type = coffee_type;
		this.totcnt = totcnt; 
		this.totprice = totprice;
		this.managerid = managerid;
		this.customerid = customerid;
	}
	
	
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
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

	public String getTotcnt() {
		return totcnt;
	}

	public void setTotcnt(String totcnt) {
		this.totcnt = totcnt;
	}

	public String getTotprice() {
		return totprice;
	}

	public void setTotprice(String totprice) {
		this.totprice = totprice;
	}

	public String getManagerid() {
		return managerid;
	}

	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}
	
	

}

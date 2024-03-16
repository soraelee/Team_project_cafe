package stockDTO;

import javafx.beans.property.StringProperty;

public class stockProperty {
	private String name, price, type, cnt;
	
	public stockProperty(String name, String price, String type, String cnt) {
		this.name = name; this.price = price; this.type = type; this.cnt=cnt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCnt() {
		return cnt;
	}

	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	
	
	
	
//	
//	private StringProperty name;
//	private StringProperty price;
//	private StringProperty type;
//	private StringProperty cnt;
//	
//	public stockProperty(String string, String string2, 
//			String string3, String string4) {
////		this.name = string;
////		this.price = string;
////		this.type = string3;
////		this.cnt = string4;
//	}
//	
//	public StringProperty getName() {
//		return name;
//	}
//	public StringProperty getPrice() {
//		return price;
//	}
//	public StringProperty getType() {
//		return type;
//	}
//	public StringProperty getCnt() {
//		return cnt;
//	}

	

}

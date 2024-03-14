package cafe.manage.close.property;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

public class CloseProperty {
	private StringProperty mngerId;
	private StringProperty prdId;
	private StringProperty prdName;
	private StringProperty type;
	private StringProperty totCnt;
	private StringProperty totPrice;
	
	public CloseProperty(StringProperty mngerId, StringProperty prdId, StringProperty prdName, 
	StringProperty type, StringProperty totCnt, StringProperty totPrice) {
		this.mngerId = mngerId;
		this.prdId = prdId;
		this.prdName = prdName;
		this.type = type;
		this.totCnt = totCnt;
		this.totPrice = totPrice;
	}

	public StringProperty getMngerId() {
		return mngerId;
	}

	public StringProperty getPrdId() {
		return prdId;
	}

	public StringProperty getPrdName() {
		return prdName;
	}

	public StringProperty getType() {
		return type;
	}

	public StringProperty getTotCnt() {
		return totCnt;
	}

	public StringProperty getTotPrice() {
		return totPrice;
	}
	
	

}

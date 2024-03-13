package cafe.login.dto;

public class LoginDTO {
	private String managerid, managerpwd, managername, phone, birth;
	
	public LoginDTO() {
		
	}

	public LoginDTO(String managerid, String managerpwd, String managername) {
		this.managerid = managerid; this.managerpwd = managerpwd;
		this.managername = managername;
	}
	public LoginDTO(String managerid, String managerpwd, String managername, String birth, String phone) {
		this.managerid = managerid; this.managerpwd = managerpwd;
		this.managername = managername;this.birth = birth;
		this.phone = phone;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getBirth() {
		return birth;
	}
	
	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getManagerid() {
		return managerid;
	}

	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}

	public String getManagerpwd() {
		return managerpwd;
	}

	public void setManagerpwd(String managerpwd) {
		this.managerpwd = managerpwd;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}
	
	

}

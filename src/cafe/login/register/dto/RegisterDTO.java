package cafe.login.register.dto;

public class RegisterDTO {
	private String managerid, managerpwd, managername, phone, birth;
	
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

package cafe.login.dto;

public class LoginDTO {
	private String managerid, managerpwd, managername;
	

	public LoginDTO(String managerid, String managerpwd, String managername) {
		this.managerid = managerid; this.managerpwd = managerpwd;
		this.managername = managername;
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

package Dao_users;

public class users {

	// 学号
	private String idcode;
	// 姓名
	private String name;
	// 电话
	private String phone;
	// 身份证
	private String idCard;
	// 驾驶年龄
	private int driving;
	// 状态
	private String status;

	// private String userName;
	private String password;

	public users() {
	}

	public String getIdcode() {
		return idcode;
	}

	public void setIdcode(String idcode) {
		this.idcode = idcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public int getDriving() {
		return driving;
	}

	public void setDriving(int driving) {
		this.driving = driving;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

/*
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
*/

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

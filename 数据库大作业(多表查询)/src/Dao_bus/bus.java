package Dao_bus;

public class bus {

	// 学号
	private String busCode;
	// 姓名
	private String busLicense;
	// 电话
	private String busStatus;
	// 身份证
	private String busType;
	// 驾驶年龄
	private String startTime;
	// 状态


	public bus() {
	}


	public String getBusCode() {
		return busCode;
	}

	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}

	public String getBusLicense() {
		return busLicense;
	}

	public void setBusLicense(String busLicense) {
		this.busLicense = busLicense;
	}

	public String getBusStatus() {
		return busStatus;
	}

	public void setBusStatus(String busStatus) {
		this.busStatus = busStatus;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
}

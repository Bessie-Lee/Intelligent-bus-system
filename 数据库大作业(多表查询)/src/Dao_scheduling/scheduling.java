package Dao_scheduling;

public class scheduling {

	// 学号
	private String code;
	// 姓名
	private String lineCode;
	// 电话
	private String busLinense;
	// 身份证
	private String tcNumber;
	// 驾驶年龄
	private String tcTime;
	// 状态
	private String userCode;

	private String startStation;
	private String endStation;

	public scheduling() {
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLineCode() {
		return lineCode;
	}

	public void setLineCode(String lineCode) {
		this.lineCode = lineCode;
	}

	public String getBusLinense() {
		return busLinense;
	}

	public void setBusLinense(String busLinense) {
		this.busLinense = busLinense;
	}

	public String getTcNumber() {
		return tcNumber;
	}

	public void setTcNumber(String tcNumber) {
		this.tcNumber = tcNumber;
	}

	public String getTcTime() {
		return tcTime;
	}

	public void setTcTime(String tcTime) {
		this.tcTime = tcTime;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getStartStation() {
		return startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	public String getEndStation() {
		return endStation;
	}

	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}
}

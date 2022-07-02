package Dao_line;

public class line {

	// 学号
	private String lineCode;
	// 姓名
	private String lineName;
	// 电话
	private String status;
	// 身份证
	private String startLineTime;
	// 驾驶年龄
	private String direction;
	// 状态


	public line() {
	}


	public String getLineCode() {
		return lineCode;
	}

	public void setLineCode(String lineCode) {
		this.lineCode = lineCode;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartLineTime() {
		return startLineTime;
	}

	public void setStartLineTime(String startLineTime) {
		this.startLineTime = startLineTime;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
}

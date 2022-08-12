package SecondCode;

public class StudentVO {
	private int std_no;
	private String std_name;
	private String major;
	private int age;
	private int rsvs_cnt;
	private int loan_cnt;
	private String stop_date;
	
	public StudentVO() {}
	
	public StudentVO(int std_no,String std_name,String major,int age,int rsvs_cnt,int loan_cnt,String stop_date) {
		
		this.std_no = std_no;
		this.std_name = std_name;
		this.major = major;
		this.age = age;
		this.rsvs_cnt = rsvs_cnt;
		this.loan_cnt = loan_cnt;
		this.stop_date = stop_date;
	}
	
	public StudentVO(String data) {
		
		String[] temp = data.split(",");
		this.std_no = Integer.parseInt(temp[0].trim());
		this.std_name = temp[1].trim();
		this.major = temp[2].trim();
		this.age = Integer.parseInt(temp[3].trim());
		this.rsvs_cnt = Integer.parseInt(temp[4].trim());
		this.loan_cnt = Integer.parseInt(temp[5].trim());
		this.stop_date = temp[6].trim();
	}

	public int getStd_no() {
		return std_no;
	}

	public void setStd_no(int std_no) {
		this.std_no = std_no;
	}

	public String getStd_name() {
		return std_name;
	}

	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRsvs_cnt() {
		return rsvs_cnt;
	}

	public void setRsvs_cnt(int rsrv_cnt) {
		this.rsvs_cnt = rsrv_cnt;
	}

	public int getLoan_cnt() {
		return loan_cnt;
	}

	public void setLoan_cnt(int loan_cnt) {
		this.loan_cnt = loan_cnt;
	}

	public String getStop_date() {
		return stop_date;
	}

	public void setStop_date(String stop_date) {
		this.stop_date = stop_date;
	}
}

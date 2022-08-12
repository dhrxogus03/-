package SecondCode;

public class LoanVO {
	private int seq;
    private String loan_date;
    private String exp_return_date;
    private int std_no;
    private int book_no;
    private String return_date;
    private String return_yn;
    
    public LoanVO() {}
    
    public LoanVO(int seq,String loan_date,String exp_return_date,int std_no,int book_no,String return_date,String return_yn) {
    	
    	this.seq = seq;
    	this.loan_date = loan_date;
    	this.exp_return_date = exp_return_date;
    	this.std_no = std_no;
    	this.book_no = book_no;
    	this.return_date = return_date;
        this.return_yn = return_yn;
    }
    
    public LoanVO(String data) {
    	
    	String[] temp = data.split(",");
    	
    	this.seq = Integer.parseInt(temp[0].trim());
    	this.loan_date = temp[1].trim();
    	this.exp_return_date = temp[2].trim();
    	this.std_no = Integer.parseInt(temp[3].trim());
    	this.book_no = Integer.parseInt(temp[4].trim());
    	this.return_date = temp[5].trim();
        this.return_yn = temp[6].trim();
    }

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getLoan_date() {
		return loan_date;
	}

	public void setLoan_date(String loan_date) {
		this.loan_date = loan_date;
	}

	public String getExp_return_date() {
		return exp_return_date;
	}

	public void setExp_return_date(String exp_return_date) {
		this.exp_return_date = exp_return_date;
	}

	public int getStd_no() {
		return std_no;
	}

	public void setStd_no(int std_no) {
		this.std_no = std_no;
	}

	public int getBook_no() {
		return book_no;
	}

	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}

	public String getReturn_yn() {
		return return_yn;
	}

	public void setReturn_yn(String return_yn) {
		this.return_yn = return_yn;
	}
}

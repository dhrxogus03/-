package SecondCode;

public class RsvsVO {
	private int seq;
    private String rsvs_date;
    private int std_no;
    private int book_no;
    private String rsvs_yn;
    
    public RsvsVO() {}
    
    public RsvsVO(int seq,String rsvs_date,int std_no,int book_no,String rsvs_yn) {
    	
    	this.seq = seq;
    	this.rsvs_date = rsvs_date;
    	this.std_no = std_no;
    	this.book_no = book_no;
    	this.rsvs_yn = rsvs_yn;
    }

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getRsvs_date() {
		return rsvs_date;
	}

	public void setRsvs_date(String rsvs_date) {
		this.rsvs_date = rsvs_date;
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

	public String getRsvs_yn() {
		return rsvs_yn;
	}

	public void setRsvs_yn(String rsvs_yn) {
		this.rsvs_yn = rsvs_yn;
	}
}

package poly.dto;

public class NoticeDTO {

	private String seq; 
	private String title; 
	private String content;
	private String read_cnt; // 조회수
	private String reg_dt;
	private String reg_id;
	private String board_stat;
	private int iNum;
	
	public int getiNum() {
		return iNum;
	}
	public void setiNum(int iNum) {
		this.iNum = iNum;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRead_cnt() {
		return read_cnt;
	}
	public void setRead_cnt(String read_cnt) {
		this.read_cnt = read_cnt;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public String getBoard_stat() {
		return board_stat;
	}
	public void setBoard_stat(String board_stat) {
		this.board_stat = board_stat;
	}
	
}
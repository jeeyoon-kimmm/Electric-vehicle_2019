package poly.dto;

public class B_CommentDTO {

	// 커뮤니티 게시판//
	private String com_seq; // 댓글자체를 구분해주는 seq
	private String no_seq; // 댓글이 작성되는 글을 구분해주는 seq
	private String content; // 내용
	private String user_id; // 작성자
	private String reg_dt; // 작성일자



	public String getCom_seq() {
		return com_seq;
	}

	public void setCom_seq(String com_seq) {
		this.com_seq = com_seq;
	}

	public String getNo_seq() {
		return no_seq;
	}

	public void setNo_seq(String no_seq) {
		this.no_seq = no_seq;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}

}

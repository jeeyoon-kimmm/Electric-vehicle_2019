package poly.dto;

public class ev_CarDTO {

	private String car_no; //차량번호
	private String money_no; //보조금 번호
	private String sd; //시도
	private String area; //지역구분
	private String mon_nation; //국가보조금
	private String mon_city; //시비보조금
	private String car_type; //차종
	private String car_company; //자동차 회사명
	private String car_name; //자동차 모델명
	
	public String getCar_no() {
		return car_no;
	}
	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}
	public String getMoney_no() {
		return money_no;
	}
	public void setMoney_no(String money_no) {
		this.money_no = money_no;
	}

	public String getSd() {
		return sd;
	}
	public void setSd(String sd) {
		this.sd = sd;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getMon_nation() {
		return mon_nation;
	}
	public void setMon_nation(String mon_nation) {
		this.mon_nation = mon_nation;
	}
	public String getMon_city() {
		return mon_city;
	}
	public void setMon_city(String mon_city) {
		this.mon_city = mon_city;
	}
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	public String getCar_company() {
		return car_company;
	}
	public void setCar_company(String car_company) {
		this.car_company = car_company;
	}
	public String getCar_name() {
		return car_name;
	}
	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}
	
}

package by.htp3.hotel.bean;

public class Room {
	private int number;
	private String type;
	private int price;
	private Integer userid;
	
	public Room(int number, String type, int price, Integer userid){
		this.number = number;
		this.type = type;
		this.price = price;
		this.setUserid(userid);
	}
	
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	
	

}

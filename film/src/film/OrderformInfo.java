package film;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderformInfo {
	private int number;//编号
	private String ordernumber;//订单号
	private String user;//用户名
	private String FilmTitle;//电影名
	private String cinema;//影院名称
	private int price;//总价格
	private int monovalent;//单价
	private int quantity;//票数
	private String location;//座位
	private Date time;//预订时间
	private String ViewingTime;//观影时间
	private String payment;//是否付款
	public OrderformInfo(int number,String ordernumber, String user, String filmTitle, int quantity,String cinema, int price,int monovalent, String location,
			Date time,String viewingTime,String payment) {
		super();
		this.number = number;
		this.ordernumber= ordernumber;
		this.user = user;
		this.FilmTitle = filmTitle;
		this.quantity = quantity;
		this.cinema = cinema;
		this.price = price;
		this.monovalent=monovalent;
		this.location = location;
		this.time = time;
		this.ViewingTime = viewingTime;
		this.payment=payment;
	}
	public OrderformInfo(String ordernumber,String user,String filmTitle,String cinema,int monovalent,int quantity,int price,String viewingTime,String payment){
		this.ordernumber= ordernumber;
		this.user = user;
		this.FilmTitle = filmTitle;
		this.cinema = cinema;
		this.quantity = quantity;	
		this.monovalent=monovalent;
		this.price = price;
		this.ViewingTime = viewingTime;
		this.payment=payment;
	}
	public OrderformInfo() {
		// TODO Auto-generated constructor stub
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getFilmTitle() {
		return FilmTitle;
	}
	public void setFilmTitle(String filmTitle) {
		this.FilmTitle = filmTitle;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCinema() {
		return cinema;
	}
	public void setCinema(String cinema) {
		this.cinema = cinema;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMonovalent() {
		return monovalent;
	}
	public void setMonovalent(int monovalent) {
		this.monovalent = monovalent;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getViewingTime() {
		return ViewingTime;
	}
	public void setViewingTime(String viewingTime) {
		this.ViewingTime = viewingTime;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	//查询订单信息
	public List<OrderformInfo> inquireOrderform(String user){
		String sql = "SELECT * FROM 订单信息  WHERE user=?";
		Connection conn = ConnectionFactory.createConnection();
		ResultSet rs = null;
		PreparedStatement pst = null;
		List<OrderformInfo> list = new ArrayList<OrderformInfo>();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,user);
			ResultSet rs1= pst.executeQuery();
			while(rs1.next()){
				int number=rs1.getInt("number");
				String ordernumber= rs1.getString("ordernumber");
				String user1= rs1.getString("user");
				String FilmTitle= rs1.getString("FilmTitle");
				int quantity= rs1.getInt("quantity");
				String cinema= rs1.getString("cinema");
				int monovalent= rs1.getInt("monovalent");
				int price= rs1.getInt("price");
				String location= rs1.getString("location");
				Date time= rs1.getDate("time");
				String ViewingTime= rs1.getString("ViewingTime");
				String payment= rs1.getString("payment");
				OrderformInfo cx = new OrderformInfo(number,ordernumber,user1,FilmTitle,quantity,cinema,monovalent,price,location,time,ViewingTime,payment);
				list.add(cx);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn);
			ConnectionFactory.close(pst);
			ConnectionFactory.close(rs);
		}
		return list;
	}
	
/*public static void main(String[] args){
	      OrderformInfo qu = new OrderformInfo();
		List<OrderformInfo> li = qu.inquireOrderform("shi111");
		for(OrderformInfo cx: li){
				 System.out.println(cx.getNumber()+cx.getOrdernumber()+cx.getUser()+cx.getFilmTitle()+cx.getPayment());
				}}*/
	//添加订单信息
			public boolean AddOrderform(OrderformInfo tj){
				Connection conn = ConnectionFactory.createConnection();
				String sql ="INSERT INTO 订单信息(ordernumber,user,FilmTitle,cinema,quantity,monovalent,price,ViewingTime,payment) values(?,?,?,?,?,?,?,?,?)";
				PreparedStatement pst = null;
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1,tj.getOrdernumber());//订单号
					pst.setString(2,tj.getUser());//用户名
					pst.setString(3,tj.getFilmTitle());//电影名
					pst.setString(4,tj.getCinema());//影院名称
					pst.setInt(5,tj.getQuantity());//票数
					pst.setInt(6,getMonovalent());//单价
					pst.setInt(7,tj.getPrice());//总价格
					pst.setString(8,tj.getViewingTime());//观影时间
					pst.setString(9,getPayment());//是否付款
					int n = pst.executeUpdate();
					if(n>0)
						System.out.print("订单信息添加成功 ");
						return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block					
					e.printStackTrace();
				} finally{
					ConnectionFactory.close(conn);
					ConnectionFactory.close(pst);
				}
				return false;
			}
/*public static void main(String[] args){
			 OrderformInfo t=new OrderformInfo("CT2025423523","shi525164","刀剑神域：序列之争","观华国际影城杜比全激光巨幕（长治店）",30,2,60,"safdfas","未付款");
				t.AddOrderform(t);
				  
			}*/
			//通过订单编号修改支付信息
			public boolean updateOrder(String payment,String ordernumber){
				Connection conn = ConnectionFactory.createConnection();
				String sql = "update 订单信息 set payment=?where ordernumber=?";
				PreparedStatement pst = null;
				try {
					pst = conn.prepareStatement(sql);
					 pst.setString(1,payment);
					 pst.setString(2,ordernumber);
					 int n = pst.executeUpdate();
					 if(n>0)
						 System.out.print("修改成功");
						 return true;	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
/*public static void main(String[] args){
				OrderformInfo sc=new OrderformInfo();
				sc.updateOrder("已付款","CT120370416752");
			}*/
			//删除订单
			public void DeleteOrdernumber(String ordernumber){
				Connection conn = ConnectionFactory.createConnection();
				String sql = "delete from 订单信息 where ordernumber= ?";
				PreparedStatement pst = null;
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1,ordernumber);
					int n =pst.executeUpdate();
					if(n != 0)
						System.out.println("删除成功！");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("删除失败！");
				}finally{
					ConnectionFactory.close(conn);
					ConnectionFactory.close(pst);
				}	
			}
/* public static void main(String[] args){
		OrderformInfo sc=new OrderformInfo();
				sc.DeleteOrdernumber("CT143686584111");
			}*/
	}
	
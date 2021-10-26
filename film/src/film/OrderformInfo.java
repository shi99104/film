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
	private int number;//���
	private String ordernumber;//������
	private String user;//�û���
	private String FilmTitle;//��Ӱ��
	private String cinema;//ӰԺ����
	private int price;//�ܼ۸�
	private int monovalent;//����
	private int quantity;//Ʊ��
	private String location;//��λ
	private Date time;//Ԥ��ʱ��
	private String ViewingTime;//��Ӱʱ��
	private String payment;//�Ƿ񸶿�
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
	//��ѯ������Ϣ
	public List<OrderformInfo> inquireOrderform(String user){
		String sql = "SELECT * FROM ������Ϣ  WHERE user=?";
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
	//��Ӷ�����Ϣ
			public boolean AddOrderform(OrderformInfo tj){
				Connection conn = ConnectionFactory.createConnection();
				String sql ="INSERT INTO ������Ϣ(ordernumber,user,FilmTitle,cinema,quantity,monovalent,price,ViewingTime,payment) values(?,?,?,?,?,?,?,?,?)";
				PreparedStatement pst = null;
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1,tj.getOrdernumber());//������
					pst.setString(2,tj.getUser());//�û���
					pst.setString(3,tj.getFilmTitle());//��Ӱ��
					pst.setString(4,tj.getCinema());//ӰԺ����
					pst.setInt(5,tj.getQuantity());//Ʊ��
					pst.setInt(6,getMonovalent());//����
					pst.setInt(7,tj.getPrice());//�ܼ۸�
					pst.setString(8,tj.getViewingTime());//��Ӱʱ��
					pst.setString(9,getPayment());//�Ƿ񸶿�
					int n = pst.executeUpdate();
					if(n>0)
						System.out.print("������Ϣ��ӳɹ� ");
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
			 OrderformInfo t=new OrderformInfo("CT2025423523","shi525164","������������֮��","�ۻ�����Ӱ�Ƕű�ȫ�����Ļ�����ε꣩",30,2,60,"safdfas","δ����");
				t.AddOrderform(t);
				  
			}*/
			//ͨ����������޸�֧����Ϣ
			public boolean updateOrder(String payment,String ordernumber){
				Connection conn = ConnectionFactory.createConnection();
				String sql = "update ������Ϣ set payment=?where ordernumber=?";
				PreparedStatement pst = null;
				try {
					pst = conn.prepareStatement(sql);
					 pst.setString(1,payment);
					 pst.setString(2,ordernumber);
					 int n = pst.executeUpdate();
					 if(n>0)
						 System.out.print("�޸ĳɹ�");
						 return true;	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
/*public static void main(String[] args){
				OrderformInfo sc=new OrderformInfo();
				sc.updateOrder("�Ѹ���","CT120370416752");
			}*/
			//ɾ������
			public void DeleteOrdernumber(String ordernumber){
				Connection conn = ConnectionFactory.createConnection();
				String sql = "delete from ������Ϣ where ordernumber= ?";
				PreparedStatement pst = null;
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1,ordernumber);
					int n =pst.executeUpdate();
					if(n != 0)
						System.out.println("ɾ���ɹ���");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("ɾ��ʧ�ܣ�");
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
	
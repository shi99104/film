package film;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Guserinfo {
	private int number;//编号
	private String user;//管理员
	private String password;//密码
	private Date time;
	public Guserinfo(int number, String user, String password,Date time) {
		super();
		this.number = number;
		this.user = user;
		this.password = password;
		this.time = time;
	}
	public Guserinfo(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}
	public Guserinfo(int number, String password) {
		super();
		this.number = number;
		this.password = password;
	}
	public Guserinfo() {
		// TODO Auto-generated constructor stub
	}
	public Guserinfo(String password, int number) {
		// TODO Auto-generated constructor stub
	}
	public Guserinfo(String string) {
		// TODO Auto-generated constructor stub
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
		//添加管理员
		public boolean AddGUser(Guserinfo tj){
			Connection conn = ConnectionFactory.createConnection();
			String sql ="INSERT INTO 管理员信息(user,password) values(?,?)";
			PreparedStatement pst = null;
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1,tj.getUser());
				pst.setString(2,tj.getPassword());
				int n = pst.executeUpdate();
				if(n>0)
					return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.print("用户添加失败");
				e.printStackTrace();
			} finally{
				ConnectionFactory.close(conn);
				ConnectionFactory.close(pst);
			}
			return false;
		}
	/* public static void main(String[] args){
		 Guserinfo t=new Guserinfo("清瑟","123456");
			t.AddGUser(t);
			  
		}*/
	//登陆
		public boolean checkGPassword(String user,String password){
			Connection conn = ConnectionFactory.createConnection();
			String sql="select * from 管理员信息 where user=? and password=?"; 
			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
				pst =conn.prepareStatement(sql);
				pst.setString(1,user);
				pst.setString(2,password);
				rs =pst.executeQuery();
				while(rs.next()){
					String user1=rs.getString(2);
					String password1=rs.getString(3);
					if(user1!=null&&password1!=null)
						System.out.println("用户名密码正确");
						return true;
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnectionFactory.close(conn);
				ConnectionFactory.close(pst);
				ConnectionFactory.close(rs);
			}
			System.out.println("用户名密码不正确。");
			return false;
		}
/*	public static void main(String[] args)
		{
			Guserinfo i=new Guserinfo();
			i.checkGPassword("冷殇 ", "123456");
		}*/
	//修改管理员信息
		public boolean ReviseGuser(String password,int number){
			Connection conn = ConnectionFactory.createConnection();
			String sql = "UPDATE 管理员信息 SET password=?WHERE number=?";
			PreparedStatement pst = null;
			try {
				pst = conn.prepareStatement(sql);
				 pst.setString(1,password);
				 pst.setInt(2,number);
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
 /*     public static void main(String[] args){
			Guserinfo xg=new Guserinfo();
			xg.ReviseGuser("2226",32);
		}*/
	//删除管理员
	public void DeleteGuser(int number){
		Connection conn = ConnectionFactory.createConnection();
		String sql = "delete from 管理员信息 where number = ?";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1,number);
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
/*	public static void main(String[] args){
		Guserinfo sc=new Guserinfo();
		sc.DeleteGuser(7);
	}*/
	//查询管理员信息
	public List<Guserinfo> InquireUserinfo(String user){
		List<Guserinfo> list = new ArrayList<Guserinfo>();
		String sql = "select * from 管理员信息 where user like ?";
		Connection conn = ConnectionFactory.createConnection();
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, "%"+user+"%");
			rs =pst.executeQuery();
			while(rs.next()){
				int number= rs.getInt("number");
				String user1= rs.getString("user");
				String password = rs.getString("password");	
				Date time= rs.getDate("time");	
				Guserinfo n = new Guserinfo(number,user1,password,time);
				list.add(n);
			}		
		}catch (SQLException e) {
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
	Guserinfo qu = new Guserinfo();
	List<Guserinfo> li = qu.InquireUserinfo("冷");
	for(Guserinfo n: li){
	 System.out.println(+n.getNumber()+n.getUser()+n.getPassword()+n.getTime());
	}}*/
}

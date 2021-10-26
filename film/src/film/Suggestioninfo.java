package film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Suggestioninfo {
	private int number;//编号
	private String user;//用户名
	private String suggestion;//投诉建议
	private Date time;//时间
	public Suggestioninfo(int number, String user, String suggestion, Date time) {
		super();
		this.number = number;
		this.user = user;
		this.suggestion =suggestion;
		this.time = time;
	}
	public Suggestioninfo(String user, String suggestion) {
		super();
		this.user = user;
		this.suggestion =suggestion;
	}
	public Suggestioninfo() {
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
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	//投诉建议添加
		public boolean AddSuggestioninfo(Suggestioninfo tj){
			Connection conn = ConnectionFactory.createConnection();
			String sql ="INSERT INTO 投诉建议信息(user,suggestion) values(?,?)";
			PreparedStatement pst = null;
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1,tj.getUser());
				pst.setString(2,tj.getSuggestion());
				int n = pst.executeUpdate();
				if(n>0)
					System.out.print("投诉建议添加成功 ");
					return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			} finally{
				ConnectionFactory.close(conn);
				ConnectionFactory.close(pst);
			}
			System.out.print("投诉建议添加失败 ");
			return false;
		}
/*public static void main(String[] args){
		Suggestioninfo t=new Suggestioninfo("shi111","功能太过简陋，希望该系统可以更加方便用户使用");
			t.AddSuggestioninfo(t);
			  
	}*/
		//删除用户投诉建议删除
				public void DeleteSuggestion(int number){
					Connection conn = ConnectionFactory.createConnection();
					String sql = "delete from 投诉建议信息 where number = ?";
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
	public static void main(String[] args){
					Suggestioninfo sc=new Suggestioninfo();
					sc.DeleteSuggestion(4);
				}
}

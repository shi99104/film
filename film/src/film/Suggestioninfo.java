package film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Suggestioninfo {
	private int number;//���
	private String user;//�û���
	private String suggestion;//Ͷ�߽���
	private Date time;//ʱ��
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
	//Ͷ�߽������
		public boolean AddSuggestioninfo(Suggestioninfo tj){
			Connection conn = ConnectionFactory.createConnection();
			String sql ="INSERT INTO Ͷ�߽�����Ϣ(user,suggestion) values(?,?)";
			PreparedStatement pst = null;
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1,tj.getUser());
				pst.setString(2,tj.getSuggestion());
				int n = pst.executeUpdate();
				if(n>0)
					System.out.print("Ͷ�߽�����ӳɹ� ");
					return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			} finally{
				ConnectionFactory.close(conn);
				ConnectionFactory.close(pst);
			}
			System.out.print("Ͷ�߽������ʧ�� ");
			return false;
		}
/*public static void main(String[] args){
		Suggestioninfo t=new Suggestioninfo("shi111","����̫����ª��ϣ����ϵͳ���Ը��ӷ����û�ʹ��");
			t.AddSuggestioninfo(t);
			  
	}*/
		//ɾ���û�Ͷ�߽���ɾ��
				public void DeleteSuggestion(int number){
					Connection conn = ConnectionFactory.createConnection();
					String sql = "delete from Ͷ�߽�����Ϣ where number = ?";
					PreparedStatement pst = null;
					try {
						pst = conn.prepareStatement(sql);
						pst.setInt(1,number);
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
	public static void main(String[] args){
					Suggestioninfo sc=new Suggestioninfo();
					sc.DeleteSuggestion(4);
				}
}

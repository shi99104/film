package film;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class History {
	private int number;//���
	private String user;//�û�
	private String FilmTitle;//��Ӱ��
	private Date time;//���ʱ��
	public History(int number, String user, String filmTitle, Date time) {
		super();
		this.number = number;
		this.user = user;
		FilmTitle = filmTitle;
		this.time = time;
	}
	public History(String user, String filmTitle) {
		super();
		this.user = user;
		FilmTitle = filmTitle;
	}
	public History() {
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
	public String getFilmTitle() {
		return FilmTitle;
	}
	public void setFilmTitle(String filmTitle) {
		FilmTitle = filmTitle;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	//�����ʷ��Ϣ����
	public boolean AddHistory(History tj){
		Connection conn = ConnectionFactory.createConnection();
		String sql ="INSERT INTO ��ʷ��Ϣ(user,FilmTitle) values(?,?)";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,tj.getUser());
			pst.setString(2,tj.getFilmTitle());
			int n = pst.executeUpdate();
			if(n>0)	
			System.out.print("�����ʷ��ӳɹ� ");
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
	History t=new History("shi111","����֮ҹ������֮��3����֮��");
		t.AddHistory(t);
		  
	}*/
//�û�ɾ����ʷ��Ϣ
public void DeleteHistory(int number){
	Connection conn = ConnectionFactory.createConnection();
	String sql = "delete from ��ʷ��Ϣ where number = ?";
	PreparedStatement pst = null;
	try {
		pst = conn.prepareStatement(sql);
		pst.setInt(1,number);
		int n =pst.executeUpdate();
		if(n != 0)
			System.out.println("��ʷɾ���ɹ���");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("ɾ��ʧ�ܣ�");
	}finally{
		ConnectionFactory.close(conn);
		ConnectionFactory.close(pst);
	}	
}
public static void main(String[] args){
	History sc=new History();
	sc.DeleteHistory(3);
}
}

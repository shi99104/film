package film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Collectinfo {
	private  int number;
	private String user;//�û�
	private String FilmTitle;//��ע��Ӱ
	public Collectinfo(int number, String user, String filmTitle) {
		super();
		this.number = number;
		this.user = user;
		this.FilmTitle = filmTitle;
	}
	public Collectinfo(String user, String filmTitle) {
		super();
		this.user = user;
		this.FilmTitle = filmTitle;
	}
	public Collectinfo() {
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
	//��ӹ�ע��Ϣ
	public boolean AddCollect(Collectinfo tj){
		Connection conn = ConnectionFactory.createConnection();
		String sql ="INSERT INTO ��ע��Ϣ(user,FilmTitle) values(?,?)";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,tj.getUser());
			pst.setString(2,tj.getFilmTitle());
			int n = pst.executeUpdate();
			if(n>0)
				System.out.print("��ע��ӳɹ�");
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} finally{
			ConnectionFactory.close(conn);
			ConnectionFactory.close(pst);
		}
		System.out.print("��ע���ʧ��");
		return false;
	}
/* public static void main(String[] args){
	 Collectinfo  t=new Collectinfo ("shi2356","������������֮��");
		t.AddCollect(t);
		  
	}*/
	//ɾ����ע��Ϣ
	public void DeleteCollectionfo(String user,String FilmTitle){
		Connection conn = ConnectionFactory.createConnection();
		String sql = "delete from ��ע��Ϣ where user=? and FilmTitle=?";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,user);
			pst.setString(2,FilmTitle);
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
	/*public static void main(String[] args){
		 Collectinfo sc=new Collectinfo();
		sc.DeleteCollectionfo("shi2356", "�������");
	}*/
	//��ѯ�Ƿ��ע
	public boolean collect(String user,String FilmTitle){
		Connection conn = ConnectionFactory.createConnection();
		String sql="select * from ��ע��Ϣ where user=? and FilmTitle=?"; 
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst =conn.prepareStatement(sql);
			pst.setString(1,user);
			pst.setString(2,FilmTitle);
			rs =pst.executeQuery();
			while(rs.next()){
				String user1=rs.getString(2);
				String FilmTitle1=rs.getString(3);
				if(user1!=null&&FilmTitle1!=null)
					System.out.println("�ѹ�ע");
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
		System.out.println("δ��ע");
		return false;
	}
/*	public static void main(String[] args)
	{
		 Collectinfo i=new  Collectinfo();
		i.collect("", "������������֮��");
	}*/
	//ɾ���û���ע
	public void DeleteCollect(int number){
		Connection conn = ConnectionFactory.createConnection();
		String sql = "delete from ��ע��Ϣ where number = ?";
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
		Collectinfo sc=new Collectinfo();
		sc.DeleteCollect(16);
	}
}

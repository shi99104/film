package film;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Discussinfo {
	private int number;//���
	private String discuss;//����
	private String nickname;//�û���
	private String FilmTitle;//��Ӱ��
	private  Date time;//ʱ��
	public Discussinfo(int number, String discuss, String nickname, String filmTitle, Date time) {
		super();
		this.number = number;
		this.discuss = discuss;
		this.nickname = nickname;
		this.FilmTitle = filmTitle;
		this.time = time;
	}
	public Discussinfo(String discuss, String nickname, Date time) {
		super();
		this.discuss = discuss;
		this.nickname = nickname;
		this.time = time;
	}
	public Discussinfo(String discuss, String nickname, String filmTitle) {
		super();
		this.discuss = discuss;
		this.nickname=nickname;
		this.FilmTitle = filmTitle;
	}
	public Discussinfo() {
		// TODO Auto-generated constructor stub
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDiscuss() {
		return discuss;
	}
	public void setDisuss(String discuss) {
		this.discuss = discuss;
	}
	public String getNickname() {
		return nickname;
	}
	public void setUser(String nickname) {
		this.nickname = nickname;
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
	//ͨ����Ӱ����ѯ�û�����
	public List<Discussinfo> Querydisuss(String FilmTitle){
		String sql = "select * from ������Ϣ where FilmTitle=?";
		Connection conn = ConnectionFactory.createConnection();
		ResultSet rs = null;
		PreparedStatement pst = null;
		List<Discussinfo> list = new ArrayList<Discussinfo>();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,FilmTitle);
			ResultSet rSet = pst.executeQuery();
			while(rSet.next()){
				String discuss= rSet.getString("discuss");
				String nickname= rSet.getString("nickname");
				Date time= rSet.getDate("time");
				Discussinfo ft = new Discussinfo(discuss,nickname,time);
				list.add(ft);
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
		Discussinfo qu = new Discussinfo();
		List<Discussinfo> li = qu.Querydisuss("����֮ҹ������֮��3����֮��");
		for(Discussinfo cx: li)
			System.out.print(cx.getNickname()+cx.getDiscuss()+cx.getTime());
	}*/
	//��Ӱ�������
	public boolean AddDiscussinfo(Discussinfo tj){
		Connection conn = ConnectionFactory.createConnection();
		String sql ="INSERT INTO ������Ϣ(discuss,nickname,filmTitle) values(?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,tj.getDiscuss());
			pst.setString(2,tj.getNickname());
			pst.setString(3,tj.getFilmTitle());
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
		System.out.print("������Ϣ���ʧ�� ");
		return false;
	}
/*public static void main(String[] args){
	Discussinfo t=new Discussinfo("�������Ч","�䳾","����֮ҹ������֮��3����֮��");
		t.AddDiscussinfo(t);
		  
}*/
	//Ӱ���޸�
	public boolean updateDisuss(String discuss,int number){
		Connection conn = ConnectionFactory.createConnection();
		String sql = "update ������Ϣ set discuss=?where number=?";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			 pst.setString(1,discuss);
			 pst.setInt(2,number);
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
/*	public static void main(String[] args){
		Discussinfo sc=new Discussinfo();
		sc.updateDisuss("�����Ķ���һ���羰����һ�����ϵ�ʫ����һ�����Եĸ衣��Ǿ��ʣ���Ե�֣��������п̹����ĵ��黳����һĨ�磬��һ���ꡣ��ܹ���Ȼ",7);
	}*/
	//ͨ�����ɾ��������Ϣ
	public void DeleteDiscuss(int number){
		Connection conn = ConnectionFactory.createConnection();
		String sql = "delete from ������Ϣ where number = ?";
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
/*	public static void main(String[] args){
		Discussinfo sc=new Discussinfo();
		sc.DeleteDiscuss(19);
	}*/
}

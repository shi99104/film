package film;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Userinfo {
	private int number;//���
	private String nickname;//�ǳ�
	private String user;//�û���
	private  String cipher;//����
	public String mob;//�ֻ���
	private Date time;//ע��ʱ��
	public Userinfo(int number,String nickname, String user, String cipher, String mob,Date time) {
		super();
		this.number = number;
		this.nickname=nickname;
		this.user = user;
		this.cipher = cipher;
		this.mob = mob;
		this.time=time;
	}
	public Userinfo(String nickname, String user, String cipher, String mob,Date time) {
		super();
		this.nickname=nickname;
		this.user = user;
		this.cipher = cipher;
		this.mob = mob;
		this.time=time;
	}
	public Userinfo(String nickname, String user, String mob) {
		super();
		this.nickname=nickname;
		this.user = user;
		this.mob = mob;
	}
	public Userinfo(String nickname, String user, String cipher, String mob) {
		super();
		this.nickname=nickname;
		this.user = user;
		this.cipher = cipher;
		this.mob = mob;
	}
	public Userinfo(String user, String cipher) {
		super();
		this.user = user;
		this.cipher = cipher;
	}
	public Userinfo(String nickname) {
		super();
		this.nickname=nickname;
	}
	public Userinfo() {
		// TODO Auto-generated constructor stub
	}
	public Userinfo(int number, int nickname, String user, String cipher, String mob, Date time) {
		// TODO Auto-generated constructor stub
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getCipher() {
		return cipher;
	}
	public void setCipher(String cipher) {
		this.cipher = cipher;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public Date getTime() {
		return time;
	}
	//����û�
	public boolean AddUser(Userinfo tj){
		Connection conn = ConnectionFactory.createConnection();
		String sql ="INSERT INTO �û���Ϣ(nickname,user,cipher,mob) values(?,?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,tj.getNickname());
			pst.setString(2,tj.getUser());
			pst.setString(3,tj.getCipher());
			pst.setString(4,tj.getMob());
			int n = pst.executeUpdate();
			if(n>0)
				return true;
			System.out.print("�û����ʧ�� ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("�û���ӳɹ� ");
			e.printStackTrace();
		} finally{
			ConnectionFactory.close(conn);
			ConnectionFactory.close(pst);
		}
		return false;
	}
 /* public static void main(String[] args){
		Userinfo t=new Userinfo("��ɪ","servlet","123456","18636169820");
		t.AddUser(t);
		  
	}*/
//��½
	public boolean checkPassword(String user,String cipher)
	{
			Connection conn = ConnectionFactory.createConnection();
			String sql = "select * from �û���Ϣ where user=? and cipher = ?";
			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, user);
				pst.setString(2,cipher);
				rs = pst.executeQuery();
				while(rs.next()){
					String user1=rs.getString(3);
					String coid=rs.getString(4);
					if(user1!=null&&coid!=null)
						System.out.println("�û���������ȷ");
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
			System.out.println("�û������벻��ȷ��");
			return false;
		}
/*public static void main(String[] args)
	{
	Userinfo i=new Userinfo();
		i.checkPassword("sdfj", "mm");
	}*/
	//�޸����뼰�鿴�û����Ƿ��ظ�
public boolean ChangeCipher(String user){
		Connection conn = ConnectionFactory.createConnection();
		String sql = "select * from �û���Ϣ where user=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user);
			rs = pst.executeQuery();
			while(rs.next()){
				String user1=rs.getString(3);
				String coid=rs.getString(4);
				if(user1!=null&&coid!=null)
					System.out.println("�û�����ȷ");
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
		System.out.println("�û�������ȷ��");
		return false;
	}
/*public static void main(String[] args)
{
Userinfo i=new Userinfo();
	i.ChangeCipher("shi111");
}*/
//�޸�������֤�ֻ����û����Ƿ���ȷ
public boolean checkmob(String user,String mob)
{
		Connection conn = ConnectionFactory.createConnection();
		String sql = "select * from �û���Ϣ where user=? and mob= ?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user);
			pst.setString(2,mob);
			rs = pst.executeQuery();
			while(rs.next()){
				String user1=rs.getString(3);
				String mob1=rs.getString(5);
				if(user1!=null&&mob1!=null)
					System.out.println("�û����ֻ�����ȷ");
					return true;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�û����ֻ��Ų���ȷ��");
		}finally{
			ConnectionFactory.close(conn);
			ConnectionFactory.close(pst);
			ConnectionFactory.close(rs);
		}
		return false;
	}
/*public static void main(String[] args)
{
Userinfo i=new Userinfo();
	i.checkmob("sdfj", "161564");
}*/
//�޸��û�����
	public boolean updateCipher(String cipher,String user){
		Connection conn = ConnectionFactory.createConnection();
		String sql = "update �û���Ϣ set cipher=?where user=?";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			 pst.setString(1,cipher);
			 pst.setString(2,user);
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
		Userinfo sc=new Userinfo();
		sc.updateCipher("111111","shi111");
	}*/
//ɾ���û�
public void DeleteComtent(int number){
	Connection conn = ConnectionFactory.createConnection();
	String sql = "delete from �û���Ϣ where number = ?";
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
/*public static void main(String[] args){
	Userinfo sc=new Userinfo();
	sc.DeleteComtent(19);
}*/
//ͨ���û�����ѯ�ǳ�
public List<Userinfo> QueryNickname(String user){
	String sql = "select * from �û���Ϣ where user=?";
	Connection conn = ConnectionFactory.createConnection();
	ResultSet rs = null;
	PreparedStatement pst = null;
	List<Userinfo> list = new ArrayList<Userinfo>();
	try {
		pst = conn.prepareStatement(sql);
		pst.setString(1,user);
		ResultSet rSet = pst.executeQuery();
		while(rSet.next()){
			String nickname= rSet.getString("nickname");
			String mob= rSet.getString("mob");
			Userinfo ft = new Userinfo(number,nickname,user,cipher,mob,time);
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
	Userinfo qu = new Userinfo();
	List<Userinfo> li = qu.QueryNickname("shi111");
	for(Userinfo cx: li)
		System.out.print(cx.nickname);
}*/
//ͨ���û�������������Ϣ
public List<Userinfo> QueryUser(String user){
	String sql = "select * from �û���Ϣ where user=?";
	Connection conn = ConnectionFactory.createConnection();
	ResultSet rs = null;
	PreparedStatement pst = null;
	List<Userinfo> list = new ArrayList<Userinfo>();
	try {
		pst = conn.prepareStatement(sql);
		pst.setString(1,user);
		ResultSet rSet = pst.executeQuery();
		while(rSet.next()){
			String nickname= rSet.getString("nickname");
			String mob= rSet.getString("mob");
			Userinfo ft = new Userinfo(nickname,user,mob);
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
public static void main(String[] args){
	Userinfo qu = new Userinfo();
	List<Userinfo> li = qu.QueryUser("servlet123");
	for(Userinfo n: li)
		System.out.print(n.nickname);
}
//ͨ���û����޸��ǳƺ��ֻ���
public boolean updateInformation(String nickname,String mob,String user){
	Connection conn = ConnectionFactory.createConnection();
	String sql = "update �û���Ϣ set nickname=?,mob=?where user=?";
	PreparedStatement pst = null;
	try {
		pst = conn.prepareStatement(sql);
		 pst.setString(1,nickname);
		 pst.setString(2,mob);
		 pst.setString(3,user);
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
	Userinfo gx=new Userinfo();
	gx.updateInformation("����","15234256852","shi123");
	}*/
//ģ����ѯ�û���Ϣ
	public List<Userinfo> InquireUser(String user){
		String sql = "SELECT * FROM �û���Ϣ  WHERE user LIKE ?";
		Connection conn = ConnectionFactory.createConnection();
		PreparedStatement pst = null;
		List<Userinfo> list = new ArrayList<Userinfo>();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, "%"+user+"%");
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				int number=rs.getInt("number");
				String nickname=rs.getString("nickname");
				String user1= rs.getString("user");
				String cipher = rs.getString("cipher");
				String mob = rs.getString("mob");
				Date  time=rs.getDate("time");
				Userinfo ft = new Userinfo(number,nickname,user1,cipher,mob,time);
				list.add(ft);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn);
			ConnectionFactory.close(pst);

		}
		return list;
	}
/*public static void main(String[] args){
	      Userinfo qu = new Userinfo();
		List<Userinfo> li = qu.InquireUser("shi");
		for(Userinfo cx: li){
				 System.out.println(+cx.getNumber()+cx.getNickname()+cx.getUser()+cx.getCipher()+cx.getTime());
				}}*/
	//ͨ������޸��û�������Ϣ
	public boolean Reviseuser(String nickname,String cipher,String mob,int number){
		Connection conn = ConnectionFactory.createConnection();
		String sql = "UPDATE �û���Ϣ SET nickname=?,cipher=?,mob=?WHERE number=?";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			 pst.setString(1,nickname);
			 pst.setString(2,cipher);
			 pst.setString(3,mob);
			 pst.setInt(4,number);
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
/*  public static void main(String[] args){
		Userinfo xg=new Userinfo();
		xg.Reviseuser("����","123456789","10248747911",17);
	}*/
	}
	

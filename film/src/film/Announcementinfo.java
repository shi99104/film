package film;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Announcementinfo {
	private int number;//���
	private String user;//�û���
	private String announcement;//������Ϣ
	private Date time;	//����ʱ��
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setUser(String user) {
		this.user = user;
	}
	public String getUser() {
		return user;
	}
	public String getAnnouncement() {
		return announcement;
	}
	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Announcementinfo(int number,String user, String announcement, Date time) {
		super();
		this.number = number;
		this.user = user;
		this.announcement = announcement;
		this.time = time;
	}
	public Announcementinfo(String user, String announcement, Date time) {
		super();
		this.user = user;
		this.announcement = announcement;
		this.time = time;
	}
	public Announcementinfo(String user, String announcement) {
		super();
		this.user = user;
		this.announcement = announcement;
	}
		public Announcementinfo() {
		// TODO Auto-generated constructor stub
	}

		//��ӹ���
		public boolean AddAnnouncement(Announcementinfo tj){
			Connection conn = ConnectionFactory.createConnection();
			String sql ="INSERT INTO ������Ϣ(user,announcement) values(?,?)";
			PreparedStatement pst = null;
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1,tj.getUser());
				pst.setString(2,tj.getAnnouncement());
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
			System.out.print("������Ϣ���ʧ��");
			return false;
		}
	/*public static void main(String[] args){
		Announcementinfo t=new Announcementinfo("�䳾","��ҵ����");
			t.AddAnnouncement(t);
			  
		}*/
        //ɾ��������Ϣ		
		public void DeleteAnnouncement(int number){
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
/*public static void main(String[] args){
			Announcementinfo sc=new Announcementinfo();
			sc.DeleteAnnouncement(5);
		}*/
}

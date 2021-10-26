package film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import film.ConnectionFactory;
public class Filminfo {
	private int number;//���
	private String FilmTitle;//��Ӱ��
	private String bill;//����
	private String intrommend;//��Ӱ����
	private String director;//����
	private String actor;//����
	private String region;//��������
	private String laguae;//����
	private String type;//��Ӱ����
	private String releasedate;//��ӳʱ��
	private int movietime;//ʱ��
	private int price;//�۸�
	public Filminfo(int number,String FilmTitle,String bill,String intrommend, String director,
			String actor, String region, String laguae, String type,
			String releasedate,int movietime,int price) {
		super();
		this.number=number;
		this.FilmTitle = FilmTitle;
		this.bill=bill;
		this.intrommend = intrommend;
		this.director = director;
		this.actor = actor;
		this.region = region;
		this.laguae = laguae;
		this.type = type;
		this.releasedate = releasedate;
		this.movietime=movietime;
		this.price=price;
	}
	public Filminfo(String FilmTitle,String bill,String intrommend, String director,
			String actor, String region, String laguae, String type,
			String releasedate,int movietime,int price) {
		super();
		this.FilmTitle = FilmTitle;
		this.bill=bill;
		this.intrommend = intrommend;
		this.director = director;
		this.actor = actor;
		this.region = region;
		this.laguae = laguae;
		this.type = type;
		this.releasedate = releasedate;
		this.movietime=movietime;
		this.price=price;

	}
	public Filminfo() {
		// TODO Auto-generated constructor stub
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getFilmTitle() {
		return FilmTitle;
	}
	public void setFilmTitle(String FilmTitle) {
		this.FilmTitle = FilmTitle;
	}
	public String getBill() {
		return bill;
	}
	public void setBill(String bill) {
		this.bill = bill;
	}
	public String getIntrommend() {
		return intrommend;
	}
	public void setIntrommend(String intrommend) {
		this.intrommend = intrommend;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getLaguae() {
		return laguae;
	}
	public void setLaguae(String laguae) {
		this.laguae = laguae;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}
	public int getMovietime(){
		return movietime;
	}
	public void setMovietime(int movietime){
		this.movietime=movietime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	//��ӵ�Ӱ��Ϣ
		public boolean AddFilminfo(Filminfo tj){
			Connection conn = ConnectionFactory.createConnection();
			String sql ="INSERT INTO ��Ӱ��Ϣ(FilmTitle,bill,intrommend, director, actor,region,laguae,type,releasedate,movietime,price) values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = null;
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1,tj.getFilmTitle());
				pst.setString(2,tj.getBill());
				pst.setString(3,tj.getIntrommend());
				pst.setString(4,tj.getDirector());
				pst.setString(5,tj.getActor());
				pst.setString(6,tj.getRegion());
				pst.setString(7,tj.getLaguae());
				pst.setString(8,tj.getType());
				pst.setString(9,tj.getReleasedate());
				pst.setInt(10, getMovietime());
				pst.setInt(11,tj.getPrice());
				
				int n = pst.executeUpdate();
				if(n>0)
					return true;
				System.out.print("��Ӱ��Ϣ���ʧ�� ");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.print("��Ӱ��Ϣ��ӳɹ� ");
				e.printStackTrace();
			} finally{
				ConnectionFactory.close(conn);
				ConnectionFactory.close(pst);
			}
			return false;
		}
 /*public static void main(String[] args){
		  Filminfo t=new Filminfo("������","images/6b8718c62f648baf7b4661712c4c7dbd.png","ս���и��˶�����̱����ǰ����սʿ�ܿˡ�����","ղķ˹����÷¡",
					"��ķ�������١��������������ȡ���Ъ�����޵�����ȡ������ݡ�Τ����","������Ӣ�� ","Ӣ��","���� �ƻ� ð��","2021-03-12",162,30);
			t.AddFilminfo(t);
			  
		}*/
		//ɾ����Ӱ
		public void DeleteFilm(int number){
			Connection conn = ConnectionFactory.createConnection();
			String sql = "delete from ��Ӱ��Ϣ where number = ?";
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
/*		public static void main(String[] args){
			Filminfo sc=new Filminfo();
			sc.DeleteFilm(23);
		}*/
		//ͨ����Ӱ���ֲ�ѯ��Ӱ������Ϣ
		public List<Filminfo> Queryfilminfo(String FilmTitle){
			String sql = "select * from ��Ӱ��Ϣ where FilmTitle=?";
			Connection conn = ConnectionFactory.createConnection();
			ResultSet rs = null;
			PreparedStatement pst = null;
			List<Filminfo> list = new ArrayList<Filminfo>();
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1,FilmTitle);
				ResultSet rSet = pst.executeQuery();
				while(rSet.next()){
					String FilmTitle1= rSet.getString("FilmTitle");
					String bill= rSet.getString("bill");
					String intrommend= rSet.getString("intrommend");
					String director= rSet.getString("director");
					String actor= rSet.getString("actor");
					String region= rSet.getString("region");
					String laguae= rSet.getString("laguae");
					String type= rSet.getString("type");
					String releasedate= rSet.getString("releasedate");
					int movietime= rSet.getInt("movietime");
					int price= rSet.getInt("price");
					Filminfo ft = new Filminfo(FilmTitle1,bill,intrommend, director, actor,region,laguae,type,releasedate,movietime,price);
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
	/*	public static void main(String[] args){
			Filminfo qu = new Filminfo();
			List<Filminfo> li = qu.Queryfilminfo("������");
			for(Filminfo cx: li)
				System.out.print(cx.price);
		}*/
		//ģ����ѯ��Ӱ��Ϣ
		public List<Filminfo>Inquirefilm(String FilmTitle){
			String sql = "SELECT * FROM ��Ӱ��Ϣ  WHERE FilmTitle LIKE ?";
			Connection conn = ConnectionFactory.createConnection();
			PreparedStatement pst = null;
			List<Filminfo> list = new ArrayList<Filminfo>();
			try {
				pst = conn.prepareStatement(sql);
				pst.setString(1, "%"+FilmTitle+"%");
				ResultSet rs = pst.executeQuery();
				while(rs.next()){
					int number=rs.getInt("number");
					String FilmTitle1= rs.getString("FilmTitle");
					String bill= rs.getString("bill");
					String intrommend= rs.getString("intrommend");
					String director= rs.getString("director");
					String actor= rs.getString("actor");
					String region= rs.getString("region");
					String laguae= rs.getString("laguae");
					String type= rs.getString("type");
					String releasedate= rs.getString("releasedate");
					int movietime= rs.getInt("movietime");
					int price= rs.getInt("price");
					Filminfo cx = new Filminfo(number,FilmTitle1,bill,intrommend, director, actor,region,laguae,type,releasedate,movietime,price);
					list.add(cx);
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
		      Filminfo qu = new Filminfo();
			List<Filminfo> li = qu.Inquirefilm("����");
			for(Filminfo cx: li){
					 System.out.println(cx.getNumber()+cx.getFilmTitle()+cx.getIntrommend()+cx.getDirector()+cx.getActor()+cx.getPrice());
					}}*/
	//�޸ĵ�Ӱ��Ϣ
	public boolean ReviseFilm(String FilmTitle,String bill,String intrommend, String director,String actor, String region, String laguae, String type,
				String releasedate,int movietime,int price,int number){
			Connection conn = ConnectionFactory.createConnection();
			String sql = "UPDATE ��Ӱ��Ϣ SET FilmTitle=?,bill=?,intrommend=?,director=?,actor=?,region=?,laguae=?,type=?,releasedate=?,movietime=?,price=? WHERE number=?";
			PreparedStatement pst = null;
			try {
				pst = conn.prepareStatement(sql);
				 pst.setString(1,FilmTitle);
				 pst.setString(2,bill);
				 pst.setString(3,intrommend);
				 pst.setString(4,director);
				 pst.setString(5,actor);
				 pst.setString(6,region);
				 pst.setString(7,laguae);
				 pst.setString(8,type);
				 pst.setString(9,releasedate);
				 pst.setInt(10,movietime);
				 pst.setInt(11,price);
				 pst.setInt(12,number);
				 int n = pst.executeUpdate();
				 if(n>0)
					 System.out.print("�޸ĳɹ�");
					 return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("�޸�ʧ��");
			return false;
		}
/*public static void main(String[] args){
			Filminfo xg=new Filminfo();
			xg.ReviseFilm("�ж�","images/p2645147641.jpg","���а����Ӱ���ж���77�Ρ�Ϊ��ԭ����77�Ρ�������","������ ������"," ��׿���� �ܰغ� ������¡�ë��� ����Ӣ�� ��֣ϣ��","�й���� ���й���½","����","ϲ�� ������","2021-05-14(�й���½)",93,20,33);
		}*/
}


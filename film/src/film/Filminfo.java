package film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import film.ConnectionFactory;
public class Filminfo {
	private int number;//编号
	private String FilmTitle;//电影名
	private String bill;//海报
	private String intrommend;//电影介绍
	private String director;//导演
	private String actor;//主演
	private String region;//制作地区
	private String laguae;//语言
	private String type;//电影类型
	private String releasedate;//上映时间
	private int movietime;//时长
	private int price;//价格
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
	//添加电影信息
		public boolean AddFilminfo(Filminfo tj){
			Connection conn = ConnectionFactory.createConnection();
			String sql ="INSERT INTO 电影信息(FilmTitle,bill,intrommend, director, actor,region,laguae,type,releasedate,movietime,price) values(?,?,?,?,?,?,?,?,?,?,?)";
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
				System.out.print("电影信息添加失败 ");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.print("电影信息添加成功 ");
				e.printStackTrace();
			} finally{
				ConnectionFactory.close(conn);
				ConnectionFactory.close(pst);
			}
			return false;
		}
 /*public static void main(String[] args){
		  Filminfo t=new Filminfo("阿凡达","images/6b8718c62f648baf7b4661712c4c7dbd.png","战斗中负伤而下身瘫痪的前海军战士杰克·萨利","詹姆斯·卡梅隆",
					"萨姆·沃辛顿、佐伊·索尔达娜、米歇尔·罗德里格兹、西格妮·韦弗等","美国、英国 ","英语","动作 科幻 冒险","2021-03-12",162,30);
			t.AddFilminfo(t);
			  
		}*/
		//删除电影
		public void DeleteFilm(int number){
			Connection conn = ConnectionFactory.createConnection();
			String sql = "delete from 电影信息 where number = ?";
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
/*		public static void main(String[] args){
			Filminfo sc=new Filminfo();
			sc.DeleteFilm(23);
		}*/
		//通过电影名字查询电影其他信息
		public List<Filminfo> Queryfilminfo(String FilmTitle){
			String sql = "select * from 电影信息 where FilmTitle=?";
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
			List<Filminfo> li = qu.Queryfilminfo("阿凡达");
			for(Filminfo cx: li)
				System.out.print(cx.price);
		}*/
		//模糊查询电影信息
		public List<Filminfo>Inquirefilm(String FilmTitle){
			String sql = "SELECT * FROM 电影信息  WHERE FilmTitle LIKE ?";
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
			List<Filminfo> li = qu.Inquirefilm("天气");
			for(Filminfo cx: li){
					 System.out.println(cx.getNumber()+cx.getFilmTitle()+cx.getIntrommend()+cx.getDirector()+cx.getActor()+cx.getPrice());
					}}*/
	//修改电影信息
	public boolean ReviseFilm(String FilmTitle,String bill,String intrommend, String director,String actor, String region, String laguae, String type,
				String releasedate,int movietime,int price,int number){
			Connection conn = ConnectionFactory.createConnection();
			String sql = "UPDATE 电影信息 SET FilmTitle=?,bill=?,intrommend=?,director=?,actor=?,region=?,laguae=?,type=?,releasedate=?,movietime=?,price=? WHERE number=?";
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
					 System.out.print("修改成功");
					 return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print("修改失败");
			return false;
		}
/*public static void main(String[] args){
			Filminfo xg=new Filminfo();
			xg.ReviseFilm("感动","images/p2645147641.jpg","都市爱情电影《感动她77次》为《原谅他77次》续集。","邱礼涛 、李敏"," 蔡卓妍、 周柏豪 、马里奥·毛瑞尔 、惠英红 、郑希怡","中国香港 、中国大陆","粤语","喜剧 、爱情","2021-05-14(中国大陆)",93,20,33);
		}*/
}


package film;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Discussinfo {
	private int number;//编号
	private String discuss;//评论
	private String nickname;//用户名
	private String FilmTitle;//电影名
	private  Date time;//时间
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
	//通过电影名查询用户评论
	public List<Discussinfo> Querydisuss(String FilmTitle){
		String sql = "select * from 评论信息 where FilmTitle=?";
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
		List<Discussinfo> li = qu.Querydisuss("命运之夜——天之杯3：春之歌");
		for(Discussinfo cx: li)
			System.out.print(cx.getNickname()+cx.getDiscuss()+cx.getTime());
	}*/
	//电影评论添加
	public boolean AddDiscussinfo(Discussinfo tj){
		Connection conn = ConnectionFactory.createConnection();
		String sql ="INSERT INTO 评论信息(discuss,nickname,filmTitle) values(?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,tj.getDiscuss());
			pst.setString(2,tj.getNickname());
			pst.setString(3,tj.getFilmTitle());
			int n = pst.executeUpdate();
			if(n>0)
				System.out.print("评论信息添加成功 ");
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} finally{
			ConnectionFactory.close(conn);
			ConnectionFactory.close(pst);
		}
		System.out.print("评论信息添加失败 ");
		return false;
	}
/*public static void main(String[] args){
	Discussinfo t=new Discussinfo("大场面大特效","卿尘","命运之夜——天之杯3：春之歌");
		t.AddDiscussinfo(t);
		  
}*/
	//影评修改
	public boolean updateDisuss(String discuss,int number){
		Connection conn = ConnectionFactory.createConnection();
		String sql = "update 评论信息 set discuss=?where number=?";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			 pst.setString(1,discuss);
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
/*	public static void main(String[] args){
		Discussinfo sc=new Discussinfo();
		sc.updateDisuss("令人心动的一道风景，是一首无韵的诗，是一首无言的歌。秋，是精彩，是缘分，是生命中刻骨铭心的情怀，是一抹风，是一场雨。秋，能够释然",7);
	}*/
	//通过编号删除评论信息
	public void DeleteDiscuss(int number){
		Connection conn = ConnectionFactory.createConnection();
		String sql = "delete from 评论信息 where number = ?";
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
		Discussinfo sc=new Discussinfo();
		sc.DeleteDiscuss(19);
	}*/
}

package film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class cinemainfo {
	private int number;//影院编号
	private String file;//图片文件位置
	private String cinema;//影院名称
	private String town;//城市
	private String address;//地址
	private String mob;//电话
	private int Atstarting;//初始价格
	private String remarks;//备注
	public cinemainfo(int number,String file, String cinema, String town, String address, String mob, int Atstarting,String remarks) {
		super();
		this.number = number;
		this.file = file;
		this.cinema = cinema;
		this.town = town;
		this.address = address;
		this.mob = mob;
		this.Atstarting=Atstarting;
		this.remarks = remarks;
	}
	public cinemainfo(String cinema, String town, String address, String mob,int Atstarting,String remarks) {
		super();
		this.cinema = cinema;
		this.town = town;
		this.address = address;
		this.mob = mob;
		this.Atstarting=Atstarting;
		this.remarks = remarks;
	}	
	public cinemainfo() {
		// TODO Auto-generated constructor stub
	}
	public int getNumber() {
		return number;
	}
	public void setNumbre(int number) {
		this.number = number;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getCinema() {
		return cinema;
	}
	public void setCinema(String cinema) {
		this.cinema = cinema;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public int getAtstarting() {
		return Atstarting;
	}
	public void setAtstarting(int atstarting) {
		Atstarting = atstarting;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	//添加影院信息
			public boolean AddCinemainfo(cinemainfo tj){
				Connection conn = ConnectionFactory.createConnection();
				String sql ="INSERT INTO 影院信息(cinema,town, address,mob,Atstarting,remarks) values(?,?,?,?,?,?)";
				PreparedStatement pst = null;
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1,tj.getCinema());
					pst.setString(2,tj.getTown());
					pst.setString(3,tj.getAddress());
					pst.setString(4,tj.getMob());
					pst.setInt(5,tj.getAtstarting());
					pst.setString(6,tj.getRemarks());
					int n = pst.executeUpdate();
					if(n>0)
						System.out.print("影院信息添加成功 ");
						return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				} finally{
					ConnectionFactory.close(conn);
					ConnectionFactory.close(pst);
				}
				System.out.print("电影信息添加失败 ");
				return false;
			}
/*tic void main(String[] args){
			  cinemainfo t=new cinemainfo("奇艺娱乐影城","长治","襄垣县太行路386号（百桌旗舰店院内）","0355-5550999","一次性3D眼镜;可停车 院内免费，当日顾客凭票免费停车3小时，一车多票不累计;免费WIFI");
				t.AddCinemainfo(t);
				  
		}*/
//删除影院信息
		public void DeleteCinema(int number){
			Connection conn = ConnectionFactory.createConnection();
			String sql = "delete from 影院信息 where number = ?";
			PreparedStatement pst = null;
			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1,number);
				int n =pst.executeUpdate();
				if(n!=0)
					System.out.println("删除成功！");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("删除失败！");
			}finally{
				ConnectionFactory.close(conn);
				ConnectionFactory.close(pst);
			}	
		}
		/*public static void main(String[] args){
			cinemainfo sc=new cinemainfo();
			sc.DeleteCinema(19);
		}*/
		//修改影院信息
		public boolean Revisecinema(String file, String cinema, String town, String address, String mob, int Atstarting,String remarks,int number){
			Connection conn = ConnectionFactory.createConnection();
			String sql = "UPDATE 影院信息 SET file=?,cinema=?,town=?,address=?,mob=?,Atstarting=?,remarks=?WHERE number=?";
			PreparedStatement pst = null;
			try {
				pst = conn.prepareStatement(sql);
				 pst.setString(1,file);
				 pst.setString(2,cinema);
				 pst.setString(3,town);
				 pst.setString(4,address);
				 pst.setString(5,mob);
				 pst.setInt(6,Atstarting);
				 pst.setString(7,remarks);
				 pst.setInt(8,number);
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
			cinemainfo xg=new cinemainfo();
			xg.Revisecinema("","UME影城（太原店）","太原","杏花岭区晋安东街7号（太原市富力广场）","0351-5265566/5268899",28,"改签 未取票用户放映前3小时可改签;3D眼镜 影院可提供免押金3D眼镜。"
					+ "持私人专属3D眼镜观影更健康，线上购票后，选择一款心爱的3D眼镜吧！儿童优惠 儿童观影需购票入场;可停车 商场地下有停车场;情侣座 10号情侣厅",12);
		}*/
		//模糊查询影院信息
				public List<cinemainfo>Inquirefilm(String cinema){
					String sql = "SELECT * FROM 影院信息  WHERE cinema LIKE ?";
					Connection conn = ConnectionFactory.createConnection();
					PreparedStatement pst = null;
					List<cinemainfo> list = new ArrayList<cinemainfo>();
					try {
						pst = conn.prepareStatement(sql);
						pst.setString(1, "%"+cinema+"%");
						ResultSet rs = pst.executeQuery();
						while(rs.next()){
							int number=rs.getInt("number");
							String file= rs.getString("file");
							String cinema1= rs.getString("cinema");
							String town= rs.getString("town");
							String address= rs.getString("address");
							String mob= rs.getString("mob");
							int Atstarting= rs.getInt("Atstarting");
							String remarks= rs.getString("remarks");
							cinemainfo cx = new cinemainfo(number,file,cinema1,town,address,mob,Atstarting,remarks);
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
				      cinemainfo qu = new cinemainfo();
					List<cinemainfo> li = qu.Inquirefilm("奇艺");
					for(cinemainfo cx: li){
							 System.out.println(+cx.getNumber()+cx.getFile()+cx.getCinema()+cx.getTown()+cx.getAddress()+cx.getMob()+cx.getAtstarting()+cx.getRemarks());
							}}	*/
}

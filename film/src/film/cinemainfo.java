package film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class cinemainfo {
	private int number;//ӰԺ���
	private String file;//ͼƬ�ļ�λ��
	private String cinema;//ӰԺ����
	private String town;//����
	private String address;//��ַ
	private String mob;//�绰
	private int Atstarting;//��ʼ�۸�
	private String remarks;//��ע
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
	//���ӰԺ��Ϣ
			public boolean AddCinemainfo(cinemainfo tj){
				Connection conn = ConnectionFactory.createConnection();
				String sql ="INSERT INTO ӰԺ��Ϣ(cinema,town, address,mob,Atstarting,remarks) values(?,?,?,?,?,?)";
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
						System.out.print("ӰԺ��Ϣ��ӳɹ� ");
						return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
				} finally{
					ConnectionFactory.close(conn);
					ConnectionFactory.close(pst);
				}
				System.out.print("��Ӱ��Ϣ���ʧ�� ");
				return false;
			}
/*tic void main(String[] args){
			  cinemainfo t=new cinemainfo("��������Ӱ��","����","��ԫ��̫��·386�ţ������콢��Ժ�ڣ�","0355-5550999","һ����3D�۾�;��ͣ�� Ժ����ѣ����չ˿�ƾƱ���ͣ��3Сʱ��һ����Ʊ���ۼ�;���WIFI");
				t.AddCinemainfo(t);
				  
		}*/
//ɾ��ӰԺ��Ϣ
		public void DeleteCinema(int number){
			Connection conn = ConnectionFactory.createConnection();
			String sql = "delete from ӰԺ��Ϣ where number = ?";
			PreparedStatement pst = null;
			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1,number);
				int n =pst.executeUpdate();
				if(n!=0)
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
			cinemainfo sc=new cinemainfo();
			sc.DeleteCinema(19);
		}*/
		//�޸�ӰԺ��Ϣ
		public boolean Revisecinema(String file, String cinema, String town, String address, String mob, int Atstarting,String remarks,int number){
			Connection conn = ConnectionFactory.createConnection();
			String sql = "UPDATE ӰԺ��Ϣ SET file=?,cinema=?,town=?,address=?,mob=?,Atstarting=?,remarks=?WHERE number=?";
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
			cinemainfo xg=new cinemainfo();
			xg.Revisecinema("","UMEӰ�ǣ�̫ԭ�꣩","̫ԭ","�ӻ�������������7�ţ�̫ԭ�и����㳡��","0351-5265566/5268899",28,"��ǩ δȡƱ�û���ӳǰ3Сʱ�ɸ�ǩ;3D�۾� ӰԺ���ṩ��Ѻ��3D�۾���"
					+ "��˽��ר��3D�۾���Ӱ�����������Ϲ�Ʊ��ѡ��һ���İ���3D�۾��ɣ���ͯ�Ż� ��ͯ��Ӱ�蹺Ʊ�볡;��ͣ�� �̳�������ͣ����;������ 10��������",12);
		}*/
		//ģ����ѯӰԺ��Ϣ
				public List<cinemainfo>Inquirefilm(String cinema){
					String sql = "SELECT * FROM ӰԺ��Ϣ  WHERE cinema LIKE ?";
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
					List<cinemainfo> li = qu.Inquirefilm("����");
					for(cinemainfo cx: li){
							 System.out.println(+cx.getNumber()+cx.getFile()+cx.getCinema()+cx.getTown()+cx.getAddress()+cx.getMob()+cx.getAtstarting()+cx.getRemarks());
							}}	*/
}

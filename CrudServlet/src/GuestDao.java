import java.util.*;
import java.sql.*;

public class GuestDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javatpoint?user=root&password=dinga");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int save(Guest g){
		int status=0;
		try{
			Connection con=GuestDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into guest(name,email,mobile,room,amount,date) values (?,?,?,?,?,?)");
			ps.setString(1,g.getName());
			ps.setString(2,g.getEmail());
			ps.setString(3,g.getMobile());
			ps.setString(4,g.getRoom());
			ps.setString(5,g.getAmount());
			ps.setString(6,g.getDate());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(Guest g){
		int status=0;
		try{
			Connection con=GuestDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update guest set name=?,email=?,mobile=?,room=?,amount=?,date=? where id=?");
			ps.setString(1,g.getName());
			ps.setString(2,g.getEmail());
			ps.setString(3,g.getMobile());
			ps.setString(4,g.getRoom());
			ps.setString(5,g.getAmount());
			ps.setString(6,g.getDate());
			ps.setInt(7,g.getId());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=GuestDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from guest where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static Guest getEmployeeById(int id){
		Guest g=new Guest();
		
		try{
			Connection con=GuestDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from guest where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				g.setId(rs.getInt(1));
				g.setName(rs.getString(2));
				g.setEmail(rs.getString(3));
				g.setMobile(rs.getString(4));
				g.setRoom(rs.getString(5));
				g.setAmount(rs.getString(6));
				g.setDate(rs.getString(7));
				
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return g;
	}
	public static List<Guest> getAllEmployees(){
		List<Guest> list=new ArrayList<Guest>();
		
		try{
			Connection con=GuestDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from guest");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Guest g=new Guest();
				g.setId(rs.getInt(1));
				g.setName(rs.getString(2));
				g.setEmail(rs.getString(3));
				g.setMobile(rs.getString(4));
				g.setRoom(rs.getString(5));
				g.setAmount(rs.getString(6));
				g.setDate(rs.getString(7));
				list.add(g);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<style>div.container{width:100%;border:1px solid gray;}"
				+ "header,footer{padding:1em;color;white;background-color:black;clear:left;text-align:center;}"
				+ "nav{float:left;max-width:160px;marign:0;padding:1em;}"
				+ "nav ul{list-style-type:none;padding:0;}"
				+ "nav ul a{text-decoration:none;}"
				+ "article{marign-left:170px;border-left:1px solid gray;padding:1em;overflow:hidden;}"
				+ "table,tr,td{border:1px solid black; border-collapse: collapse;}table{ border-collapse: collapse;}</style>");
		
		out.println("<body><div class='container'><header><h1 style='color:white;'>Paying Guest</h1></header><nav><ul><li><a href='index.html' target='_self'><b>Add New Guest</b></a></li>");
		out.println("<hr><li><a href='ViewServlet' target='_self'><b>View Guests</b></a></li></ul></nav>");
		out.println("<article><h1 align='center'>Guests List</h1>");
		
		List<Guest> list=GuestDao.getAllEmployees();
		
		out.print("<table align='center'");
		out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Mobile</th><th>Room</th><th>Amount</th><th>Date</th><th>Edit</th><th>Delete</th></tr>");
		for(Guest g:list){
			out.print("<tr><td>"+g.getId()+"</td><td>"+g.getName()+"</td><td>"+g.getEmail()+"</td><td>"+g.getMobile()+"</td><td>"+g.getRoom()+"</td><td>"+g.getAmount()+"</td><td>"+g.getDate()+"</td><td><a href='EditServlet?id="+g.getId()+"'>edit</a></td><td><a href='DeleteServlet?id="+g.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table></article></div>");
		
		out.close();
	}
}

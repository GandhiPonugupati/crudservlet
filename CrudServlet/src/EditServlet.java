

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
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
		
		out.println("<body><div class='container'><header><h1 style='color:white;'>Update Guests</h1></header><nav><ul><li><a href='index.html' target='_self'><b>Add New Guest</b></a></li>");
		out.println("<hr><li><a href='ViewServlet' target='_self'><b>View Guests</b></a></li></ul></nav>");
		out.println("<article><h1 align='center'>Update Guests</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Guest e=GuestDao.getEmployeeById(id);
		
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table align='center'>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
		out.print("<tr><td>Mobile:</td><td><input type='text' name='mobile' value='"+e.getMobile()+"'/></td></tr>");
		out.print("<tr><td>Room:</td><td>");
		out.print("<select name='room' style='width:150px'>");
		out.print("<option>101</option>");
		out.print("<option>102</option>");
		out.print("<option>103</option>");
		out.print("<option>104</option>");
		out.print("<option>105</option>");
		out.print("<option>106</option>");
		out.print("<option>107</option>");
		out.print("<option>108</option>");
		out.print("<option>109</option>");
		out.print("<option>110</option>");
		out.print("<option>201</option>");
		out.print("<option>202</option>");
		out.print("<option>203</option>");
		
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td>Amount:</td><td><input type='number' name='amount' value='"+e.getAmount()+"'/></td></tr>");
		out.print("<tr><td>Date:</td><td><input type='date' name='date' value='"+e.getDate()+"'/></td></tr>");
		out.print("<tr align='right'><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form></article></div>");
		
		out.close();
	}
}

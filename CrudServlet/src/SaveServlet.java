

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String room=request.getParameter("room");
		String amount=request.getParameter("amount");
		String date=request.getParameter("date");
		
		Guest g=new Guest();
		g.setName(name);
		g.setEmail(email);
		g.setMobile(mobile);
		g.setRoom(room);
		g.setAmount(amount);
		g.setDate(date);
		
		int status=GuestDao.save(g);
		if(status>0){
			out.print("<p align='center'>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}else{
			out.println("<p align='center'>Sorry! unable to save record</p>");
		}
		
		out.close();
	}

}

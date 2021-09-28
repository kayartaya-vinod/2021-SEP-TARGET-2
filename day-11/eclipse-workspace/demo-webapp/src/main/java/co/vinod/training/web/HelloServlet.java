package co.vinod.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	
	// a variant of the service method
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		System.out.println("Some client made a request at " + new Date());
		// req --> question paper in a written exam
		// resp --> answer sheet in the same exam
		// out --> pen using which you may write on the answer sheet
		
		String username = req.getParameter("username");
		if(username==null) {
			username = "friend";
		}
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>Hello, world!</h1>");
		out.println("<hr>");
		out.printf("<p>How are you %s?</p>%n", username);
		out.println("<p>This is an output from a Servlet</p>");
		out.close();
		
	}

}

package q4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cookie
 */
@WebServlet("/cookie")
public class cookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String msg = "Cookie Maintaining";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1><center>"  + msg +  "</center></h1>");


        // print out cookies

        Cookie ck[]=request.getCookies();  
        for(int i=0;i<ck.length;i++){  
         out.print("<br>"+ck[i].getName()+" "+ck[i].getValue());//printing name and value of cookie  
        }  

        // set a cookie

        String name = request.getParameter("cookieName");
        if (name != null && name.length() > 0) {
            String value = request.getParameter("cookieValue");
            Cookie c = new Cookie(name, value);
            response.addCookie(c);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

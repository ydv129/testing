import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;

public class Servlet1 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Page 1</title></head>");
        HttpSession hs = request.getSession(true);
        if(hs.isNew())
        {
            out.println("<body bgcolor=cyan>");
            String name = request.getParameter("txtName");
            hs.setAttribute("uname", name);
            hs.setAttribute("visit", "1");
            out.println("<h1>Welcome for the first time</h1>");
        }
        else
        {
            out.println("<h1>Welcome Back to the Page</h1>");
            int visit = +Integer.parseInt((String)hs.getAttribute("visit"))+1;
            out.println("<h1>You have visited "+visit+" Times</h1>");
            hs.setAttribute("visit", visit+"");
        }
        hs.setMaxInactiveInterval(60*60);
        out.println("<h1>Your Session ID: "+hs.getId()+ "<br>Timeout:"+hs.getMaxInactiveInterval()+"</h1>");
        out.println("<h1><br>Last Accessed Time: "+new Date(hs.getLastAccessedTime())+"<br>You Logged in at: "+new Date(hs.getCreationTime())+"</h1>");
        out.println("<h1><a href=Servlet2>Click for Page 2 </a></h1>");
        out.println("<h1><a href=Servlet3>Click for Page 3 </a></h1>");
        out.println("<h1><a href=LogoutServlet>Click to Logout </a></h1>");
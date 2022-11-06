

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet(urlPatterns="/login")

public class login extends HttpServlet{

    public void init(){} 

    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException { 
        String Email=req.getParameter("Email"); 
        String Pass=req.getParameter("Pass"); 
        Connection con; 
        try { 
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/se_project","root","root"); 
            Statement st=con.createStatement(); 
            int f=0; 
            String q="select * from register"; 
            ResultSet rs=st.executeQuery(q); 
            while(rs.next()){ 
                if(rs.getString(1).equals(Email) && rs.getString(2).equals(Pass)) { 
                    f=1; 
                    break; 
                } 
            } 
            if(f==1) {
                res.sendRedirect("homepage.html");

                } 
            else if(f==0) { 
                res.sendRedirect("index.html");
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    public void destroy() { }

}
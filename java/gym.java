import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/gym")

public class gym extends HttpServlet{

public void init() {}

public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
Connection con;
try {
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/se_project","root","root");
resp.setContentType("text/html");
PrintWriter out = resp.getWriter();

String Name = req.getParameter("Name");
String Contact = req.getParameter("Contact");
String Flatno = req.getParameter("Flatno");

String Appo = req.getParameter("Appo");


String query = "insert into gym values("+"'"+Name+"',"+"'"+Contact+"',"+"'"+Flatno+"',"+"'"+Appo+"'"+")";

Statement st = con.createStatement();
st.executeUpdate(query);
st.close();
con.close();
resp.sendRedirect("confirm_a.html");
} catch (SQLException e) {
PrintWriter out1 = resp.getWriter();
out1.println(e);
}
}

public void destroy() {}
}
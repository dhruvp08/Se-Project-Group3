import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/index")

public class register extends HttpServlet{

public void init() {}

public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
Connection con;
try {
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/se_project","root","root");
resp.setContentType("text/html");
PrintWriter out = resp.getWriter();

String Email = req.getParameter("Email");
String Pass = req.getParameter("Pass");
String Society = req.getParameter("Society");

String Flatno = req.getParameter("Flatno");


String query = "insert into register values("+"'"+Email+"',"+"'"+Pass+"',"+"'"+Society+"',"+"'"+Flatno+"'"+")";

Statement st = con.createStatement();
st.executeUpdate(query);
st.close();
con.close();
resp.sendRedirect("index.html");
} catch (SQLException e) {
PrintWriter out1 = resp.getWriter();
out1.println(e);
}
}

public void destroy() {}
}
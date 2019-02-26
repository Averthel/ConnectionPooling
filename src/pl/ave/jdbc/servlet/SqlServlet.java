package pl.ave.jdbc.servlet;



import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.ave.jdbc.data.User;
import pl.ave.jdbc.db.DbUtil;

@WebServlet("/SqlServlet")
public class SqlServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("get");
        if ("show".equals(param)) {
            try {
                List<User> komentarze = getComments();
                request.setAttribute("komentarze", komentarze);
                request.getRequestDispatcher("commentlist.jsp").forward(request, response);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                response.sendError(500); // nie uda³o siê pobraæ danych
            }
        } else {
            response.sendError(403);
        }
    }

    private List<User> getComments() throws SQLException, ClassNotFoundException {
        final String driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(driver);

        List<User> komentarze = null;
        final String sqlQuery = "Select username, tresc FROM comments";
        try (Connection conn = DbUtil.getInstance().getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery);) {
            
        	String username = null;
            String tresc = null;
            komentarze = new ArrayList<>();
            while (resultSet.next()) {
                username = resultSet.getString("username");
                tresc = resultSet.getString("tresc");
                User komentarz = new User(username, tresc);
                komentarze.add(komentarz);
            }
        }
        return komentarze;
    }
}

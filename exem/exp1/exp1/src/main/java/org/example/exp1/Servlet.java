package org.example.exp1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String chose = request.getParameter("golos");
        ConnectionPool pool = new ConnectionPool();

        try {
            String update = "update VOTE set COUNT_OF_VOTE += 1 where NAME = ?";
            try (PreparedStatement statment = pool.GetConnect().prepareStatement(update)) {

                switch (request.getParameter("golos")) {
                    case "alex":
                        statment.setString(1, "Alex");
                        break;
                    case "evgen":
                        statment.setString(1, "Evgesha");
                        break;
                    case "nikitos":
                        statment.setString(1, "Nikita");
                        break;
                    case "nikolas":
                        statment.setString(1, "Nikola");
                        break;
                    default:
                        statment.setString(1, "aaaaa");
                        break;
                }
                int row = statment.executeUpdate();
                Statement stat = pool.GetConnect().createStatement();
                String locate = "Select * from VOTE";

                List<People> PeopleList = new ArrayList<>();

                try (ResultSet rs = stat.executeQuery(locate)) {
                    while (rs.next()) {
                        People pr = new People();
                        pr.setVote(rs.getInt("COUNT_OF_VOTE"));
                        pr.setName(rs.getString("NAME"));
                        PeopleList.add(pr);
                    }

                    rs.close();
                    stat.close();
                }

                if (row > 0) {
                    request.setAttribute("lst", PeopleList);
                    request.getRequestDispatcher("Info.jsp").forward(request, response);
                } else {
                    ServletContext servletContext = getServletContext();
                    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/error.jsp");
                    request.setAttribute("name", "You not chose people");
                    requestDispatcher.forward(request, response);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}

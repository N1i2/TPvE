package org.example.exem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Servlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        ConnectionPool pool = new ConnectionPool();

        Statement stat = null;
        try {
            stat = pool.GetConnect().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String locate = "Select * from VOTE";

        List<People> PeopleList = new ArrayList<>();

        try (ResultSet rs = stat.executeQuery(locate)) {
            while (rs.next()) {
                People pr = new People();
                pr.setAddress(rs.getString("ADDRESS"));
                pr.setName(rs.getString("NAME"));
                PeopleList.add(pr);
            }

            rs.close();
            stat.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("lst", PeopleList);
        try {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}

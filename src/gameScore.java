/*
 * Created by jabhi on 04-Apr-17.
 */

import org.BG.DataBaseConnection;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;

@WebServlet(name = "gameScore", urlPatterns = "/gameScore")
public class gameScore extends HttpServlet {

    private boolean status = false;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
            String gameId = request.getParameter("gameId");
            String scoreS = request.getParameter("score");
            int score = Integer.parseInt(scoreS);

            String username = "NULL";

            Connection connection = new DataBaseConnection().getDBConnection();

            username = (String) request.getSession(false).getAttribute("user");

            String query = "UPDATE gamestatus SET " + gameId + " = " + score + " WHERE username = '" + username + "'";
            Statement st = connection.createStatement();
            int result = st.executeUpdate(query);
            if (result > 0)
                status = true;
            else
                status = false;

            st.close();
            connection.close();
        }
        catch (Exception e){
            System.out.println("" + e);
        }

        if (status)
            response.sendRedirect("smartComp");
        else
            response.sendRedirect("../Alert/Error-found.html");
    }
}
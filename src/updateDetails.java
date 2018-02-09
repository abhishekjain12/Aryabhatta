/*
 * Created by jabhi on 06-Apr-17.
 */

import org.BG.DataBaseConnection;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;

@WebServlet(name = "updateDetails", urlPatterns = "/updateDetails")
public class updateDetails extends HttpServlet {

    private boolean status = false;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try{
            String name = request.getParameter("name");
            String work = request.getParameter("work");

            String username = "NULL";

            Connection connection = new DataBaseConnection().getDBConnection();

            username = (String) request.getSession(false).getAttribute("user");

            String query = "UPDATE details SET name = '" + name + "' WHERE username = '" + username + "'";
            Statement st = connection.createStatement();
            int result = st.executeUpdate(query);
            if (result > 0)
                status = true;
            else
                status = false;

            String query1 = "UPDATE comptab SET work = '" + work + "' WHERE username = '" + username + "'";
            Statement st1 = connection.createStatement();
            int result1 = st.executeUpdate(query1);
            if (result1 > 0 && status)
                status = true;
            else
                status = false;


            st.close();
            st1.close();
            connection.close();
        }
        catch (Exception e){
            System.out.println("" + e);
        }

        if (status)
            response.sendRedirect("fix.jsp");
        else
            response.sendRedirect("../Alert/Error-found.html");
    }
}

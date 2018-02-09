/*
 * Created by jabhi on 03-Apr-17.
 */

import org.BG.DataBaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;

@WebServlet(name = "signIn", urlPatterns = "/signIn")
public class signIn extends HttpServlet {

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        boolean status = false;
        String errorMessage = null;

        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Connection connection = new DataBaseConnection().getDBConnection();

            String query = "select * from details where username = '" + username + "' AND password = '" + password + "'";
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery(query);

            if (result.next()) {
                status = true;

                HttpSession session = request.getSession(true);
                session.setAttribute("user", username);
            }
            else {
                status = false;
                errorMessage = "invalidPassword";
            }
            st.close();
            connection.close();
        }
        catch (Exception e){
            System.out.println("" + e);
            status = false;
        }

        if (status) {
            RequestDispatcher rd = request.getRequestDispatcher("smartComp");
            rd.forward(request,response);
        }
        else {
            response.sendRedirect("../Alert/Error-found.html?message=" + errorMessage);
        }
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        doPost(request,response);
    }
}

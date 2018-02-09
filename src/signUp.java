/*
 * Created by jabhi on 02-Apr-17.
 */

import org.BG.DataBaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;


@WebServlet(name = "signUp", urlPatterns = "/signUp")
public class signUp extends HttpServlet {

    private Connection connection = null;
    private String username;

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        boolean status = false;
        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            username = request.getParameter("username");
            String password = request.getParameter("password");
            String birthday = request.getParameter("birthday");
            String gender = request.getParameter("gender");

            String focus = request.getParameter("focus");
            String cal = request.getParameter("cal");
            String memory = request.getParameter("memory");
            String work = request.getParameter("work");
            String outdoor = request.getParameter("outdoor");
            String indoor = request.getParameter("indoor");
            String reading = request.getParameter("reading");
            String writing = request.getParameter("writing");
            String watching = request.getParameter("watching");

            connection = new DataBaseConnection().getDBConnection();

            String query = "insert into details values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,username);
            ps.setString(4,password);
            ps.setString(5,birthday);
            ps.setString(6,gender);

            int result = ps.executeUpdate();
            if (result>0)
                status = true;
            else
                status = false;

            String query1 = "insert into comptab values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps1 = connection.prepareStatement(query1);
            ps1.setString(1,username);
            ps1.setString(2,focus);
            ps1.setString(3,cal);
            ps1.setString(4,memory);
            ps1.setString(5,work);
            ps1.setString(6,outdoor);
            ps1.setString(7,indoor);
            ps1.setString(8,reading);
            ps1.setString(9,writing);
            ps1.setString(10,watching);

            int result1 = ps1.executeUpdate();
            if (result1>0 && status)
                status = true;
            else
                status = false;

            ps.close();
            ps1.close();
            connection.close();
        }
        catch (Exception e){
            System.out.println("" + e);
            status = false;
        }

        if (status) {
            RequestDispatcher rd = request.getRequestDispatcher("smartBG");
            rd.forward(request,response);
        }
        else {
            releaseData();
            response.sendRedirect("../Alert/Error-found.html");
        }
    }

    private void releaseData(){
        try{
            connection = new DataBaseConnection().getDBConnection();

            String query = "delete from details where username = '" + username + "'";
            Statement st = connection.createStatement();
            int result = st.executeUpdate(query);
            System.out.println("Deleted row : " + result);

            String filename = "D:/My Projects/BrainGames/web/res/user-img/" + username + ".jpg";
            File fileJPG = new File(filename);
            if ( fileJPG.exists()) {
                boolean deleteCheck = fileJPG.delete();
                System.out.println(deleteCheck);
            }
        }
        catch (Exception e){
            System.out.println("" + e);
        }
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        try {
            doPost(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
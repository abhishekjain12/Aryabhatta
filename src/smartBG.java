/**
 * Created by jabhi on 03-Apr-17.
 */

import org.BG.DataBaseConnection;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;

@WebServlet(name = "smartBG", urlPatterns = "/smartBG")
public class smartBG extends HttpServlet {

    private Connection connection = null;
    private boolean status = false;

    private String username;
    private String birthday;
    private String gender;
    private String focus;
    private String cal;
    private String memory;
    private String work;
    private String outdoor;
    private String indoor;
    private String reading;
    private String writing;
    private String watching;
    private int probSolG = 0;
    private int memoryG = 0;
    private int focusG = 0;
    private int mentalG = 0;
    private int sizeCount = 0;
    private int lastCities = 0;
    private int rushBack = 0;
    private int trueColor = 0;
    private int rank = 0;

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        try {
            username = request.getParameter("username");

            connection = new DataBaseConnection().getDBConnection();

            String query = "select * from details where username = '" + username + "'";
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery(query);

            if (result.next()) {
                status = true;
                birthday = result.getString("birthday");
                gender = result.getString("gender");
            }
            else
                status = false;

            String query1 = "select * from comptab where username = '" + username + "'";
            Statement st1 = connection.createStatement();
            ResultSet result1 = st.executeQuery(query1);

            if (result1.next() && status) {
                status = true;
                focus = (result1.getString("focus")==null)?"":result1.getString("focus");
                cal = (result1.getString("cal")==null)?"":result1.getString("cal");
                memory = (result1.getString("memory")==null)?"":result1.getString("memory");
                work = (result1.getString("work")==null)?"":result1.getString("work");
                outdoor = ((result1.getString("outdoor")==null)?"":result1.getString("outdoor"));
                indoor = (result1.getString("indoor")==null)?"":result1.getString("indoor");
                reading = (result1.getString("reading")==null)?"":result1.getString("reading");
                writing = (result1.getString("writing")==null)?"":result1.getString("writing");
                watching = (result1.getString("watching")==null)?"":result1.getString("watching");
            }
            else
                status = false;

            st.close();
            st1.close();
            connection.close();
        }
        catch (Exception e){
            System.out.println("" + e);
            status = false;
        }

        if (status) {
            boolean check = smartRank();
            if (check)
                response.sendRedirect("../Alert/success.html");
            else {
                releaseData();
                response.sendRedirect("../Alert/Error-found.html");
            }
        }
        else {
            releaseData();
            response.sendRedirect("../Alert/Error-found.html");
        }
    }

    public int smartAlgo(){

        if ((gender.equals("male") && work.equals("teacher")) || (memory.equals("yes") && work.equals("banker")))
            rank = 2;
        else
            rank = 5;

        if ((focus.equals("yes") && memory.equals("no") && work.equals("banker")) ||
                (gender.equals("male") && cal.equals("yes") && work.equals("student"))) {
            rank = 3;
            sizeCount = 2000;
        }
        else
            rank = 5;

        if (cal.equals("no") && work.equals("student") && outdoor.equals("outdoor")) {
            rank = 4;
            rushBack = 3200;
        }
        else
            rank = 5;

        if ((gender.equals("female") && work.equals("teacher")) ||
                (gender.equals("female") && memory.equals("yes") && work.equals("student") && reading.equals("reading"))) {
            rank = 6;
            lastCities = 1250;
        }
        else
            rank = 5;

        if ((focus.equals("no") && memory.equals("no") && work.equals("banker") && outdoor.equals("outdoor")) ||
                (work.equals("student") && outdoor.equals("outdoor") && indoor.equals("indoor"))) {
            rank = 7;
            trueColor = 2000;
        }
        else
            rank = 5;

        return rank;
    }

    public boolean smartRank(){

        rank = smartAlgo();

        switch (rank){
            case 2:
                setValues(81, 81, 81, 81);
                break;

            case 3:
                setValues(100, 81, 55, 37);
                break;

            case 4:
                setValues(37, 100, 81, 55);
                break;

            case 6:
                setValues(55, 37, 100, 81);
                break;

            case 7:
                setValues(81, 55, 37, 100);
                break;

            default:
                  setValues(25,25,25,25);
                  break;
        }

        boolean check =false;

        try {
            connection = new DataBaseConnection().getDBConnection();

            String query = "INSERT INTO gamestatus VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setInt(2, probSolG);
            ps.setInt(3, memoryG);
            ps.setInt(4, focusG);
            ps.setInt(5, mentalG);
            ps.setInt(6, sizeCount);
            ps.setInt(7, lastCities);
            ps.setInt(8, rushBack);
            ps.setInt(9, trueColor);
            ps.setInt(10, rank);

            int result = ps.executeUpdate();
            if (result > 0)
                check = true;
            else
                check = false;

            ps.close();
        }
        catch (Exception e){
            System.out.println("" + e);
        }
        return check;
    }

    private void setValues(int probSolG, int focusG, int memoryG, int mentalG){
        this.probSolG = probSolG;
        this.focusG = focusG;
        this.memoryG = memoryG;
        this.mentalG = mentalG;
    }

    private void releaseData(){
        try{
            connection = new DataBaseConnection().getDBConnection();

            String query = "delete from details,comptab where username = '" + username + "'";
            Statement st = connection.createStatement();
            int result = st.executeUpdate(query);
            System.out.println("Deleted row : " + result);
        }
        catch (Exception e){
            System.out.println("" + e);
        }
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        doPost(request,response);
    }
}
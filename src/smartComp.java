/*
 * Created by jabhi on 04-Apr-17.
 */

import org.BG.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;

@WebServlet(name = "smartComp", urlPatterns = "/smartComp")
public class smartComp extends HttpServlet {

    private Connection connection = null;
    private boolean status = false;
    private boolean check = false;

    private String username;
    private int probSolG = 0;
    private int memoryG = 0;
    private int focusG = 0;
    private int mentalG = 0;
    private int sizeCount = 0;
    private int lastCities = 0;
    private int rushBack = 0;
    private int trueColor = 0;
    private int rank = 0;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            username = (String) request.getSession(false).getAttribute("user");

            connection = new DataBaseConnection().getDBConnection();

            String query = "select * from gamestatus where username = '" + username + "'";
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery(query);

            if (result.next()) {
                status = true;
                probSolG = result.getInt("probsol");
                memoryG = result.getInt("memory");
                focusG = result.getInt("focus");
                mentalG = result.getInt("mental");
                sizeCount = result.getInt("sizecount");
                lastCities = result.getInt("lastcities");
                rushBack = result.getInt("rushback");
                trueColor = result.getInt("truecolor");
                rank = result.getInt("rank");
            }

            smartCal();

            check = updateData();

            String probsolG1 = Integer.toString(probSolG);
            String memoryG1 = Integer.toString(memoryG);
            String focusG1 = Integer.toString(focusG);
            String mentalG1 = Integer.toString(memoryG);
            String sizeCount1 = Integer.toString(sizeCount);
            String lastCities1 = Integer.toString(lastCities);
            String rushBack1 = Integer.toString(rushBack);
            String trueColor1 = Integer.toString(trueColor);

            Cookie probsolC = new Cookie("probsol", probsolG1);
            Cookie memoryC = new Cookie("memory", memoryG1);
            Cookie focusC = new Cookie("focus", focusG1);
            Cookie mentalC = new Cookie("mental", mentalG1);
            Cookie sizeCountC = new Cookie("sizeCount", sizeCount1);
            Cookie lastCitiesC = new Cookie("lastCities", lastCities1);
            Cookie rushBackC = new Cookie("rushBack", rushBack1);
            Cookie trueColorC = new Cookie("trueColor", trueColor1);

            probsolC.setMaxAge(60*60*24);
            memoryC.setMaxAge(60*60*24);
            focusC.setMaxAge(60*60*24);
            mentalC.setMaxAge(60*60*24);
            sizeCountC.setMaxAge(60*60*24);
            lastCitiesC.setMaxAge(60*60*24);
            rushBackC.setMaxAge(60*60*24);
            trueColorC.setMaxAge(60*60*24);

            response.addCookie(probsolC);
            response.addCookie(memoryC);
            response.addCookie(focusC);
            response.addCookie(mentalC);
            response.addCookie(sizeCountC);
            response.addCookie(lastCitiesC);
            response.addCookie(rushBackC);
            response.addCookie(trueColorC);

            st.close();
            connection.close();
        }
        catch (Exception e){
            System.out.println("" + e);
        }

        if (status && check)
            response.sendRedirect("profile.jsp");
        else
            response.sendRedirect("../Alert/Error-found.html");
    }

    private void smartCal(){

        if (sizeCount != 0 && trueColor != 0 && rushBack != 0 && lastCities != 0){

            if (sizeCount >= 2000 && trueColor >= 2000 && rushBack >= 3200 && lastCities >= 1250) {
                setValues(100, 100, 100, 100);
                rank = 1;
            }
            if ((1400 < sizeCount && sizeCount < 2000) && (1400 < trueColor && trueColor < 2000) &&
                    (2500 < rushBack && rushBack < 3200) && (800 < lastCities && lastCities < 1250)) {
                setValues(81, 81, 81, 81);
                rank = 2;
            }
            if ((sizeCount >= 2000) && (trueColor <= 600) &&
                    (2500 < rushBack && rushBack < 3200) && (200 < lastCities && lastCities <= 800)) {
                setValues(100, 81, 55, 37);
                rank = 3;
            }
            if ((sizeCount <= 600) && (600 < trueColor && trueColor < 1200) &&
                    (rushBack >= 3200) && (800 < lastCities && lastCities < 1250)) {
                setValues(37, 100, 81, 55);
                rank = 4;
            }
            if (sizeCount <= 500 && trueColor <= 500 && rushBack <= 800 && lastCities <= 200) {
                setValues(25, 25, 25, 25);
                rank = 5;
            }
            if ((600 < sizeCount && sizeCount < 1200) && (1200 <= trueColor && trueColor < 2000) &&
                    (rushBack < 1000) && (lastCities >= 1250)) {
                setValues(55, 37, 100, 81);
                rank = 6;
            }
            if ((1200 < sizeCount && sizeCount < 2000) && (trueColor >= 2000) &&
                    (1000 < rushBack && rushBack <= 2500) && (lastCities <= 200)) {
                setValues(81, 55, 37, 100);
                rank = 7;
            }
            if ((sizeCount >= 2000) && (trueColor >= 2000) && (rushBack < 3200) && (lastCities < 1250)) {
                setValues(100, 70, 68, 100);
                rank = 8;
            }
            if ((sizeCount < 2000) && (trueColor >= 2000) && ( rushBack >= 3200) && (lastCities < 1250)) {
                setValues(70, 100, 68, 100);
                rank = 9;
            }
            if ((sizeCount < 2000) && (trueColor < 2000) && (rushBack >= 3200) && (lastCities >= 1250)) {
                setValues(68, 100, 100, 70);
                rank = 10;
            }
            if ((sizeCount >= 2000) && (trueColor < 2000) && (rushBack < 3200) && (lastCities >= 1250)) {
                setValues(100, 68, 100, 70);
                rank = 11;
            }
            if ((sizeCount >= 2000) && (trueColor >= 2000) && (rushBack >= 3200) && (lastCities < 1250)) {
                setValues(100, 100, 70, 100);
                rank = 12;
            }
            if ((sizeCount < 2000) && (trueColor >= 2000) && (rushBack >= 3500) && (lastCities >= 1250)) {
                setValues(70, 100, 100, 100);
                rank = 13;
            }
            if ((sizeCount >= 2000) && (trueColor >= 2000) && (rushBack < 3200) && (lastCities >= 1250)) {
                setValues(100, 100, 70, 100);
                rank = 14;
            }
            if ((sizeCount >= 2000) && (trueColor < 2000) && (rushBack >= 3200) && (lastCities >= 1250)) {
                setValues(100, 100, 100, 70);
                rank = 15;
            }
            if (sizeCount >= 2000){
                probSolG = 100;
                rank = 16;
            }
            if (trueColor >= 2000){
                mentalG = 100;
                rank = 17;
            }
            if (rushBack >=3200){
                focusG = 100;
                rank = 18;
            }
            if (lastCities >=1250){
                memoryG = 100;
                rank = 19;
            }
        }
    }

    private void setValues(int probSolG, int focusG, int memoryG, int mentalG){
        this.probSolG = probSolG;
        this.focusG = focusG;
        this.memoryG = memoryG;
        this.mentalG = mentalG;
    }

    private boolean updateData(){
        boolean check =false;

        try {
            connection = new DataBaseConnection().getDBConnection();

            String query = "UPDATE gamestatus SET probsol = " + probSolG + " , memory = " + memoryG +
                    " , focus = " + focusG + " , mental = " + mentalG + " , rank = " + rank +
                    " WHERE username = '" + username + "'";

            Statement st = connection.createStatement();
            int result = st.executeUpdate(query);

            if (result > 0)
                check = true;
            else
                check = false;

            st.close();
        }
        catch (Exception e){
            System.out.println("" + e);
        }

        return check;
    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        doPost(request,response);
    }
}

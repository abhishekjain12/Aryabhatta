package org.BG;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.*;

@WebServlet(name = "profitDetails", urlPatterns = "/profitDetails")
public class profileDetails extends HttpServlet {

    private String name = "N/A";
    private String email = "N/A";
    private String birthday = "N/A";
    private String gender = "N/A";
    private String work = "N/A";
    private int probSolG = 0;
    private int memoryG = 0;
    private int focusG = 0;
    private int mentalG = 0;
    private int rank = 0;
    private int rankD =0;
    private String sizeCount = "none";
    private String rushBack = "none";
    private String trueColor = "none";
    private String lastCities = "none";
    private String cmplt = "none";

    public void fetchDetails(String username) {
        try {
             Connection connection = new DataBaseConnection().getDBConnection();

            String query = "select * from details where username = '" + username + "'";
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery(query);

            if (result.next()) {
                name = result.getString("name");
                email = result.getString("email");
                birthday = result.getString("birthday");
                gender = result.getString("gender");
            }

            String query1 = "select * from comptab where username = '" + username + "'";
            Statement st1 = connection.createStatement();
            ResultSet result1 = st.executeQuery(query1);

            if (result1.next()) {
                work = result1.getString("work");
            }

            String query2 = "select * from gamestatus where username = '" + username + "'";
            Statement st2 = connection.createStatement();
            ResultSet result2 = st.executeQuery(query2);

            if (result2.next()) {
                probSolG = result2.getInt("probsol");
                focusG = result2.getInt("focus");
                memoryG = result2.getInt("memory");
                mentalG = result2.getInt("mental");
                rank = result2.getInt("rank");
            }

            gameComp();

            st.close();
            st1.close();
            st2.close();
            connection.close();
        }
        catch (Exception e){
            System.out.println("" + e);
        }
    }

    private void gameComp(){
        switch (rank){
            case 1:
                cmplt = "block";
                break;

            case 2:
                sizeCount = rushBack = lastCities = trueColor = "block";
                break;

            case 3:
                rushBack = lastCities = trueColor = "block";
                break;

            case 4:
                sizeCount = lastCities = trueColor = "block";
                break;

            case 5:
                sizeCount = rushBack = lastCities = trueColor = "block";
                break;

            case 6:
                sizeCount = rushBack = trueColor = "block";
                break;

            case 7 :
                sizeCount = rushBack = lastCities = "block";
                break;

            case 8:
                rushBack = lastCities = "block";
                break;

            case 9:
                sizeCount = lastCities = "block";
                break;

            case 10:
                sizeCount = trueColor = "block";
                break;

            case 11:
                rushBack = trueColor = "block";
                break;

            case 12:
                lastCities = "block";
                break;

            case 13:
                sizeCount = "block";
                break;

            case 14:
                rushBack = "block";
                break;

            case 15:
                trueColor = "block";
                break;

            default:
                sizeCount = rushBack = lastCities = trueColor = "block";
                break;
        }

        rankD = rank;
        if (rank == 5){
            rankD = 6;
        }
        if (rank >= 16 && rank <= 19){
            rankD = 5;
        }
        if (rank == 3 || rank == 4 || rank == 6 || rank == 7){
            rankD = 4;
        }
        if (rank >= 8 && rank <= 11){
            rankD = 3;
        }
        if (rank >= 12 && rank <= 15){
            rankD = 2;
        }
    }

    public String getName(){return name;}
    public String getEmail(){return email;}
    public String getBirthday(){return birthday;}
    public String getGender(){return gender;}
    public String getWork(){return work;}
    public int getProbSolG(){return probSolG;}
    public int getMemoryG(){return memoryG;}
    public int getFocusG(){return focusG;}
    public int getMentalG(){return mentalG;}
    public int getRank(){return rankD;}
    public String getSizeCount(){return sizeCount;}
    public String getRushBack(){return rushBack;}
    public String getTrueColor(){return trueColor;}
    public String getLastCities(){return lastCities;}
    public String getCmplt(){return cmplt;}
}

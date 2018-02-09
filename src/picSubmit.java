/*
 * Created by jabhi on 14-May-17.
 */

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.BG.DataBaseConnection;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "picSubmit", urlPatterns = "/picSubmit")
public class picSubmit extends HttpServlet {

    private String username;
    private String name;
    private int check;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        final String UPLOAD_DIRECTORY = "D:/My Projects/BrainGames/web/res/user-img";

        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for(FileItem item : items){
                    if(item.isFormField()) {
                        if(item.getFieldName().equals("username")) {
                            username=item.getString();
                            check ++;
                        }
                    }
                    if(!item.isFormField()){
                        name = new File(item.getName()).getName();
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                        check ++;
                    }
                }

                if (check == 2) {
                    File file = new File(UPLOAD_DIRECTORY + File.separator + name);
                    File newFile = new File(UPLOAD_DIRECTORY + File.separator + username + ".jpg");
                    boolean renameCheck = file.renameTo(newFile);
                    System.out.println(renameCheck);
                }

            } catch (Exception ex) {
                releaseData();
                response.sendRedirect("../Alert/Error-found.html");
            }
        }else{
            releaseData();
            response.sendRedirect("../Alert/Error-found.html");
        }
    }

    private void releaseData(){
        try{
            Connection connection = new DataBaseConnection().getDBConnection();

            String query = "delete from details where username = '" + username + "'";
            Statement st = connection.createStatement();
            int result = st.executeUpdate(query);
            System.out.println("Deleted row : " + result);
        }
        catch (Exception e){
            System.out.println("" + e);
        }
    }
}
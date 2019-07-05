package servlet.consult;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import utils.JsonTreatment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "/home/dromard/Téléchargements";
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                String name = "";
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);
                FileItem item = multiparts.get(0);
                if(!item.isFormField()){
                    name = new File(item.getName()).getName();
                    item.write( new File( UPLOAD_DIRECTORY + File.separator + name));
                }
                JsonTreatment parser = new JsonTreatment(UPLOAD_DIRECTORY + File.separator + name);
                String location = parser.getLocation();
                String token = parser.getToken();
                request.setAttribute("location", location);
                request.setAttribute("token", token);
                request.getRequestDispatcher("result").forward(request, response);

            } catch (Exception ex) {
                request.setAttribute("error", "File Upload Failed due to " + ex);
                request.getRequestDispatcher("/verification.jsp").forward(request, response);
            }

        }else{
            request.setAttribute("error", "File Upload Failed");
            request.getRequestDispatcher("/verification.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}


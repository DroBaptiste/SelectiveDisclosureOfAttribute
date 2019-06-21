package servlet.register;

import javax.servlet.ServletException;
import java.io.*;
import java.io.IOException;

public class DownloadServlet extends javax.servlet.http.HttpServlet{
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String filename=null;

        try
        {
            filename = request.getParameter("filename");

            if(filename == null || filename.equals(""))
            {
                throw new ServletException("File Name can't be null or empty");
            }

            String filepath = "yourDirPath"+filename;   //change your directory path

            File file = new File(filepath);
            if(!file.exists())
            {
                throw new ServletException("File doesn't exists on server.");
            }

            response.setContentType("APPLICATION/OCTET-STREAM");
            response.setHeader("Content-Disposition","attachment; filename=\"" +  filename + "\"");

            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(filepath);

            int i;
            while ((i=fileInputStream.read()) != -1)
            {
                response.getWriter().write(i);
            }
            fileInputStream.close();
        }
        catch(Exception e)
        {
            System.err.println("Error while downloading file["+filename+"]"+e);
        }
    }
}

package com.viwmox.main.bean;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by SWSD on 2017-05-03.
 */
@WebServlet(name = "download",urlPatterns = "/downurl")
public class DownLoad extends HttpServlet{



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");


        //获得请求文件名
        String filename = req.getParameter("filename");
        System.out.println(filename);

        //设置文件MIME类型
        resp.setContentType(getServletContext().getMimeType(filename));
        //设置Content-Disposition
        resp.setHeader("Content-Disposition", "attachment;filename="+filename);
        //读取目标文件，通过response将目标文件写到客户端
        //获取目标文件的绝对路径

        File file = new File("D://file");
        for(int i=0;i<file.list().length;i++){
            String fullFileName = file.getPath()+"\\"+file.list()[i];
            System.out.println(fullFileName+""+new File(fullFileName).exists());

            //读取文件
            InputStream in = new FileInputStream(fullFileName);
            OutputStream out = resp.getOutputStream();

            //写文件
            int b;
            while((b=in.read())!= -1)
            {
                out.write(b);
            }

            in.close();
            out.close();
            return;
        }

//        String fullFileName = getServletContext().getRealPath("/download/" + filename);
//        System.out.println(fullFileName+""+new File(fullFileName).exists());
//
//        //读取文件
//        InputStream in = new FileInputStream(fullFileName);
//        OutputStream out = resp.getOutputStream();
//
//        //写文件
//        int b;
//        while((b=in.read())!= -1)
//        {
//            out.write(b);
//        }
//
//        in.close();
//        out.close();
    }
}

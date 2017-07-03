package com.viwmox.main;

import com.google.gson.Gson;
import com.viwmox.main.bean.resbean.MainResBean;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by SWSD on 2016-06-07.
 */
@WebServlet(name = "test",urlPatterns = "/testurl")
public class Main extends HttpServlet{

    Gson gson=new Gson();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        MainResBean mainResBean=new MainResBean();
        mainResBean.setAge(34);
        mainResBean.setName("唐杰get");
        pw.print(gson.toJson(mainResBean));

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String acceptjson = "";
//        req.setCharacterEncoding("UTF-8");
//            BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream(), "UTF-8"));
//            StringBuffer sb = new StringBuffer("");
//            String temp;
//            while ((temp = br.readLine()) != null) {
//                sb.append(temp);
//            }
//            br.close();
//            acceptjson = sb.toString();
//
//
//        System.out.println(acceptjson);
//
//
//        resp.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html;charset=UTF-8");
//        PrintWriter pw = resp.getWriter();
//        MainResBean mainResBean=new MainResBean();
//        mainResBean.setAge(34);
//        mainResBean.setName("唐杰post");
//        pw.print(gson.toJson(mainResBean));


        InputStream inputStream  = req.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\1.jpg"));
        byte[] ints = new byte[1024];
        int lenth = inputStream.read(ints);
        while(lenth>0){
            fileOutputStream.write(ints,0,lenth);
            lenth = inputStream.read(ints);
        }
        inputStream.close();
        fileOutputStream.flush();
        fileOutputStream.close();
    }


    public String toString(String old){
        try {
            return new String(old.getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}

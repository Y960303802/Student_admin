package cn.plato.servlet;



import cn.plato.domain.PageBean;
import cn.plato.domain.User;
import cn.plato.service.UserService;
import cn.plato.service.impl.USerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //1.获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数

        if(currentPage == null || "".equals(currentPage)){

            currentPage = "1";
        }


        if(rows == null || "".equals(rows)){
            rows = "5";
        }
        System.out.println("currentPage---"+currentPage);
        System.out.println("rows-----"+rows);

        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();
        Set<String> keySet = condition.keySet();
        for (String key : keySet) {
            String value = condition.get(key)[0];
            System.out.println("key--"+key+"--"+"value---"+value);
        }

        System.out.println("condition-----"+condition.toString());


        //2.调用service查询
        UserService service = new USerServiceImpl();
        PageBean<User> pb = service.findUserByPage(currentPage,rows,condition);
        System.out.println("pb----"+pb );

        //3.将PageBean存入request
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);//将查询条件存入request
        //4.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

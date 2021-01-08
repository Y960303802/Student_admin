package cn.plato.servlet;

import cn.plato.domain.User;
import cn.plato.service.impl.USerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用UserService完成查询
        USerServiceImpl service = new USerServiceImpl();
        List<User> users = service.findAll();
        //2.将List存入request域
        request.setAttribute("users",users);
        //3.转发
        request.getRequestDispatcher(request.getContextPath()+"/findUserByPageServlet").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

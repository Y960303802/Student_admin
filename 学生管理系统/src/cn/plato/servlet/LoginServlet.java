package cn.plato.servlet;

import cn.plato.dao.impl.UserDaoImpl;
import cn.plato.domain.User;
import cn.plato.service.UserService;
import cn.plato.service.impl.USerServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //设置编码格式
        request.setCharacterEncoding("utf-8");
        //获取验证码数据
        Object checkcode_server = request.getSession().getAttribute("CHECKCODE_SERVER");
        String s = checkcode_server.toString();
        String verifycode = request.getParameter("verifycode");
        //判断验证码是否正确
        if (!s.equalsIgnoreCase(verifycode)){
            //发送错误信息
            request.setAttribute("login_msg","验证码错误");
            //重定向到login.jsp页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        //定义一个map集合接受发送过来的参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        //封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用Service查询判断用户名和密码是否正确
        UserService userService = new USerServiceImpl();
        User loginUser = userService.login(user);
        System.out.println(loginUser);
        System.out.println(user);
        //6.判断是否登录成功
        if(loginUser!=null){
            //登录成功
            //将用户保存session
            HttpSession session = request.getSession();
            session.setAttribute("user",loginUser);
            //跳转页面
            response.sendRedirect(request.getContextPath()+"/index.jsp");
            System.out.println(request.getContextPath());
        }
        else{
            //登入失败
            //提示信息
            request.setAttribute("login_msg","用户名和密码错误");
            //跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

package cn.run.web.servlet;

import cn.run.domain.User;
import cn.run.service.UserService;
import cn.run.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 处理响应数据的格式和编码，通知浏览器数据的显示方式
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println("doGet!");
        System.out.println ("doGet1");

        String Name=request.getParameter("username");
        UserService ws = new UserServiceImpl();
        User list =  ws.show(Name);
        request.setAttribute("list",list);
        request.getRequestDispatcher("/receive.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

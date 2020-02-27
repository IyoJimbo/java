package servlet;
import com.Dao.UserDao;
import com.commute.ChoseCourse;
import com.commute.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class TestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        User user =new User();
        user.setName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        UserDao userDao =new UserDao();
        boolean a =userDao.loginDao(user); // 如果账号匹配成功，那么转发页面信息到下一个页面welcome.jsp,否则失败重定向再次登入
        if (a){
            request.getRequestDispatcher("welcome.jsp").forward(request,response);
        }else {
            ChoseCourse choseCourse=new ChoseCourse();
            choseCourse.setItem("登入失败");
            request.getSession().setAttribute("message",choseCourse.getItem());
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

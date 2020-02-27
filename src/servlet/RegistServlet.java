package servlet;

import com.Dao.UserDao;
import com.commute.ChoseCourse;
import com.commute.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User user=new User();

        user.setName(request.getParameter("username"));
        //user.setPassword(request.getParameter("userPassword"));
        user.setDate(request.getParameter("userDate"));
        user.setType(request.getParameter("userGender"));
        System.out.println("*********************++++*****pring****"+request.getParameter("userGender"));
        //user.setType(Integer.parseInt(request.getParameter("userGender")));
        user.setRoute(request.getParameter("userRoute"));
        user.setBd_time(request.getParameter("userBd_time"));
        user.setBd_st(request.getParameter("userBd_st"));
        user.setDrop_time(request.getParameter("userDrop_time"));
        user.setDrop_st(request.getParameter("userDrop_st"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date date = new Date();
        String s = simpleDateFormat.format(date);
        user.setRc_time(s);
        UserDao userDao= new UserDao();
        boolean result=userDao.regist(user);
        if (result){
            //request.getRequestDispatcher("login.jsp").forward(request,response);
            request.getRequestDispatcher("success.jsp").forward(request,response);
        }else {

            ChoseCourse choseCourse=new ChoseCourse();
            choseCourse.setItem("登记失败");
            request.getSession().setAttribute("message",choseCourse.getItem());
            response.sendRedirect("welcome.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

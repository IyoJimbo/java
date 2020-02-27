package servlet;

import com.Dao.UserDao;
import com.commute.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Object> list =new ArrayList<>();
        list.add(request.getParameter("query"));
        UserDao userDao=new UserDao();
        allselectAll(userDao.queryname(list));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public static void allselectAll(List<Map<String,Object>> relist){
        for (Map<String, Object> a:relist){
            User user=new User();
            user.setId(Integer.valueOf((Integer) a.get("id")));
            user.setName(a.get("name").toString());
            user.setPassword(a.get("password").toString());
            user.setDate(a.get("date").toString());
            user.setType(a.get("type").toString());
            //user.setType(Integer.valueOf((Integer) a.get("type")));
            user.setRoute(a.get("route").toString());
            user.setBd_time(a.get("bd_time").toString());
            user.setBd_st(a.get("bd_st").toString());
            user.setDrop_time(a.get("drop_time").toString());
            user.setDrop_st(a.get("drop_st").toString());
            user.setRc_time(a.get("rc_time").toString());
            System.out.println("id: "+user.getId()+
                    "  name: "+user.getName()+"  password: "
                    +user.getPassword()+
                    "date:"+user.getDate()+
                    "type:"+user.getType()+
                    "route:"+user.getRoute()+
                    "bd_time:"+user.getBd_time()+
                    "bd_st:"+user.getBd_st()+
                    "drop_time:"+user.getDrop_time()+
                    "drop_st:"+user.getDrop_st()+
                    "rc_time:"+user.getRc_time());
        }
    }
}

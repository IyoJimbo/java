package com.Dao;

import com.Dao.IDao.IUserDao;
import com.commute.User;
import jdbc.Test_JDBC;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDao implements IUserDao {
    Test_JDBC db= new Test_JDBC();
    @Override
    public boolean loginDao(User user) {//login
        String sql ="select * from staff where name =? and password=?";
        List<Object> list=new ArrayList<Object>();
        list.add(user.getName());
        list.add(user.getPassword());
        return db.loginquery(sql,list);
    }

    @Override
    public List<Map<String, Object>> queryname(List<Object> listConditon) {
        String sql = "select * from staff where  name like ?";
        return query(listConditon, sql);
    }

    @Override
    public boolean regist(User user) {
       // String sql = "insert into login(username,password,tel,email,sex) values(?,?,?,?,?)";
        String sql = "insert into commute_rc(name,date,type,route,bd_time,bd_st,drop_time,drop_st,rc_time) values(?,?,?,?,?,?,?,?,?)";
        Test_JDBC db = new Test_JDBC();
        return db.add(sql, update(user));
    }

    public List<Object> update(User user) {
        List<Object> list1 = new ArrayList<Object>();
        list1.add(user.getName());
        list1.add(user.getDate());
        list1.add(user.getType());
        list1.add(user.getRoute());
        list1.add(user.getBd_time());
        list1.add(user.getBd_st());
        list1.add(user.getDrop_time());
        list1.add(user.getDrop_st());
        list1.add(user.getRc_time());
        System.out.println(list1.toString());
        return list1;
    }
    public List<Map<String, Object>> query(List<Object> list, String sql) {
        List<String> condition = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            condition.add("%" + list.get(i) + "%");
        }
        Test_JDBC db = new Test_JDBC();
        List<Map<String, Object>> list1 = db.queryByCondition(sql, condition);
        return list1;
    }

}

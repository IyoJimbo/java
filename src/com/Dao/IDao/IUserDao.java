package com.Dao.IDao;

import com.commute.User;

import java.util.List;
import java.util.Map;

public interface IUserDao {
    public boolean loginDao(User user);
    public boolean regist(User user);
    public List<Map<String, Object>> queryname(List<Object> listConditon);
}

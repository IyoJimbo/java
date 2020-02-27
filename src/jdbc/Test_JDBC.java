package jdbc;

import javax.xml.crypto.Data;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test_JDBC {
    public static final String driverName="com.mysql.cj.jdbc.Driver";
    public static final String url="jdbc:mysql://localhost:3306/ccb_commute?characterEncoding=UTF-8&serverTimezone=UTC";
    public static final String user="root";
    public static final String password="12345";

    public Test_JDBC(){
        //加载连接数据库的驱动
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败");
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("数据库加载 finnall test");
        }
    }
    //获取连接类
    public Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(url,user,password);
        System.out.println(con.toString());
        return con;
    }
    //注册用户名
    public boolean addUser(String sql){

        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn=getConnection();
            ps=conn.prepareStatement(sql);
            System.out.println(ps);
            ps.executeUpdate();
            closeResource(conn,ps,null);
            return true;
        } catch (SQLException e) {
            System.out.println("注册失败！！！！");
            e.printStackTrace();
            return false;
        }

    }
    //登陆验证
    public boolean loginquery(String sql, List<Object> list){
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn=getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,list.get(0).toString());
            ps.setString(2,list.get(1).toString());
            ResultSet b=ps.executeQuery();
            b.last();
            if (b.getRow()!=0){
                closeResource(conn,ps,null);
                return true;}
            else {
                closeResource(conn,ps,null);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    //定义新增操作方法
    public boolean add(String sql,List<Object> list){
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = getConnection();
            pstm = conn.prepareStatement(sql);
            setPrepaerStatement(pstm,list);
            pstm.executeUpdate();
            closeResource(conn,pstm,null);
            return true;
        } catch (SQLException e) {
            System.out.println("数据库访问异常");
            e.printStackTrace();
            return false;
        }
    }
    public void del(String sql,int id){
        Connection conn=null;
        PreparedStatement pstm=null;
        try {
            conn=getConnection();
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,id);
            pstm.executeUpdate();
            closeResource(conn,pstm,null);
        } catch (SQLException e) {
            System.out.println("delect table Error!");
            e.printStackTrace();
        }
    }
    public void updateSql(String sql,List<Object> list){
        Connection conn=null;
        PreparedStatement pstm=null;
        try {
            conn=getConnection();
            pstm=conn.prepareStatement(sql);
            setPrepaerStatement(pstm,list);
            pstm.executeUpdate();
            closeResource(conn,pstm,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //select
    public List<Map<String, Object>>
    queryByCondition(String sql, List<String> listConditon){
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        List<Map<String, Object>> list= new ArrayList<>();
//        List<Object> mapList=new ArrayList<Object>();
    try {
            conn=getConnection();
            pstm=conn.prepareStatement(sql);
            setPrepaerStatement(pstm,listConditon);
            System.out.println(sql);
            rs=pstm.executeQuery();
            list=setResultSetData(rs);
            System.out.println(list);
            closeResource(conn,pstm,rs);
            System.out.println(list);
            return list;
        } catch (SQLException e) {
            System.out.println("查询数据  sql Error");
            e.printStackTrace();
        }catch (Exception e){
        e.printStackTrace();
    }
        return null;
    }
    public  List<Map<String, Object>> connectionDate(String sql,int id){
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        List<Map<String, Object>> list= new ArrayList<>();
        try {
            conn=getConnection();
            pstm=conn.prepareStatement(sql);
            pstm.setInt(1,id);
            rs= pstm.executeQuery();;
            list=setResultSetData(rs);
            closeResource(conn,pstm,null);
            return list;
        } catch (SQLException e) {
            System.out.println("多表查询失败！~~~");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    public void select(String sql,int id){
        Connection conn=null;
        PreparedStatement pstm=null;
        try {
            conn=getConnection();
            pstm.setInt(1,id);
            pstm.executeUpdate();
            closeResource(conn,pstm,null);
        } catch (SQLException e) {
            System.out.println("Select is Error");
            e.printStackTrace();
        }
    }
    public void setPrepaerStatement(PreparedStatement pstm,List list) throws SQLException {
        if (pstm==null||list.isEmpty()){
            return;
        }
        for (int i=0;i<list.size();i++){
            if (list.get(i) instanceof String) {//left is right thing
                pstm.setString(i+1,(String) list.get(i));
            }
            else if(list.get(i) instanceof Integer){
                pstm.setInt(i+1, ((Integer) list.get(i)).intValue());
            }
            else if (list.get(i) instanceof Float){
                pstm.setFloat(i+1, ((Float) list.get(i)).floatValue());
            }
            else if (list.get(i) instanceof Data){
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                pstm.setString(i+1, formatter.format(list.get(i)));
            }
            else {
                pstm.setObject(i+1,list.get(i));
            }
        }

    }
    public void closeResource(Connection conn, PreparedStatement pstm, ResultSet rs){
        try {
            if(conn!=null)
                conn.close();
            if(pstm!=null)
                pstm.close();
            if(rs!=null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Map<String,Object>> setResultSetData(ResultSet rs)throws Exception{
        if(rs==null)
            return null; //返回的是某一行的列的个数
       int count = rs.getMetaData().getColumnCount(); //rs.getMetaData().getColumnName()返回第i列的字段名 //定义存放所有行的List集合，
        List<Map<String,Object>> rsList = new ArrayList<>();
        while (rs.next()){//遍历行
         Map<String,Object> map = new HashMap<>();
         for(int i=1;i<=count;i++){//遍历列
             String key = rs.getMetaData().getColumnName(i);
             Object value=rs.getObject(i); //定义存储所有列的map集合
           map.put(key,value);
             }
         rsList.add(map);
        }
        System.out.println("rslist1:"+rsList.size());
        return rsList;
    }
    public List<Map<String, Object>>
    twoDateSelect(String sql){
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        List<Map<String, Object>> list= new ArrayList<>();
//        List<Object> mapList=new ArrayList<Object>();
        try {
            conn=getConnection();
            pstm=conn.prepareStatement(sql);
            System.out.println(pstm);
//            pstm.setInt(1, Integer.valueOf(String.valueOf(list.get(0))));
            rs=pstm.executeQuery();
            list=setResultSetData(rs);
            closeResource(conn,pstm,rs);
            return list;
        } catch (SQLException e) {
            System.out.println("sql Error");
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

package cn.plato.dao;

import cn.plato.domain.User;
import sun.nio.cs.US_ASCII;

import java.util.List;
import java.util.Map;

public interface UserDao {
    //查询所有
     List<User> findAll();
    //查询用户通过用户名和密码
    User findUserByUsernameAndPassword(String username, String password);
    //增加用户
    void add(User user);
    //删除用户
    void delete(int id);
    //通过ID查询用户
    User findById(int id);
    //更新用户数据
    void update(User user);

    /**
     * 查询总记录数
     */
    int findTotalCount(Map<String,String[]> condition);
    /**
     * 分页查询每页记录
     */
    List<User> findByPage(int start,int rows,Map<String,String[]> condition);


}

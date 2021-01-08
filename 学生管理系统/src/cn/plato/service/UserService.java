package cn.plato.service;

import cn.plato.domain.PageBean;
import cn.plato.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用于管理的业务接口
 */

public interface UserService {
    //查询所有
    public List<User> findAll();
    /**
     * 登录方法
     */
    User login(User user);
    //增加用户
    void addUser(User user);
    //删除用户
    void deleteUser(int id);
    //通过ID查询用户
    User findUserById(int id);
    //更新用户数据
    void updateUser(User user);
    //批量删除用户
    void delSelectedUser(String[] ids);
    //分页条件查询
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}

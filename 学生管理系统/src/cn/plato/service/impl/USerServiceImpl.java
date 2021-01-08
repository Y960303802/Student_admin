package cn.plato.service.impl;

import cn.plato.dao.UserDao;
import cn.plato.dao.impl.UserDaoImpl;
import cn.plato.domain.PageBean;
import cn.plato.domain.User;
import cn.plato.service.UserService;

import java.util.List;
import java.util.Map;

public class USerServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);

    }

    @Override
    public void deleteUser(int id) {
        dao.delete(id);

    }

    @Override
    public User findUserById(int id) {
        return dao.findById(id);
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);

    }

    @Override
    public void delSelectedUser(String[] ids) {
        if(ids!=null&&ids.length>0){
//            1.遍历数组
            for (String id:ids) {
                dao.delete(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
       int currentPage=Integer.parseInt(_currentPage);
       int rows=Integer.parseInt(_rows);

       if (currentPage<=0){
           currentPage=1;
       }
       //1.创建空的PageBean对象
        PageBean<User> pb=new PageBean();
       //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //调用dao查询总记录数
        int totalCount=dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //4.调用dao查询List集合
        //计算开始的记录索引
        //查询一个每页面的数据放入List集合中
        int start =(currentPage-1)*rows;
        List<User> list = dao.findByPage(start, rows, condition);
        pb.setList(list);
        //计算总页码
        int totalPage=(totalCount%rows)==0?totalCount/rows : (totalCount/rows) + 1;
         pb.setTotalPage(totalPage);
        return pb;
    }

}

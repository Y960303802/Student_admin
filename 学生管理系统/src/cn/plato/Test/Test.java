package cn.plato.Test;

import cn.plato.domain.User;
import cn.plato.service.impl.USerServiceImpl;

import java.util.List;

public class Test {
//    public static void main(String[] args) {
//        USerServiceImpl uSerService = new USerServiceImpl();
//        List<User> all = uSerService.findAll();
//        for (User user:all) {
//            System.out.println(user);
//
//        }
//    }
    @org.junit.Test
    public void Testone() {
        USerServiceImpl uSerService = new USerServiceImpl();
        List<User> all = uSerService.findAll();
        for (User user : all) {
            System.out.println(user);

        }
    }
}

package cn.run.service;

import cn.run.domain.User;

public interface UserService {

    //注册用户
    boolean regist(User user);

    boolean active(String code);

    User login(User user);

    Boolean send(User user);

    User show(String username);
}

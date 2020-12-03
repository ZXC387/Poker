package cn.run.service.impl;

import cn.run.dao.UserDao;
import cn.run.dao.impl.UserDaoImpl;
import cn.run.domain.User;
import cn.run.service.UserService;
import cn.run.util.MailUtils;
import cn.run.util.UuidUtil;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    //注册用户
    @Override
    public boolean regist(User user) {

        //1.根据用户名查询用户对象
        User u = userDao.findByUsername(user.getUsername());
        //判断u是否为null
        if(u != null){
            //用户名存在，注册失败
            return false;
        }
        //2.保存用户信息
        //2.1设置激活码，唯一字符串
        user.setCode(UuidUtil.getUuid());
        //2.2设置激活状态
        user.setStatus("N");
        userDao.save(user);

        //3.激活邮件发送，邮件正文？
        String content="<a href='http://localhost:8080/activeUserServlet?code="+user.getCode()+"'>点击激活【跑腿儿】</a>";

        MailUtils.sendMail(user.getEmail(),content,"激活邮件");

        return true;
    }

    //激活用户
    @Override
    public boolean active(String code) {
        //1.根据激活码查询用户对象
        User user = userDao.findByCode(code);
        if(user != null){
            //2.调用dao的修改激活状态的方法
            userDao.updateStatus(user);
            return true;
        }else{
            return false;
        }

    }

   //登录
    @Override
    public User login(User user) {

        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }



    @Override
    public Boolean send(User user) {
        //1.根据用户查询用户对象
        User u = userDao.findByUser(user.getTelephone());
        //判断u是否为null
        if(u != null){
            //电话号码存在，注册失败
            return false;
        }

        //2.保存用户信息,发送需求
        userDao.saveRequest(user);

        return  true;
    }

    //展示信息
    @Override
    public User show(String username) {

        return userDao.showUser(username);
    }


}

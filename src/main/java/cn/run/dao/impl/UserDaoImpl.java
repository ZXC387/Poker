package cn.run.dao.impl;

import cn.run.dao.UserDao;
import cn.run.domain.User;
import cn.run.util.JDBCUtils;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            //1.定义sql
            String sql = "select * from tab_user where username = ?";
            //2.执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (Exception e) {

        }

        return user;
    }

    @Override
    public void save(User user) {
        //1.定义sql
        String sql = "insert into tab_user(username,password,email,real_name,telephone,sex,regist_time,address,status,code) values(?,?,?,?,?,?,?,?,?,?)";
        //2.执行sql

        template.update(sql,

                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getReal_name(),
                user.getTelephone(),
                user.getSex(),
                user.getRegist_time(),
                user.getAddress(),
                user.getStatus(),
                user.getCode()

        );
    }


    //根据激活码查询用户对象
    @Override
    public User findByCode(String code) {
        User user = null;
        try {
            String sql = "select * from tab_user where code = ?";

            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),code);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }


        return user;
    }

    //修改指定用户激活状态
    @Override
    public void updateStatus(User user) {
        String sql = "update tab_user set status = 'Y' where uid=?";

        template.update(sql,user.getUid());
    }

    /**
     * 根据用户名和密码查询的方法
     * @param username
     * @param password
     * @return
     */
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = null;
        try {
            //1.定义sql
            String sql = "select * from tab_user where username = ? and password = ?";
            //2.执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username,password);
        } catch (Exception e) {

        }

        return user;
    }

    //查询用户需求是否存在
    @Override
    public User findByUser(String telephone) {
        User user = null;
        try {
            String sql = "select * from send where telephone = ?";
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return user;
    }

    //将用户需求存入数据库
    @Override
    public void saveRequest(User user) {

        String sql = "insert into send(username,telephone,address) values(?,?,?)";

        template.update(sql,
                        user.getUsername(),
                        user.getTelephone(),
                        user.getAddress()
                        );
    }

    //展示数据
    @Override
    public User showUser(String username) {
        User user = null;
        try {
            //1.定义sql
            String sql = "select * from send where username = ?";
            //2.执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (Exception e) {

        }

        return user;
    }
}

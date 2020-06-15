package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

/**
 * @author:zlh
 * @ClassNameUserServiceImpl
 * @time:2020/6/15 13:12
 **/
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Override
    public boolean regist(User user) {
       User u = userDao.findByUsername(user.getUsername());
       if(u!=null){
           return false;
       }
       user.setCode(UuidUtil.getUuid());
       user.setStatus("N");
       userDao.save(user);

        String content="<a href='http://localhost/travel/activeUserServlet?code="+user.getCode()+"'>点击激活【黑马旅游网】</a>";
        MailUtils.sendMail(user.getEmail(),content,"激活邮件");

       return true;
    }

    @Override
    public boolean active(String code) {
        User user = userDao.findByCode(code);
        if(user!=null){
            userDao.updateStatus(user);
            return true;
        }else{
            return false;
        }


    }
}

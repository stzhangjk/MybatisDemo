package service;

import dao.mapper.UserMapper;
import entity.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by STZHANGJK on 2016.9.9.
 */
@Component
public class UserService {
    private UserMapper mapper;

    @Resource
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    public User getUser(int id){
        return mapper.selectOne(id);
    }
}

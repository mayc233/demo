package com.mayc.demo.repository;

import com.mayc.demo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mayc
 * @description
 * @Company 久远银海湖北事业部
 * @ 2018/3/1
 * {@ling User} {@link Repository}
 */
@Repository
public class UserRepository {
    /**
     * 采用内存型的存储方式->Map
     */
    private final ConcurrentMap<Integer,User> repository = new ConcurrentHashMap<>();

    private final static AtomicInteger idGememator = new AtomicInteger();

    /**
     * 保存用户对象
     * @param user
     * @return
     */
    public  boolean save(User user){
        //ID从1开始
        Integer id = idGememator.incrementAndGet();
        user.setId(id);
        return repository.put(id,user) == null;
    }

    public Collection<User> findAll(){
        return repository.values();
    }
}

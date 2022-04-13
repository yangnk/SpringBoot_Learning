package com.yangnk.jpademo.dao;

import com.yangnk.jpademo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-13 14:52
 **/
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT p FROM User p")
    List<User> selectUser();

}

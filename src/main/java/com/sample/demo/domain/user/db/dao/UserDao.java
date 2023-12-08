package com.sample.demo.domain.user.db.dao;

import com.sample.demo.domain.user.db.models.User;
import com.sample.demo.utils.Status;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

    @Query(
            value =
                    "SELECT u FROM User u WHERE (:id is Null OR u.id = :id) "
                            + "AND (:email is Null OR u.email = :email) "
                            + "AND (:phoneNumber is Null OR u.phoneNumber = :phoneNumber) "
                            + "AND (:status is Null OR u.status = :status) ")
    List<User> searchUser(Long id, String phoneNumber, String email, Status status);

    @Query(
            value =
                    "SELECT u FROM User u  WHERE (u.username = :username) "
                            + "AND (u.password = :secret) ")
    User login(String username, String secret);

    @Modifying
    @Query(
            value =
                    "UPDATE User u SET u.status=:status WHERE u.id = :userid")
    Integer updateStatus(Long userid, Status status);
}

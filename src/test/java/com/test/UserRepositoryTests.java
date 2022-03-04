package com.test;

import com.test.user.User;
import com.test.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;

    @Test

    public void testAddNew() {
        User user = new User();
        user.setFirstName("Nokubonga");
        user.setLastName("Machaba");
        user.setContactNumber(07);

        User savedUser = repo.save(user);

    }

    @Test
    public void testListAll(){
        Iterable<User> users = repo.findAll();
//        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user : users) {
            System.out.println(user);
        }
    }

   @Test
    public void testUpdate(){
       Integer userId = 1;
       Optional<User> optionalUser = repo.findById(userId);

       User user = optionalUser.get();
       user.setLastName("Makhado");
       repo.save(user);

       User updatedUser = repo.findById(userId).get();

   }

    @Test
    public void testGet(){
        Integer userId = 2;
        Optional<User> optionalUser = repo.findById(userId);

        System.out.println(optionalUser.get());

    }

    @Test
    public void testDelete(){
        Integer userId = 3;
        repo.deleteById(userId);

        Optional<User> optionalUser = repo.findById(userId);


    }

}

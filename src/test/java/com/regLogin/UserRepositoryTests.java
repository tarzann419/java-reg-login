package com.regLogin;

import com.regLogin.Entities.Repository.UserRepository;
import com.regLogin.Entities.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
//using the real db
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//don't roll back transactions. instead, commit
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateNewUser(){
        User user = new User();
        user.setEmail("angelo234@gmail.com");
        user.setFirstName("Angelo");
        user.setLastName("Whyte");
        user.setPassword("root@123");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        Assertions.assertThat(existUser.getEmail()).isEqualTo(user.getEmail());


    }

}

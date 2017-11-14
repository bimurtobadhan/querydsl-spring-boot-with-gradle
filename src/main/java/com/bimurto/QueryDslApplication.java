package com.bimurto;

import com.bimurto.domain.Users;
import com.bimurto.repository.UserRepository;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import java.util.List;

import static com.bimurto.domain.QUsers.users;

/**
 * Created by Shawrup on 13-Nov-17.
 */
@SpringBootApplication
public class QueryDslApplication implements ApplicationRunner{
    public static void main(String[] args) {
        SpringApplication.run(QueryDslApplication.class, args);
    }

    @Autowired
    UserRepository repository;

    @Autowired
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Users dmmyusers = new Users();
        dmmyusers.setName("A");
        //repository.save(dmmyusers);

        List<String> uniqueUserNames = new JPAQuery(entityManager).from(users)
                .where(users.name.like("A%"))
                .groupBy(users.name)
                .list(users.name);

        System.out.println(uniqueUserNames);

    }
}

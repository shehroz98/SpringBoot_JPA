package com.example.demo;

import com.example.demo.Entities.User;
import com.example.demo.Repository.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Iterator;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
       UserRepo userrepo= context.getBean(UserRepo.class);
        User user=new User();
        user.setName("Ali");
        user.setCity("Lahore");
        User user1 =userrepo.save(user);
        System.out.println(user1);
        Optional<User> optional1= userrepo.findById(2);
       User value= optional1.get();
        System.out.println(value);
        value.setName("Kamran");
        userrepo.save(value);
        System.out.println(value);
        Iterable<User> itr =userrepo.findAll();
        Iterator<User> iterator= itr.iterator();
        while(iterator.hasNext()){
            User data= iterator.next();
            System.out.println(data);
        }
        userrepo.deleteById(152);
        System.out.println("user deleted");
        userrepo.deleteAll();
    }

}

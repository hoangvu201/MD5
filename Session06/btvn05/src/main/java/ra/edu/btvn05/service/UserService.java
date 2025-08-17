package ra.edu.btvn05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.btvn05.model.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            users.add(new User("Nguyen Van A", 25, sdf.parse("2000-01-01"), "a@gmail.com", "0123456789"));
            users.add(new User("Nguyen Van B", 30, sdf.parse("1995-02-02"), "b@gmail.com", "0123456790"));
            users.add(new User("Nguyen Van C", 22, sdf.parse("2003-03-03"), "c@gmail.com", "0123456791"));
            users.add(new User("Nguyen Van D", 28, sdf.parse("1997-04-04"), "d@gmail.com", "0123456792"));
            users.add(new User("Nguyen Van E", 35, sdf.parse("1990-05-05"), "e@gmail.com", "0123456793"));
            users.add(new User("Nguyen Van F", 27, sdf.parse("1998-06-06"), "f@gmail.com", "0123456794"));
            users.add(new User("Nguyen Van G", 29, sdf.parse("1996-07-07"), "g@gmail.com", "0123456795"));
            users.add(new User("Nguyen Van H", 31, sdf.parse("1994-08-08"), "h@gmail.com", "0123456796"));
            users.add(new User("Nguyen Van I", 33, sdf.parse("1992-09-09"), "i@gmail.com", "0123456797"));
            users.add(new User("Nguyen Van J", 26, sdf.parse("1999-10-10"), "j@gmail.com", "0123456798"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}

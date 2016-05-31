package ua.busstation.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.busstation.core.user.*;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class RegistrationController {

    @Autowired
    private UserAndUserRoleManager manager;

    private AtomicLong id;

    @RequestMapping(value = "/regPage", method = RequestMethod.GET)
    public String regPage() {
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@RequestParam("username") String username, @RequestParam("password") String password,
                               @RequestParam("email") String email) {

        /*this.id = new AtomicLong();
        try {
            long id = this.id.incrementAndGet();
            User user = new User();
            user.setUserid(id);
            user.setUserName(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setEnabled(1);
            this.manager.saveUser(user);

            UserRole userRole = new UserRole();
            userRole.setUserid(id);
            userRole.setRole("ROLE_USER");
            this.manager.saveUserRole(userRole);

        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
*/
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setEnabled(1);
        this.manager.saveUser(user);

        UserRole userRole = new UserRole();
        userRole.setUserid(this.manager.findByUserName(username).getUserid());
        userRole.setRole("ROLE_USER");
        this.manager.saveUserRole(userRole);

        return "registrationDonePage";
    }

}

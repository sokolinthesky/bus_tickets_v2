package ua.busstation.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.busstation.core.user.User;
import ua.busstation.core.user.UserAndUserRoleManager;

@Controller()
public class UsersController {

    @Autowired
    private UserAndUserRoleManager manager;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(Model model) {
        model.addAttribute("users", manager.findAll());

        return "users";
    }

    @RequestMapping(value = "/edit{username}", method = RequestMethod.GET)
    public String editUserView(@PathVariable String username, Model model) {
        model.addAttribute("user", this.manager.findByUserName(username));

        return "editUser";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@RequestParam("id")String id,
                           @RequestParam("username")String username,
                           @RequestParam("password")String password,
                           @RequestParam("email")String email) {
        User user = this.manager.findUser(id);
        user.setUserName(username);
        user.setPassword(password);
        user.setEmail(email);

        this.manager.editUser(user);

        return "redirect:users";
    }

    @RequestMapping(value = "/remove{id}", method = RequestMethod.GET)
    public String removeUser(@PathVariable String id){
        this.manager.removeUser(id);

        return "redirect:users";
    }

}

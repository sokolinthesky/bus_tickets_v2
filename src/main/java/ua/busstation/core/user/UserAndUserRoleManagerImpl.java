package ua.busstation.core.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@ComponentScan
@Component
@EnableTransactionManagement
public class UserAndUserRoleManagerImpl implements UserAndUserRoleManager {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRolesRepository userRolesRepository;

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void saveUserRole(UserRole userRole) {
        this.userRolesRepository.save(userRole);
    }

    @Override
    public User findByUserName(String username) {
        return this.userRepository.findByUserName(username);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) this.userRepository.findAll();
    }

    @Override
    public void editUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void removeUser(String id) {
        List<UserRole> userRoleList = this.userRolesRepository.findRoleUseкByUserId(Long.parseLong(id));
        for(UserRole userRole : userRoleList) {
            this.userRolesRepository.delete(userRole);
        }
        this.userRepository.delete(Long.parseLong(id));
    }

    @Override
    public User findUser(String id) {
        return this.userRepository.findOne(Long.parseLong(id));
    }


}

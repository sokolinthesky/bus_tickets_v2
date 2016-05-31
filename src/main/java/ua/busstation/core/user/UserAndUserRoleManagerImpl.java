package ua.busstation.core.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
}

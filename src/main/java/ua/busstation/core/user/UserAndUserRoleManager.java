package ua.busstation.core.user;

import java.util.List;

public interface UserAndUserRoleManager {
    void saveUser(User user);
    void saveUserRole(UserRole userRole);
    User findByUserName(String username);
    List<User> findAll();
    void editUser(User user);
    void removeUser(String id);
    User findUser(String id);
}

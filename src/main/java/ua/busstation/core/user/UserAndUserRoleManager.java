package ua.busstation.core.user;

public interface UserAndUserRoleManager {
    void saveUser(User user);
    void saveUserRole(UserRole userRole);
    User findByUserName(String username);
}

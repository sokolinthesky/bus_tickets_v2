package ua.busstation.core.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.busstation.core.user.UserRole;

import java.util.List;

@Repository
public interface UserRolesRepository extends CrudRepository<UserRole, Long> {
	
	@Query("select a.role from UserRole a, User b where b.userName=?1 and a.userid=b.userId")
    public List<String> findRoleByUserName(String username);

    @Query("from UserRole where userid=?1")
    public List<UserRole> findRoleUseкByUserId(Long userid);
	
}
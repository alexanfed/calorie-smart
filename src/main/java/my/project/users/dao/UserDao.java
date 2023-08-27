package my.project.users.dao;

import my.project.users.bean.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserBean,Long>{

	public UserBean findByUsername(String username);
	
}

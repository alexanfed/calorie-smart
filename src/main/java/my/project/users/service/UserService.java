package my.project.users.service;

import java.util.ArrayList;
import java.util.List;

import my.project.users.dao.UserDao;
import my.project.users.bean.RoleBean;
import my.project.users.bean.UserBean;
import my.project.users.bean.UserRoleBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
    UserDao userDao;

	@Autowired
	PasswordEncoder passwordEncoder;

	public List<UserBean> list() {
		
		List<UserBean> users = this.userDao.findAll();
		
		return users;
	}
	
	public void createUser(UserBean user, Long idRole) {
				
		this.validateUser(user);
		
		RoleBean role = new RoleBean(idRole);
		
		UserRoleBean userRole = new UserRoleBean();
		userRole.setRole(role);
		userRole.setUser(user);
		
		user.setUserRoles(new ArrayList<>());
		user.getUserRoles().add(userRole);
		
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		
		this.userDao.save(user);
	}
	
	public UserBean findUser(Long idUser) {
		
		return this.userDao.findById(idUser).orElse(null);
	}
	
	public void updateUser(UserBean user, Long idRole) {
		
		this.validateUser(user);
		
        this.userDao.findById(user.getIdUser())
                 .ifPresent(u-> {
                	 u.setFirstName(user.getFirstName());
                	 u.setLastName(user.getLastName());
                	 u.setUsername(user.getUsername());
                	 u.setRegistered(user.getRegistered());
					 u.setCalPerDay(user.getCalPerDay());
                	 
             		RoleBean role = new RoleBean(idRole);
             		
             		UserRoleBean userRole = new UserRoleBean();
            		userRole.setRole(role);
            		userRole.setUser(user);
            		
            		u.getUserRoles().clear();
            		u.getUserRoles().add(userRole);
            		            		
            		this.userDao.save(u);
                 });
	}
	
	public void deleteUser(Long idUser) {
		
		this.userDao.deleteById(idUser);
	}
	
	private void validateUser(UserBean user) {
		
		if (user.getFirstName().isEmpty() ||
			user.getLastName().isEmpty() ||
			user.getUsername().isEmpty()) {
			throw new RuntimeException("Invalid User Data: " + user);
		}
	}


	public UserBean getUserByUsername(String username) {
		return userDao.findByUsername(username);
	}
}

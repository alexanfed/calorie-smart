package my.project.users.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user_role")
public class UserRoleBean {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user_role")
	Long idUserRole;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	UserBean user;

	@ManyToOne
	@JoinColumn(name="id_role")
	RoleBean role;

	public UserRoleBean() {
	}

	public Long getIdUserRole() {
		return idUserRole;
	}

	public void setIdUserRole(Long idUserRole) {
		this.idUserRole = idUserRole;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public RoleBean getRole() {
		return role;
	}

	public void setRole(RoleBean role) {
		this.role = role;
	}

}

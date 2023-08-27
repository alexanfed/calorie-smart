package my.project.users.bean;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="role")
public class RoleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_role")
	Long idRole;
	
	@Column(name="name_role")
	String nameRole;

	@Column(name="desc_role")
	String descRole;

	@Column(name="status")
	String status;

	@OneToMany(mappedBy="role")
	List<UserRoleBean> userRoles;
	
	public RoleBean() {
	}
	
	public RoleBean(Long idRole) {
		this.idRole = idRole;
	}

	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getNameRole() {
		return nameRole;
	}
	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}
	public String getDescRole() {
		return descRole;
	}
	public void setDescRole(String descRole) {
		this.descRole = descRole;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public List<UserRoleBean> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRoleBean> userRoles) {
		this.userRoles = userRoles;
	}
	
}

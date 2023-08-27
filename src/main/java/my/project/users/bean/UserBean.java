package my.project.users.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="user", schema="public")
public class UserBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	Long idUser;
	
	@Column(name="first_name")
	String firstName;

	@Column(name="last_name")
	String lastName;
	
	@Column(name="username")
	String username;
	
	@Column(name="password")
	String password;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="registered")
	Date registered;
		
	@Column(name="status")
	String status;

	@Column(name="cal_per_day")
	Long calPerDay;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true)
	List<UserRoleBean> userRoles;

	public UserBean() {
	}

	public UserBean(Long idUser, String firstName, String lastName, String username, String password, Date registered, String status, Long calPerDay) {
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.registered = registered;
		this.status = status;
		this.calPerDay = calPerDay;
		this.userRoles = userRoles;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegistered() {
		return registered;
	}

	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCalPerDay() {
		return calPerDay;
	}

	public void setCalPerDay(Long calPerDay) {
		this.calPerDay = calPerDay;
	}

	public List<UserRoleBean> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRoleBean> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public String toString() {
		return String.format(
				"UserBean [idUser=%s, firstName=%s, lastName=%s, username=%s, password=%s, registered=%s, status=%s, calPerDay=%s]",
				idUser, firstName, lastName, username, password, registered, status, calPerDay);
	}
}

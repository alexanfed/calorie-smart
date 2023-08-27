package my.project.users.dao;

import my.project.users.bean.RoleBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<RoleBean,Long>{

}

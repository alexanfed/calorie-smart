package my.project.users.service;

import java.util.List;

import my.project.users.bean.RoleBean;
import my.project.users.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
	RoleDao roleDao;
	
	public List<RoleBean> list(){
		return this.roleDao.findAll();
	}
}

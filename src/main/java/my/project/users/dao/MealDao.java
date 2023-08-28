package my.project.users.dao;

import my.project.users.bean.MealBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealDao extends JpaRepository<MealBean, Long> {

}

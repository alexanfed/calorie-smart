package my.project.users.service;

import my.project.users.bean.MealBean;
import my.project.users.dao.MealDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    @Autowired
    MealDao mealDao;

    public List<MealBean> list(){
        return this.mealDao.findAll();
    }
}

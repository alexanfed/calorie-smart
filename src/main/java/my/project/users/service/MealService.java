package my.project.users.service;

import my.project.users.bean.MealBean;
import my.project.users.bean.RoleBean;
import my.project.users.bean.UserBean;
import my.project.users.bean.UserRoleBean;
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

    public MealBean findMeal(Long idMeal) {

        return this.mealDao.findById(idMeal).orElse(null);
    }

    public void deleteMeal(Long idMeal) {
        this.mealDao.deleteById(idMeal);
    }

    public void updateMeal(MealBean meal, Long idMeal) {

        this.validateMeal(meal);

        this.mealDao.findById(meal.getIdMeal())
                .ifPresent(u-> {
                    u.setDateMeal(meal.getDateMeal());
                    u.setDescMeal(meal.getDescMeal());
                    u.setCalMeal(meal.getCalMeal());
                    u.setUser(meal.getUser());

                    this.mealDao.save(u);
                });
    }
    private void validateMeal(MealBean meal) {

        if (meal.getDescMeal().isEmpty() ||
                meal.getCalMeal().equals(0)) {
            throw new RuntimeException("Invalid Meal Data: " + meal);
        }
    }

}

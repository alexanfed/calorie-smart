package my.project.users.controller;

import jakarta.servlet.http.HttpServletRequest;
import my.project.users.bean.MealBean;
import my.project.users.bean.UserBean;
import my.project.users.service.MealService;
import my.project.users.service.UserService;
import my.project.users.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MealController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MealService mealService;

    /*
    @GetMapping("/meal/list")
    public ModelAndView list() {

        logger.debug("Listing Meals");

        List<MealBean> meals = this.mealService.list();

        return new ModelAndView("meal-list","meals",meals);
    }
        */
    @GetMapping("/meal/list")
    public ModelAndView list() {
        logger.debug("Listing Meals");

        List<MealBean> meals = this.mealService.list();

        // Calculate dailyCalories in the controller
        Long dailyCalories = calculateDailyCalories(meals); // Pass the meals to the calculation

        // Add dailyCalories to the model
        Map<String, Object> model = new HashMap<>();
        model.put("meals", meals);
        model.put("dailyCalories", dailyCalories);

        return new ModelAndView("meal-list", model);
    }

    private Long calculateDailyCalories(List<MealBean> meals) {
        // Perform the daily calorie calculation based on meals
        // This could involve iterating through meals and summing up calories
        Long dailyCalories = 0L;
        for (MealBean meal : meals) {
            dailyCalories += meal.getCalMeal();
        }
        return dailyCalories;
    }

    @GetMapping("/meal/create")
    public String showCreate() {

        logger.debug("Show Meal Create");

        return "meal-create";
    }

    @GetMapping("/meal/delete/{id}")
    public String deleteMeal(@PathVariable Long id) {

        logger.debug("Delete Meal");

        this.mealService.deleteMeal(id);

        return "redirect:/meal/list";
    }

    @GetMapping("/meal/update/{id}")
    public ModelAndView showMealUpdate(@PathVariable Long id) {

        logger.debug("Show Meal Update");

        MealBean meal = this.mealService.findMeal(id);

        return new ModelAndView("meal-update","meal",meal);
    }
    @PostMapping("/meal/update")
    public String updateMeal(HttpServletRequest req) {

        logger.debug("Update Meal");

        String idMeal = req.getParameter("idMeal");
        String user = req.getParameter("user");
        String dateMeal = req.getParameter("dateMeal");
        String descMeal = req.getParameter("descMeal");
        String calMeal = req.getParameter("calMeal");

        MealBean meal = this.createMealBean(idMeal, user, dateMeal, descMeal, calMeal);

        this.mealService.updateMeal(meal, Util.parseId(idMeal));

        return "redirect:/meal/list";
    }

    private MealBean createMealBean(String idMeal, String user, String dateMeal, String descMeal, String calMeal) {

        MealBean meal = new MealBean(Util.parseId(idMeal), "1111",Util.parseDate(dateMeal),descMeal,Util.parseCalPerDay(calMeal));

        return meal;
    }
}

package my.project.users.controller;

import my.project.users.bean.MealBean;
import my.project.users.bean.UserBean;
import my.project.users.service.MealService;
import my.project.users.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MealController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MealService mealService;

    @GetMapping("/meal/list")
    public ModelAndView list() {

        logger.debug("Listing Meals");

        List<MealBean> meals = this.mealService.list();

        return new ModelAndView("meal-list","meals",meals);
    }

    @GetMapping("/meal/create")
    public String showCreate() {

        logger.debug("Show Meal Create");

        return "meal-create";
    }
}

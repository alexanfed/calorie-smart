package my.project.users.bean;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="meal", schema="public")
public class MealBean {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_meal")
    Long idMeal;

    @ManyToOne
    @JoinColumn(name="id_user")
    UserBean user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_meal")
    LocalDateTime dateMeal;

    @Column(name="desc_meal")
    String descMeal;

    @Column(name="cal_meal")
    Long calMeal;


}

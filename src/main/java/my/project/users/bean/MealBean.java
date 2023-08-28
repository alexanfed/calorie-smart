package my.project.users.bean;

import jakarta.persistence.*;

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
    Date dateMeal;

    @Column(name="desc_meal")
    String descMeal;

    @Column(name="cal_meal")
    Long calMeal;

    public MealBean() {
    }

    public MealBean(Long idMeal, UserBean user, Date dateMeal, String descMeal, Long calMeal) {
        this.idMeal = idMeal;
        this.user = user;
        this.dateMeal = dateMeal;
        this.descMeal = descMeal;
        this.calMeal = calMeal;
    }

    public MealBean(Long idMeal, String s, Date dateMeal, String descMeal, Long calMeal) {
    }

    public Long getIdMeal() {
        return idMeal;
    }

    public UserBean getUser() {
        return user;
    }

    public Date getDateMeal() {
        return dateMeal;
    }

    public String getDescMeal() {
        return descMeal;
    }

    public Long getCalMeal() {
        return calMeal;
    }

    public void setIdMeal(Long idMeal) {
        this.idMeal = idMeal;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public void setDateMeal(Date dateMeal) {
        this.dateMeal = dateMeal;
    }

    public void setDescMeal(String descMeal) {
        this.descMeal = descMeal;
    }

    public void setCalMeal(Long calMeal) {
        this.calMeal = calMeal;
    }

    @Override
    public String toString() {
        return String.format(
                "MealBean [idMeal=%s, user=%s, dateMeal=%s, descMeal=%s, calMeal=%s]",
                idMeal, user, dateMeal, descMeal, calMeal);
    }
}

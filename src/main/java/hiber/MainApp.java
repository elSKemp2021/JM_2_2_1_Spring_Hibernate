package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Lamborghini", 100);
      Car car2 = new Car("Porsche", 200);
      Car car3 = new Car("Bugatti",300);
      Car car4 = new Car("Maybach", 400);

      userService.add(new User("Gena", "Bukin", "bukin@mail.ru", car1));
      userService.add(new User("Vova", "Putin", "putin@mail.ru", car2));
      userService.add(new User("Pavel", "Shapkin", "shapkin@mail.ru", car3));
      userService.add(new User("Denis", "Wolf", "wolf@mail.ru", car4));
      System.out.println("------------------------------------------------------");

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user.toString());
      }
      System.out.println("------------------------------------------------------");
      System.out.println(userService.getUserByCar(car2));
      context.close();
   }
}

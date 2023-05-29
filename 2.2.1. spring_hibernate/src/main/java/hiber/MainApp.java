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

        userService.add(new User("Иван", "Петров", "user1@mail.ru",new Car("BMW",1)));
        userService.add(new User("Сергей", "Иванов", "user2@mail.ru",new Car("Lexus",470)));
        userService.add(new User("Петр", "Федоров", "user3@mail.ru",new Car("Ferrari",2)));
        userService.add(new User("Федор", "Степанов", "user4@mail.ru",new Car("matiz",5)));

      userService.abb(new Car("BMW",1));
      userService.abb(new Car("Lexus",470));
      userService.abb(new Car("Ferrari",2));
      userService.abb(new Car("matiz",5));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }
        List<Car> cars = userService.listCars();
        for (Car car : cars) {
            System.out.println("Id = " + car.getId());
            System.out.println("model = " + car.getModel());
            System.out.println("series = " + car.getSeries());
            System.out.println();
        }
        System.out.println("Выводим пользователя по модели и серии");
        System.out.println(userService.getUserByCar("BMW",1));
        context.close();
    }

}


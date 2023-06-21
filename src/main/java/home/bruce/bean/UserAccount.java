package home.bruce.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CREATE TABLE `user_account` (
 * `id` int NOT NULL AUTO_INCREMENT,
 * `name` varchar(10) NOT NULL,
 * `money` int DEFAULT '0',
 * PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
 */
/**
 * INSERT INTO `user_account` (`id`,`name`,`money`) VALUES (1,'小明',2000);
 * INSERT INTO `user_account` (`id`,`name`,`money`) VALUES (2,'小英',15000);
 * INSERT INTO `user_account` (`id`,`name`,`money`) VALUES (3,'大雄',50000);
 */
@Data
@NoArgsConstructor
public class UserAccount {
    private long id;
    private String name;
    private int money;
}

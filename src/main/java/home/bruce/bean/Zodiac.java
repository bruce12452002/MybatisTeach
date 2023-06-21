package home.bruce.bean;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * CREATE TABLE `zodiac` (
 * `id` int NOT NULL,
 * `name` varchar(20) NOT NULL,
 * `en_name` varchar(20) DEFAULT NULL,
 * `weapon` varchar(20) DEFAULT NULL,
 * `attack_point` int NOT NULL,
 * PRIMARY KEY (`id`),
 * UNIQUE KEY `name_UNIQUE` (`name`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
 */
/**
 * INSERT INTO `zodiac` (`id`,`name`,`en_name`,`weapon`,`attack_point`) VALUES (1,'鼠','rat','牙齒',50);
 * INSERT INTO `zodiac` (`id`,`name`,`en_name`,`weapon`,`attack_point`) VALUES (2,'牛','ox','牛角',80);
 * INSERT INTO `zodiac` (`id`,`name`,`en_name`,`weapon`,`attack_point`) VALUES (3,'虎','tiger','牙齒',90);
 * INSERT INTO `zodiac` (`id`,`name`,`en_name`,`weapon`,`attack_point`) VALUES (4,'兔','rabbit','跳',10);
 * INSERT INTO `zodiac` (`id`,`name`,`en_name`,`weapon`,`attack_point`) VALUES (5,'龍','dragon','爪',100);
 * INSERT INTO `zodiac` (`id`,`name`,`en_name`,`weapon`,`attack_point`) VALUES (6,'蛇','snake','吐信',60);
 * INSERT INTO `zodiac` (`id`,`name`,`en_name`,`weapon`,`attack_point`) VALUES (7,'馬','horse','後踢',70);
 * INSERT INTO `zodiac` (`id`,`name`,`en_name`,`weapon`,`attack_point`) VALUES (8,'羊','sheep','撞擊',65);
 * INSERT INTO `zodiac` (`id`,`name`,`en_name`,`weapon`,`attack_point`) VALUES (9,'猴','monkey','咬',80);
 * INSERT INTO `zodiac` (`id`,`name`,`en_name`,`weapon`,`attack_point`) VALUES (10,'雞','chicken','啄',30);
 * INSERT INTO `zodiac` (`id`,`name`,`en_name`,`weapon`,`attack_point`) VALUES (11,'狗','dog','咬',40);
 * INSERT INTO `zodiac` (`id`,`name`,`en_name`,`weapon`,`attack_point`) VALUES (12,'豬','pig','咬',20);
 */
@Data
@NoArgsConstructor
public class Zodiac {
    private int id;
    private String name;
    private String enName;
    private String weapon;
    private int attackPoint;
}

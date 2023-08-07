package org.itstep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
      
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    /*
    Upload одного изображения в базу данных
    Получение коллекции изображений из базы данных и отображение ее на странице

    Создать автомобиль, к нему присоединить несколько изображений (OneToMany) и сохранить в базе данных
    Извлечь информацию об автомобиле и отобразить ее на странице
     */
}
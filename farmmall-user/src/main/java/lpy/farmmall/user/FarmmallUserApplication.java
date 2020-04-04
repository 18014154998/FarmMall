package lpy.farmmall.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages ="lpy.farmmall.user.Mapper" )
public class FarmmallUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(FarmmallUserApplication.class, args);
    }

}

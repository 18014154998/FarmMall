package lpy.farmmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "lpy.farmmall.mapper")
public class FarmmallUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FarmmallUserServiceApplication.class, args);
    }

}

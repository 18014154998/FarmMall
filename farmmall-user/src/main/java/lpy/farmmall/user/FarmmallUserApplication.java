package lpy.farmmall.user;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages ="lpy.farmmall.user.Mapper" )
public class FarmmallUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(FarmmallUserApplication.class, args);
    }

}

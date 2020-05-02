package lpy.farmmall.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "lpy.farmmall.manage.mapper")
public class FarmmallManageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FarmmallManageServiceApplication.class, args);
    }

}

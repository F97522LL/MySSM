package org.whlf.myspringproj;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@MapperScan("org.whlf.myspringproj.mapper")
@Slf4j
public class MyspringprojApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(MyspringprojApplication.class, args);

        Environment env = application.getEnvironment();
        log.info("\n    ----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Login: \thttp://{}:{}/login\n\t" +
                        //   "Doc: \thttp://{}:{}/doc.html\n"
                        "----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port")
                // InetAddress.getLocalHost().getHostAddress(),
                // env.getProperty("server.port")
        );

    }

}

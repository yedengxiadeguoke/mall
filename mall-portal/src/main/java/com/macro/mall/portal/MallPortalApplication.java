package com.macro.mall.portal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
@Slf4j
@SpringBootApplication(scanBasePackages = "com.macro.mall")
public class MallPortalApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(MallPortalApplication.class);
    }

    public static void main(String[] args)  throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(MallPortalApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        log.info("\n----------------------------------------------------------\n\t" +
                "Application Mall-portal is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port +  "/\n\t" +
                "swagger-ui: \thttp://" + ip + ":" + port + "/swagger-ui.html\n\t" +
                "----------------------------------------------------------");
    }

}

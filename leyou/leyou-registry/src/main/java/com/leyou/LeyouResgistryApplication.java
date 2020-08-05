package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import sun.applet.Main;

/**
 * <一句话功能简述><br>
 * <>
 *
 * @author $ {USER}
 * @create $ {DATE}
 * @since 1.0.0
 */

@SpringBootApplication
@EnableEurekaServer
public class LeyouResgistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeyouResgistryApplication.class);
    }


}

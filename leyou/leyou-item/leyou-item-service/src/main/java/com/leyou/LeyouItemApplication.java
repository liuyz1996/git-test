package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <一句话功能简述><br>
 * <>
 *
 * @author $ {USER}
 * @create $ {DATE}
 * @since 1.0.0
 */

@SpringBootApplication
@EnableDiscoveryClient
public class LeyouItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeyouItemApplication.class);
    }
}

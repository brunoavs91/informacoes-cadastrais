package com.boaentrega.informacoescadastrais.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }


    /**
     * Como utilizar o web client para acessar outras apis registradas no Eureka
     */

//    @Autowired
//    @LoadBalanced
//    private WebClient.Builder loadBalanced;
//
//    public Mono<String> doOtherStuff() {
//        return loadBalanced.build().get().uri("http://fornecedor../")
//                .retrieve().bodyToMono(String.class);
//    }
}

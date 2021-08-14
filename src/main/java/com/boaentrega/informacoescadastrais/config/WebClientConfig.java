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
//
//    @LoadBalanced
//    @Bean
//    WebClient.Builder loadBalanced() {
//        return WebClient.builder();
//    }
//
//    @Primary
//    @Bean
//    WebClient.Builder webClient() {
//        return WebClient.builder();
//    }
//}


//    @Autowired
//    private WebClient.Builder webClientBuilder;
//
//    @Autowired
//    @LoadBalanced
//    private WebClient.Builder loadBalanced;
//
//    public Mono<String> doOtherStuff() {
//        return loadBalanced.build().get().uri("http://stores/stores")
//                .retrieve().bodyToMono(String.class);
//    }
//
//    public Mono<String> doStuff() {
//        return webClientBuilder.build().get().uri("http://example.com")
//                .retrieve().bodyToMono(String.class);
//    }

}

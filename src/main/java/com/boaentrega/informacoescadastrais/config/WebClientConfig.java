package com.boaentrega.informacoescadastrais.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.http.HttpHeaders;

@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced
    public WebClient webClientBuilderClient() {
       return WebClient
                .builder()
               // .defaultHeader(org.apache.http.HttpHeaders.AUTHORIZATION, "Bearer " + generateToken())
                .build();
    }

//    public String generateToken() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null) {
//            return null;
//        }
//
//        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
//        return details.getTokenValue();
//
//    }


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
//    private WebClient webClientBuilder;
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

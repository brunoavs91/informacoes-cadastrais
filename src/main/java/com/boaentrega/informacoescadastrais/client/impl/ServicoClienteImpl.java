package com.boaentrega.informacoescadastrais.client.impl;

import com.boaentrega.informacoescadastrais.client.ServicoCliente;
import com.boaentrega.informacoescadastrais.config.WebClientConfig;
import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

@Service
public class ServicoClienteImpl implements ServicoCliente {

    @Autowired
    @LoadBalanced
    private WebClientConfig client;

    @Override
    public String getTesteClient() {
        return  client.webClientBuilderClient()
                .get()
                .uri("servico-cliente/teste2")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + generateToken())
                .retrieve()
                .bodyToMono(String.class).block();
    }

    public String generateToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }

        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        return details.getTokenValue();

    }
}

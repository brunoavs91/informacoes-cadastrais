package com.boaentrega.informacoescadastrais.client.impl;

import com.boaentrega.informacoescadastrais.client.ServicoCliente;
import com.boaentrega.informacoescadastrais.config.WebClientConfig;
import com.boaentrega.informacoescadastrais.model.dto.PedidoStatus;
import com.boaentrega.informacoescadastrais.service.SecurityService;
import org.apache.http.HttpHeaders;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Primary;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ServicoClienteImpl implements ServicoCliente {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WebClientConfig client;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String endPoint;

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public String getTesteClient() {
        return  client.webClientBuilderClient()
                .get()
                .uri("localhost:8083/teste2")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + securityService.getToken())
                .retrieve()
                .bodyToMono(String.class).block();
    }

    @Override
    public void enviarPedidoStatus(PedidoStatus pedidoStatus) throws IOException {
        log.info("Enviando mensagem para a fila");
        String msg = mapper.writeValueAsString(pedidoStatus);
        queueMessagingTemplate.send(endPoint, MessageBuilder.withPayload(msg).build());
        log.info("mensagem enviada");
    }

}

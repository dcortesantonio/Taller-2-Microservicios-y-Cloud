/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.calculator;

import co.edu.javeriana.ms.calculator.entities.History;
import co.edu.javeriana.ms.calculator.entities.Invocation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author estudiantes
 */
@RestController
public class CalculadoraController {

    @Autowired
    WebClient webClient;

    
    @Bean
    @LoadBalanced
    WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
    
    @Bean 
    WebClient webClient(WebClient.Builder webClientBuilder){
        return webClientBuilder.build();
    }

    @GetMapping("/calculadora/suma")
    public String calculadoraSuma(@RequestParam int a, @RequestParam int b, @RequestParam String user) {
        String response = webClient
                .get()
                .uri("http://sumador/suma?"+ 
                        "a=" + a + "&" + 
                        "b=" + b + "&"+
                        "user=" + user)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return response;
    }

    @GetMapping("/calculadora/resta")
    public String calculadoraResta(@RequestParam int a, @RequestParam int b, @RequestParam String user) {
        String response = webClient.get()
                .uri("http://restador/resta?"+ 
                        "a=" + a + "&" + 
                        "b=" + b + "&"+
                        "user=" + user)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return response;
    }

    @GetMapping("/calculadora/multip")
    public String calculadoraMultip(@RequestParam int a, @RequestParam int b, @RequestParam String user) {
        String response = webClient.get()
                .uri("http://multiplicador/multip?"+ 
                        "a=" + a + "&" + 
                        "b=" + b + "&"+
                        "user=" + user)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return response;
    }

    @GetMapping("/calculadora/div")
    public String calculadoraDiv(@RequestParam int a, @RequestParam int b, @RequestParam String user) {
        String response = webClient.get()
                .uri("http://divisiro/div?"+ 
                        "a=" + a + "&" + 
                        "b=" + b + "&"+
                        "user=" + user)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return response;
    }

    @GetMapping("/calculadora/invocations")
    public List<History> calculadoraInvocations() {
        List<History> history = new ArrayList<>();
        
        history.add( new History("Suma", webClient.get()
                            .uri("http://sumador/invocations")
                            .retrieve()
                            .bodyToFlux(Invocation.class)
                            .collect(Collectors.toList())
                            .share().block()));
        history.add( new History("Resta", webClient.get()
                            .uri("http://restador/invocations")
                            .retrieve()
                            .bodyToFlux(Invocation.class)
                            .collect(Collectors.toList())
                            .share().block()));
        history.add( new History("Multiplicacion", webClient.get()
                            .uri("http://multiplicador/invocations")
                            .retrieve()
                            .bodyToFlux(Invocation.class)
                            .collect(Collectors.toList())
                            .share().block()));
        history.add( new History("Division", webClient.get()
                            .uri("http://divisor/invocations")
                            .retrieve()
                            .bodyToFlux(Invocation.class)
                            .collect(Collectors.toList())
                            .share().block()));
        return history;
    }

}

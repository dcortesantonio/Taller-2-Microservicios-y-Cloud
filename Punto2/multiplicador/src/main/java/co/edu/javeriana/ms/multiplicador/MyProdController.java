/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.multiplicador;

import co.edu.javeriana.ms.multiplicador.entities.Invocation;
import co.edu.javeriana.ms.multiplicador.repositories.InvocationRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author estudiantes
 */
@RestController
public class MyProdController {
    @Autowired
    Environment env;
    
    @Autowired
    InvocationRepository repository;
    
    @GetMapping("/multip")
    public String sum(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        String port = env.getProperty("local.server.port");
        String response = "Resultado: " + String.valueOf(a*b) + " desde server " + port;
        Invocation invocation = new Invocation();
        invocation.setUser(user);
        invocation.setDate(new Date());
        repository.save(invocation);
        return response;
    }
    
    @GetMapping("/invocations")
    public List<Invocation> invocations() {
        return repository.findAll();
    }
    
}

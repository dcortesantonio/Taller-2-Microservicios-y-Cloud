/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.sumador;

import co.edu.javeriana.ms.sumador.models.Invocation;
import co.edu.javeriana.ms.sumador.repositories.InvocationRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author estudiantes
 */
@RestController
public class MySumController {
    
    @Autowired
    Environment env;
    
    @Autowired
    InvocationRepository repository;
    
    @GetMapping("/suma")
    public String sum(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("user") String user){
        String port = env.getProperty("local.server.port");
        String response = "Resultado: " + String.valueOf(a+b) + " desde server " + port;
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

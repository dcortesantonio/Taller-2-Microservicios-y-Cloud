/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.divisor.repositories;

import co.edu.javeriana.ms.divisor.entities.Invocation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author estudiantes
 */
@Repository
public interface InvocationRepository extends MongoRepository<Invocation, String>{
    
}

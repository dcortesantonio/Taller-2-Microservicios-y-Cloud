/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.calculator.entities;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author estudiantes
 */
@Data
@Document
@AllArgsConstructor
public class History {
    private String operation;
    private List<Invocation> invocation;
    
}

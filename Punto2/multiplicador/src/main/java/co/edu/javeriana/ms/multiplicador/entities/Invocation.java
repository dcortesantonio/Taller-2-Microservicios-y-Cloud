/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.ms.multiplicador.entities;

import java.util.Date;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author estudiantes
 */
@Data
@Document
public class Invocation {
    
    private String user;
    private Date date;
    
}
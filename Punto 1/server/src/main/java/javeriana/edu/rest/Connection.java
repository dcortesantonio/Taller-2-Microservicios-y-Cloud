package javeriana.edu.rest;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class Connection {

    public static String connectionUri = "mongodb+srv://admin:admin@pruebassmartuj.q4etg.mongodb.net/taller2?retryWrites=true&w=majority";
    public static MongoClient connectMongo(){
        MongoClient mongodb = null;
        try{
           mongodb = MongoClients.create(connectionUri);
        }catch(Exception e){

        }

        return mongodb;
    }
}

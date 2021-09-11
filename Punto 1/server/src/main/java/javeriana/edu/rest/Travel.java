package javeriana.edu.rest;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.ArrayList;
import java.util.Objects;

import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

@Path("/travel")
public class Travel {

    public static MongoClient mongo = Connection.connectMongo();
    private static final MongoDatabase tallerdb = mongo.getDatabase("taller2");
    private static final MongoCollection<Document> paseosCollection = tallerdb.getCollection("paseos");

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Document> paseos(){
        return paseosCollection.find().into(new ArrayList<Document>());
    }

    @DELETE
    @Path("{idPaseo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Document deletePaseo(@PathParam("idPaseo") int idPaseo){
        return paseosCollection.findOneAndDelete(Filters.eq("id", idPaseo));
    }

    @PUT
    @Path("{idPaseo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Document updatePaseoName(@PathParam("idPaseo") String idPaseo,
                                    @QueryParam("paseoOrigin") String paseoOrigin,
                                    @QueryParam("paseoDest") String paseoDest){
        Bson updateOrigin = null;
        Bson updateDest = null;
        if(!paseoOrigin.isEmpty()){
            updateOrigin = set("origin", paseoOrigin);
        }
        if(!paseoDest.isEmpty()){
            updateDest = set("destination", paseoDest);
        }

        return paseosCollection.findOneAndUpdate(Filters.eq("id", idPaseo),
                combine(updateOrigin, updateDest));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Document createPaseo(Paseo paseo){
        Date now = new Date();
        Document pas = new Document();
        pas.append("name", paseo.getName());
        pas.append("origin", paseo.getOrigin());
        pas.append("destination", paseo.getDestination());
        pas.append("date", now);
        pas.append("id", paseo.getId());


        paseosCollection.insertOne(pas);

        return pas;
    }
}


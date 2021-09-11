package javeriana.edu.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @GET
    @Path("puntocuatro/{op1}")
    @Produces(MediaType.TEXT_PLAIN)
    public String puntocuatro(@PathParam("op1") int op1, @QueryParam("op2") int op2) {
        return String.valueOf(op1 * op2);
    }

    @GET
    @Path("article")
    @Produces(MediaType.APPLICATION_JSON)
    public Article getArticle(){
        Article article = new Article();
        article.setAuthor("David Foster Wallace");
        article.setTitle("Infinite Jest");

        return article;
    }
}


import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public class RestClientMain {
    public static final String MY_SERVER_URL="http://localhost:8080/myapp/travel/";
    public static Client client = ClientBuilder.newClient();
    public static WebTarget webTarget = client.target(MY_SERVER_URL);
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

       int select = 9;

       while(select != 0){
           System.out.println("Bienvenido, seleccione una opcion");
           System.out.println("1. Listar todos los paseos");
           System.out.println("2. Eliminar paseo");
           System.out.println("3. Cambiar origen y destino");
           System.out.println("4. Crear un paseo");
           System.out.println("0. Salir");

           select = scanner.nextInt();

           switch(select) {
               case 1:
                   getAllPaseos();
                   break;
               case 2:
                   deletePaseo();
                   break;
               case 3:
                   updatePaseo();
                   break;
               case 4:
                   createPaseo();
                   break;
               case 0:
                   break;
               default:
                   System.out.println("Opción no válida");
           }
       }

        Invocation.Builder invocation = webTarget.request(MediaType.APPLICATION_JSON_TYPE);
        Response reponse = invocation.get();
    }

   public static void getAllPaseos(){
       List<Paseo> list = client
               .target(MY_SERVER_URL)
               .request(APPLICATION_JSON)
               .get(Response.class)
               .readEntity(new GenericType<List<Paseo>>() {});

       for(Paseo p: list){
           System.out.println(p.toString());
       }
   }
    public static void deletePaseo(){
        System.out.println("Ingrese el id del paseo que desea eliminar");
        String idPaseo = scanner.next();

       WebTarget target = client.target(MY_SERVER_URL + idPaseo);
       target.request().delete(Boolean.class);

       System.out.println("Eliminado ");

    }
    public static void updatePaseo(){
        System.out.println("Ingrese el id del paseo que desea modificar");
        String idPaseo = scanner.next();

        System.out.println("Ingrese el nuevo origen del paseo");
        String originPaseo = scanner.next();

        System.out.println("Ingrese el nuevo destino del paseo");
        String destPaseo = scanner.next();

        WebTarget target = client.target(MY_SERVER_URL + idPaseo)
                .queryParam("paseoOrigin", originPaseo)
                .queryParam("paseoDest", destPaseo);
        Response response = target.request().put(Entity.json(Paseo.class));

        System.out.println("Modificado");
    }
    public static void createPaseo(){
        System.out.println("Ingrese el id del paseo");
        int idPaseo = scanner.nextInt();

        System.out.println("Ingrese el nombre del paseo");
        String nombrePaseo = scanner.next();

        System.out.println("Ingrese el origen del paseo");
        String originPaseo = scanner.next();

        System.out.println("Ingrese el destino del paseo");
        String destPaseo = scanner.next();

        System.out.println("Ingrese la fecha del paseo");
        String dateSt = scanner.next();
        Date date = new Date();

        Paseo paseo = new Paseo(idPaseo, nombrePaseo, originPaseo, destPaseo, date);

        WebTarget target = client.target(MY_SERVER_URL);
        Response response = target.request().post(Entity.entity(paseo, MediaType.APPLICATION_JSON));

        System.out.println("Guardado: " + response);

    }
}

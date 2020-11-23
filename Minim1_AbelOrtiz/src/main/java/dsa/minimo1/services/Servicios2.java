package dsa.minimo1.services;

import dsa.minimo1.Covid19ManagerImpl;
import dsa.minimo1.Covid19Manager;
import dsa.minimo1.models.Persona;
import dsa.minimo1.models.Muestra;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/*
    Codigos utilizados:
    200 -> Ok
    201 -> Successful
    400 -> Solicitud incorrecta
    404 -> Valor no encontrado
    500 -> Error de validacion
    507 -> Almacenamiento insuficiente
 */


@Api(value = "/Persona", description = "Endpoint to User Service")
@Path("/Persona")

public class Servicios2 {

    static final Logger logger = Logger.getLogger(Servicios2.class);
    private Covid19Manager manager;

    public Servicios2() {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        this.manager = Covid19ManagerImpl.getInstance();

        if (manager.numPersonas() == 0) {
            //añadir algunos datos
            this.manager.addPerson("1", "Pepito", "Palotes",23,"B");
            this.manager.addPerson("2", "Carlos", "Jose",54,"C");
            this.manager.addPerson("3", "Pepe", "Botero",34,"A");
        }
    }

    //obtener lista entera de muestras
    @GET
    @ApiOperation(value = "obtener todas las muestras", notes = " muestras de un usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Persona.class, responseContainer = "List"),
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
// ens crea la ressposta que volem en JSON no ho hem de fer res ( es com una empaquetadora)
    public Response mostrarMuestras(@PathParam("id") String id) {

        List<Muestra> nombrelista = this.manager.mostrarMuestras(id);

        GenericEntity<List<Muestra>> entity = new GenericEntity<List<Muestra>>(nombrelista) {
        };
        return Response.status(201).entity(entity).build();

    }
    @POST
    @ApiOperation(value = "Añadir una nueva persona", notes = "Añade una nueva persona")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Persona.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/añadirPersona/{id}/{name}/{surname}/{edad}/{valoracion}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response nuevaPersona(@PathParam("id") String id,@PathParam("name") String name,@PathParam("surname") String surname,@PathParam("edad") int edad,@PathParam("valoracion") String valoracion) {
        if (name.isEmpty() || surname.isEmpty() || id.isEmpty() || valoracion.isEmpty())  return Response.status(500).entity(new Persona()).build();
        this.manager.addPerson(id,name,surname,edad,valoracion);
        return Response.status(201).entity(manager.getPersona(id)).build();
    }



}




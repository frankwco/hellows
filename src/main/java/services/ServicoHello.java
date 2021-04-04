package services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import modelo.Time;

@Path("/service")
public class ServicoHello {
	
	//http://localhost:8080/hellows/rest/service/somarInteiros?valor=1&valor2=3
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/somarInteiros")
	public String helloWebService(@QueryParam("valor") Integer valor, @QueryParam("valor2") Integer valor2){ 
//		return (valor+valor2);
		return ""+(valor+valor2);
		
	}
	
	//http://localhost:8080/hellows/rest/service/hello?valor=1&valor2=3
	@GET
	@Produces("application/json; charset=UTF-8")
//	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
	@Path("/listaTimesSP")
	public Response listaTimes(){ 
		
		List<Time> lt = new ArrayList<>();
		lt.add(new Time("Palmeiras - Maior Campeão Brasileiro", "São Paulo"));
		lt.add(new Time("São Paulo", "São Paulo"));
		lt.add(new Time("Corinthians", "São Paulo"));
		lt.add(new Time("Santos", "São Paulo"));
		lt.add(new Time("Ituano", "São Paulo"));
		lt.add(new Time("Linense", "São Paulo"));	
		
		GenericEntity<List<Time>> lista = new GenericEntity<List<Time>>(lt){};
//		return lt;
		return Response.status(200).entity(lista).build();
	}
	
	
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/listaTimesRio")
	public List<Time> listaTimes2(){ 
		
		List<Time> lt = new ArrayList<>();
	
		lt.add(new Time("Flamengo", "Rio de Janeiro"));
		lt.add(new Time("Vasco", "Rio de Janeiro"));		
		
//		GenericEntity<List<Time>> lista = new GenericEntity<List<Time>>(lt){};
		return lt;
//		return Response.status(200).entity(lista).build();
	}
	
	
	
	//http://localhost:8080/hellows/rest/service/hello2/10/10
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/hello2/{valor}/{valor2}")
	public String helloWebService2(@PathParam("valor") Integer valor, @PathParam("valor2") Integer valor2){ 
		return "Olá Mundo WebService "+(valor+valor2);
	}
	
//	http://localhost:8080/hellows/rest/service/hello3/10/
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/hello3/{valor}")
	public String helloWebService3(@PathParam("valor") Integer valor){ 
		return "Olá Mundo WebService "+valor;
	}

}

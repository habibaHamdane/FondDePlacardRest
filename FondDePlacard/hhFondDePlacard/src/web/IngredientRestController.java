package web;
import java.sql.Connection;
import java.util.List;

import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType;

import connection.SingletonConnection;
import metier.entities.Ingredient;
import metier.entities.Recipe;
import metier.iservice.IIngredientService;
import metier.serviceImpl.IngredientServiceImpl;


@Path(value = "/webServiceIngredient")
 public class IngredientRestController { 
	    
          private Connection conn;
	      private IIngredientService metierIngredientService;
        
          public IngredientRestController() {
		     super();
		     this.conn = SingletonConnection.getConnection();
		     this.metierIngredientService = new IngredientServiceImpl(conn);
	}
              
        @POST
        @Path("/ingredients") 
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        public Ingredient createIngredient(Ingredient i){
          return metierIngredientService.addIngredient(i);  
        }
        
        @POST
        @Path("/ingredients/{id_recipe}/{id_ingredient}") 
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        public void createIngredientInRecipe(Recipe r, Ingredient i){       	
      	  metierIngredientService.addIngredientInRecipe(r, i); 
        }
        
        @GET  
        @Path("/ingredients/{id_ingredient}") 
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        public Ingredient findIngredientById(@PathParam(value="id_Ingredient") Integer id_ingredient){ 
      	  return metierIngredientService.getIngredientById(id_ingredient); 
      	  }
        
        
        @GET  
        @Path("/ingredients/{mc}") 
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        public List<Ingredient> finIingredientsByMc(@QueryParam(value="mc") String mc){ 
      	  return metierIngredientService.getInggredientParMc(mc); 
      	  }
        
        @GET  
        @Path("/ingredients/{id_recipe}") 
        @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        public List<Ingredient> findIngredientsByRec(@PathParam(value="id_recipe") Integer id_recipe){ 
      	  return metierIngredientService.getIngredientsByRecipe(id_recipe); 
      	  }
        
  }
 
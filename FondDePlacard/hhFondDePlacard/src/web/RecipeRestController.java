package web;

import java.sql.Connection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import connection.SingletonConnection;
import metier.entities.Recipe;
import metier.iservice.IRecipeService;
import metier.serviceImpl.RecipeServiceImpl;

@Path(value = "/webServiceRecipe")
public class RecipeRestController {
	
	 private Connection conn;
     private IRecipeService metierRecipeService;
   
     public RecipeRestController() {
	     super();
	     this.conn = SingletonConnection.getConnection();
	     this.metierRecipeService = new RecipeServiceImpl(conn);
     }

	  @POST  
	  @Path("/recipes") 
	  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public Recipe createRecipe(Recipe r){
		  return metierRecipeService.addRecipe(r); 
	      }
	  
	  @GET  
	  @Path("/recipes/{id_recipe}") 
	  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public Recipe findRecipeById(@PathParam(value="id_recipe") Integer id_recipe){
		  return metierRecipeService.getRecipeById(id_recipe); 
		  }
	  
	  
	  @GET  
	  @Path("/recipes/{mc}") 
	  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public List<Recipe> findRecipesByMc(@QueryParam(value="mc") String mc){
		  return metierRecipeService.getRecipeParMc(mc); 
		  }
	  
	  @GET 
	  @Path("/recipes/{id_ingredient}") 
	  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	  public List<Recipe> findRecipesByIdIng(@PathParam(value="id_ingredient") Integer id_ingredient){
		  return metierRecipeService.getRecipesByIngredient(id_ingredient); 
		  }
	  
			
			  
	//  @GET
	//  @Path("/recipes/{ingredients}")
	//  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) 
	//  public List<Recipe> recipesByIngredients(@FormParam(value="ingredients") List<Ingredient> ingredients){ 
    //	return metierRecipeService.findRecipesByIngredients(ingredients); }		 
	  
}

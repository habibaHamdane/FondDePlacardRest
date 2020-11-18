package metier.entities;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import connection.SingletonConnection;
import metier.daoImpl.IngredientImpl;
import metier.daoImpl.RecipeImpl;
import metier.idao.IIngredient;
import metier.idao.IRecipe;

/*import java.awt.List;

import daoImp.IngredientImpl;*/

public class Test  {

	public static void main(String[] args) {
		
		
		/*
		 * IIngredient metier = new IngredientImpl();
		 * IRecipe metier2 = new RecipeImpl();
		 */
		
		
		/*
		 * Connection conn = SingletonConnection.getConnection(); IIngredient metier =
		 * new IngredientImpl(conn); IRecipe metier2 = new RecipeImpl(conn);
		 */
		
		//Ajouter une recette validée
			
			/*
			 * Recipe r =new Recipe(); metier2.addRecipe(new
			 * Recipe("recette8","cat8","pic8", 8)); metier2.addRecipe(new
			 * Recipe("recette9", "cat9","pic9",9)); metier2.addRecipe(new
			 * Recipe("recette10", "cat10", "pic10", 10));
			 */
		
		//Ajouter un ingredient validée
			/*
			 * Ingredient i =new Ingredient(); metier.addIngredient(new
			 * Ingredient("ing15")); metier.addIngredient(new Ingredient("ing16"));
			 * metier.addIngredient(new Ingredient("ing17"));
			 */
		 
		  
		  //Ajouter les ingredient deas une recette ??????
		  
		  
		  
		//Chercher un ingredient par mot clé validée
		
		/*
		 * List<Ingredient> ingredients = metier.getInggredientParMc("1");
		 * for(Ingredient i:ingredients) System.out.println(i.getName());
		 */
		  
		 
		 //affivher les ingredients d'une recette validée 
		  
			/*
			 * List<Ingredient>ingredients= metier.getIngredientsRecipe(new
			 * Recipe("recette1", "cat1", "pic1", 1)); for (Ingredient i:ingredients)
			 * System.out.println(i.getName());
			 */
	
       //Afficher les recette d'un ingredient validée
				
		/*
		 * List<Recipe>recipes= metier2.getRecipeByIngredient(new Ingredient("ing3"));
		 * for (Recipe r:recipes) System.out.println(r.getName());
		 */
		 
		 
		  
		  
		  
		  // trouver comments faire passer une liste d'ingredients comme paramètre !!!!		
			/*
			 * List<Ingredient> ingrs = new ArrayList<Ingredient>(); ingrs.add(new
			 * Ingredient("ing1")); ingrs.add(new Ingredient("ing6")); List<Recipe> recipes
			 * = metier2.findRecipeByIngredients(ingrs); for (Recipe r:recipes)
			 * System.out.println(r.getName());
			 */
		 

	}	
	
}

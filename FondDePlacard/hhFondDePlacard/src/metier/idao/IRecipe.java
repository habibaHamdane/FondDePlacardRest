package metier.idao;

import java.util.List;

import metier.entities.Ingredient;
import metier.entities.Recipe;


public interface IRecipe {

	public Recipe addRecipe(Recipe r);
	
	public Recipe getRecipeById(Integer id_recipe);
	
	public Recipe updateRecipe(Recipe r);
	
	//utiliser isValideCorrection
	public void correctionRequestRecipe(Recipe r, Ingredient i);
	
	//compteur pour valider la correction (3)
    public boolean isValideCorrection(Recipe r);
  
	public void recommandRecipe(Recipe r);
	
    public void notAdviseRecipe(Recipe r);
	
	public List<Recipe> getRecipeParMc(String mc);
	
	//pour récupérer une recette par son id
	//public Recipe getRecipeById(Integer id_recipe);
	
	public List<Recipe> getRecipesByIngredient(Integer id_ingredient);
	
	//à testet avec list<Integer> ingredients ou list <String> names ???
    public List<Recipe> findRecipesByIngredients(List<Ingredient> ingredients);
	  
  
}

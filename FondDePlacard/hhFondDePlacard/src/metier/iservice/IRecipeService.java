package metier.iservice;

import java.util.List;

import metier.entities.Ingredient;
import metier.entities.Recipe;

public interface IRecipeService {

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
		
	public List<Recipe> getRecipesByIngredient(Integer id_ingredient);
	
	//� testet avec list<Integer> ingredients ou list <String> names ???
    public List<Recipe> findRecipesByIngredients(List<Ingredient> ingredients);
	  
}

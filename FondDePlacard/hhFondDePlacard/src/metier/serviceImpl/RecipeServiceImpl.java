package metier.serviceImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Ingredient;
import metier.entities.Recipe;
import metier.idao.IRecipe;
import metier.iservice.IRecipeService;

public class RecipeServiceImpl implements IRecipeService {

	private IRecipe iRecipe;
	  
	public RecipeServiceImpl(Connection conn) {  
    }
	  
	@Override
	public Recipe addRecipe(Recipe r) {
		return iRecipe.addRecipe(r);	
		 
	}
	
	@Override
	public Recipe getRecipeById(Integer id_recipe) {
		return iRecipe.getRecipeById(id_recipe);
	}

	@Override
	public Recipe updateRecipe(Recipe r) {
	return iRecipe.updateRecipe(r);
	}	

	
	@Override
	public void correctionRequestRecipe(Recipe r, Ingredient i) {
		iRecipe.correctionRequestRecipe(r, i);		
	}

	@Override
	public boolean isValideCorrection(Recipe r) {
		iRecipe.isValideCorrection(r);
		return false;
	}

	@Override
	public void recommandRecipe(Recipe r) {
		iRecipe.recommandRecipe(r);		
	}

	@Override
	public void notAdviseRecipe(Recipe r) {
		iRecipe.notAdviseRecipe(r);	
	}

	@Override
	public List<Recipe> getRecipeParMc(String mc) {
		return new ArrayList<Recipe>(iRecipe.getRecipeParMc(mc));
	}

	@Override
	public List<Recipe> getRecipesByIngredient(Integer id_ingredient) {
		return new ArrayList<Recipe>(iRecipe.getRecipesByIngredient(id_ingredient));
	}

	@Override
	public List<Recipe> findRecipesByIngredients(List<Ingredient> ingredients) {
		return new ArrayList<Recipe>(iRecipe.findRecipesByIngredients(ingredients));	
	}

}

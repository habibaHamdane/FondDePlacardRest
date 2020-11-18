package metier.iservice;

import java.util.List;

import metier.entities.Ingredient;
import metier.entities.Recipe;

public interface IIngredientService {

    public Ingredient addIngredient(Ingredient i);
    
    public void addIngredientInRecipe(Recipe r, Ingredient i);
 
	public Ingredient getIngredientById(Integer id_ingredient);
	
	public List<Ingredient> getInggredientParMc(String mc);

	public List<Ingredient> getIngredientsByRecipe(Integer id_recipe);
	
	public Ingredient updateIngredient(Ingredient i);
	
}

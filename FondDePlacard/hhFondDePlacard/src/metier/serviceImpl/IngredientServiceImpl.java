package metier.serviceImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Ingredient;
import metier.entities.Recipe;
import metier.idao.IIngredient;
import metier.iservice.IIngredientService;

public class IngredientServiceImpl implements IIngredientService {

	private IIngredient iIngredient;
	  
	  public IngredientServiceImpl(Connection conn) {
	  }
	  
	@Override
	public Ingredient addIngredient(Ingredient i) {
		return iIngredient.addIngredient(i);
	}
	
	@Override
	public void addIngredientInRecipe(Recipe r, Ingredient i) {
		//r.setIdRecipe(r.getIdRecipe());
		iIngredient.addIngredientInRecipe(r, i);		
	}
	
	//chercher un ingredient par id 
	@Override
	public Ingredient getIngredientById(Integer id_ingredient) {
		return iIngredient.getIngredientById(id_ingredient);
	}


	@Override
	public List<Ingredient> getInggredientParMc(String mc) {
        return new ArrayList<Ingredient>(iIngredient.getInggredientParMc(mc));
	}

	@Override
	public List<Ingredient> getIngredientsByRecipe(Integer id_recipe) {
		return new ArrayList<Ingredient>(iIngredient.getIngredientsByRecipe(id_recipe));
	}


	@Override
	public Ingredient updateIngredient(Ingredient i) {
		return iIngredient.updateIngredient(i);
	
	}
}

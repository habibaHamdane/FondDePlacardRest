package metier.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.SingletonConnection;
import metier.entities.Ingredient;
import metier.entities.Recipe;
import metier.idao.IRecipe;

public class RecipeImpl implements IRecipe {
	
	 private Connection conn;
	  
	  public RecipeImpl(Connection conn) { 
		  this.conn = conn;  
		  }
	  
	//rajouter une recette (validée)
	@Override
	public Recipe addRecipe(Recipe r) {
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO recipe(NAME, CATEGORY, PICTURE, SCORE) VALUES(?,?,?,?)");
			ps.setString(1, r.getName());
			ps.setString(2, r.getCategory());
			ps.setString(3, r.getPicture());
			ps.setInt(4, r.getScore());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}
	
	 //chercher une recette par id 
	@Override
	public Recipe getRecipeById(Integer id_recipe) {
		Recipe r =null;
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement
					("SELECT * FROM recipe WHERE ID_RECIPE = ?");
			ps.setInt(1, id_recipe);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				r = new Recipe();
				r.setIdRecipe(rs.getInt("ID_RECIPE"));
				r.setName(rs.getString("NAME"));
				r.setCategory(rs.getString("CATEGORY"));
				r.setPicture(rs.getString("PICTURE"));
				r.setScore(rs.getInt("SCORE"));
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(r==null)throw new RuntimeException("recette "+id_recipe+ "introuvable !");
		return r;
	}
	
	//Modifier une recette 
	@Override
	public Recipe updateRecipe(Recipe r) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE recipe set NAME=?, CATEGORY=?, PICTURE=?, SCORE=? "
					                                      + "WHERE id_recipe=?");
			ps.setString(1, r.getName());
			ps.setString(2, r.getCategory());
			ps.setString(3, r.getPicture());
			ps.setInt(4, r.getScore());
			ps.setInt(5, r.getIdRecipe());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;				
	}	

	
	//à compléter
		@Override
		public void correctionRequestRecipe(Recipe r, Ingredient i) {
			// TODO Auto-generated method stub
			
		}

		//à compléter
		@Override
		public boolean isValideCorrection(Recipe r) {
			// TODO Auto-generated method stub
			return false;
		}

		//à compléter
		@Override
		public void recommandRecipe(Recipe r) {
			// TODO Auto-generated method stub
			
		}

		//à compléter
		@Override
		public void notAdviseRecipe(Recipe r) {
			// TODO Auto-generated method stub
			
		}

	//rechercher une recette par mot clé (validée)
	@Override
	public List<Recipe> getRecipeParMc(String mc) {
		List<Recipe> recipes = new ArrayList<Recipe>();
		try {
			PreparedStatement ps = conn.prepareStatement
					("SELECT * FROM recipe WHERE NAME LIKE ?");
			ps.setString(1, "%"+ mc + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Recipe r = new Recipe();
				r.setIdRecipe(rs.getInt("ID_RECIPE"));
				r.setName(rs.getString("NAME"));
				r.setCategory(rs.getString("CATEGORY"));
				r.setPicture(rs.getString("PICTURE"));
				r.setScore(rs.getInt("SCORE"));
		        //recipe
				recipes.add(r);
			}
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return recipes;
	}
	
	//chercher les recettes d'un ingredient (validée)
	@Override
	public List<Recipe> getRecipesByIngredient(Integer id_ingredient) {
		List<Recipe> recipes = new ArrayList<Recipe>();	
		try {
			PreparedStatement ps= conn.prepareStatement("SELECT * FROM  recipe r, ingredient i, recipe_ingredient ri "
					+ "WHERE i.id_ingredient = ri.ingredient_id_ingredient AND ri.recipe_id_recipe = r.id_recipe AND i.id_ingredient=?");
			ps.setInt(1, id_ingredient);;
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Recipe r = new Recipe();
				r.setIdRecipe(rs.getInt("ID_RECIPE"));
				r.setName(rs.getString("NAME"));
				r.setCategory(rs.getString("CATEGORY"));
				r.setPicture(rs.getString("PICTURE"));
				r.setScore(rs.getInt("SCORE"));
		        //recipe
				recipes.add(r);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return recipes;
}

	// corriger
    //chercher les recettes de plusieur ingredients
	@Override
	public List<Recipe> findRecipesByIngredients(List<Ingredient> ingredients) {
		  List<Recipe> recipes = new ArrayList<Recipe>(); 
		  			
			  List<Ingredient>ingrs = new ArrayList<Ingredient>();
			  
			  StringBuilder builder = new StringBuilder(); 
			  for ( int j=0; j<ingrs.size(); j++) {
			  builder.append("?,"); }
			 		   
		  try { PreparedStatement ps = conn.prepareStatement("SELECT * FROM  recipe r, ingredient i, recipe_ingredient ri "
					+ "WHERE i.id_ingredient = ri.ingredient_id_ingredient AND ri.recipe_id_recipe = r.id_recipe AND i.name IN ?"+builder);
		 			
		  
		  //utiliser Array pour récupérer la listes des ingredients donnés
				/*
				 * Array array = conn.createArrayOf("VARCHAR", ingrs.toArray()); ps.setArray(1,
				 * array);
				 */
		  
				  int index =0; 
				  for(Ingredient i : ingrs) { 
					  ps.setObject(index++, i.getName());
				  }
				 		  
		  ResultSet rs = ps.executeQuery();
		  while(rs.next()) { 
			  Recipe r = new Recipe();
		      r.setIdRecipe(rs.getInt("ID_RECIPE")); 
		      r.setName(rs.getString("NAME"));
		      r.setCategory(rs.getString("CATEGORY"));
		      r.setPicture(rs.getString("PICTURE")); 
		      r.setScore(rs.getInt("SCORE"));
		      recipes.add(r);
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return recipes;
	}

}

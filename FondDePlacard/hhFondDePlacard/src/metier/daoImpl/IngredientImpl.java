package metier.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.SingletonConnection;
import metier.entities.Ingredient;
import metier.entities.Recipe;
import metier.idao.IIngredient;


public class IngredientImpl implements IIngredient {

	 private Connection conn;
	  
	  public IngredientImpl(Connection conn) { 
		  this.conn = conn;
	  }
	 
	  //Mapping Objet Relationnel Classique sans framework !!!!
	
	//rajouter un Ingredient
	@Override
	public Ingredient addIngredient(Ingredient i) {
		try {
			PreparedStatement ps = conn.prepareStatement
					("INSERT INTO ingredient(NAME) VALUES(?)");
			ps.setString(1, i.getName());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}
	
	//rajouter un ingredient dans une recette
	public void addIngredientInRecipe(Recipe r, Ingredient i) {
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO recipe_ingredient(RECIPE_ID_RECIPE, INGREDIENT_ID_INGREDIENT) "
					+ "VALUES((SELECT ID_RECIPE FROM recipe WHERE name=?),"
					+ "(SELECT ID_INGREDIENT FROM ingredient WHERE name=?))");
		    ps.setObject(1, r.getName());
			ps.setObject(2, i.getName());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
	
	//chercher un ingredient par id 
	@Override
	public Ingredient getIngredientById(Integer id_ingredient) {
		Ingredient i =null;
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement
					("SELECT * FROM ingredient WHERE ID_INGREDIENT = ?");
			ps.setInt(1, id_ingredient);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				i = new Ingredient();
				i.setIdIngredient(rs.getInt("ID_INGREDIENT"));
				i.setName(rs.getString("NAME"));
				
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(i==null)throw new RuntimeException("recette "+id_ingredient+ "introuvable !");
		return i;
	}
	
	//chercher un ingredient par mot clé
	@Override
	public List<Ingredient> getInggredientParMc(String mc) {
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ingredient WHERE NAME LIKE ?");
			//remplacer ? par sa valeur
			ps.setString(1, "%"+ mc + "%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Ingredient i = new Ingredient();
				i.setIdIngredient(rs.getInt("ID_INGREDIENT"));
				i.setName(rs.getString("NAME"));
		        //recipe
				ingredients.add(i);
			}
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//if(i==null) throw new RuntimeException("Liste non trouvable !")
		return ingredients;
	}
	
	//chercher la liste des ingredients d'une recette 
	@Override
	public List<Ingredient> getIngredientsByRecipe(Integer id_recipe) {
			List<Ingredient> ingredients = new ArrayList<Ingredient>();
			try {
				PreparedStatement ps= conn.prepareStatement("SELECT * FROM ingredient i, recipe r, recipe_ingredient ri "
						+ "WHERE r.id_recipe = ri.recipe_id_recipe "
						+ "AND ri.ingredient_id_ingredient =i.id_ingredient AND id_recipe=?");
				ps.setInt(1, id_recipe);
				//ps.setObject(1,r.getName());
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Ingredient i = new Ingredient();
					i.setIdIngredient(rs.getInt("ID_INGREDIENT"));
					i.setName(rs.getString("NAME"));
			        //recipe
					ingredients.add(i);
					
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			return ingredients;
		}

	//Modifier un ingredient
	@Override
	public Ingredient updateIngredient(Ingredient i) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE ingredient set NAME=? "
					                                      + "WHERE id_ingredient=?");
			ps.setString(1, i.getName());
			ps.setInt(2, i.getIdIngredient());
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;				
	}
}

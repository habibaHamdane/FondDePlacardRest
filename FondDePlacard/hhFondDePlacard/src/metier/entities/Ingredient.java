package metier.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;

@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class Ingredient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idIngredient;	
	private String name;
	
	//@XmlTransient
	//@JsonIgnore
	private List<Recipe> recipes = new ArrayList<Recipe>();
		
	public Ingredient() {
		super();
	}
	
	public Ingredient(String name) {
		super();
		this.name = name;
	}
	
	public Ingredient(String name, List<Recipe> recipes) {
		super();
		this.name = name;
		this.recipes = recipes;
	}
	
	public Integer getIdIngredient() {
		return idIngredient;
	}
	
	public void setIdIngredient(Integer idIngredient) {
		this.idIngredient = idIngredient;
	}
		
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
}

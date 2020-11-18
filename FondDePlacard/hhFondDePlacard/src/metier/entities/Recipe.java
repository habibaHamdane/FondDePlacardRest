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
public class Recipe implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idRecipe;
	private String name;
	private String category;
	private String picture;
	private Integer Score;
	
	//@XmlTransient
	//@JsonIgnore
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	 
	public Recipe() {
		super();
	}

	public Recipe(String name, String category, String picture, Integer score) {
		super();
		this.name = name;
		this.category = category;
		this.picture = picture;
		Score = score;
	}

	public Recipe(String name, String category, String picture, Integer score, List<Ingredient> ingredients) {
		super();
		this.name = name;
		this.category = category;
		this.picture = picture;
		Score = score;
		this.ingredients = ingredients;
	}
	
	public Integer getIdRecipe() {
		return idRecipe;
	}

	public void setIdRecipe(Integer idRecipe) {
		this.idRecipe = idRecipe;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getScore() {
		return Score;
	}

	public void setScore(Integer score) {
		Score = score;
	}
	public List<Ingredient> getIngredients() { 
		return ingredients; 
		}
	
	public void setIngredients(List<Ingredient> ingredients) { 
		 this.ingredients = ingredients; 
		 }
	 

}

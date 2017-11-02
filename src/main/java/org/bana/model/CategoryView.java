package org.bana.model;

public class CategoryView {
	private String idCategory;
	
	private String categoryDescription;
	
	private String selected=null;

	public CategoryView() {
		// TODO Auto-generated constructor stub
	}

	public String getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

}

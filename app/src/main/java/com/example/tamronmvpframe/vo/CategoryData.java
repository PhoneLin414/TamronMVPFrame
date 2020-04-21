package com.example.tamronmvpframe.vo;

public class CategoryData {

    private int id;
    private String categoryName,categoryimg;

    public CategoryData(int id, String categoryName,String categoryimg) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryimg = categoryimg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryimg() {
        return categoryimg;
    }

    public void setCategoryimg(String categoryimg) {
        this.categoryimg = categoryimg;
    }
}

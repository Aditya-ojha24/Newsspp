package com.example.n;

public class CategoryRVModal {
    private String category;
    private String categorytoImageurl;

    public CategoryRVModal(String category, String categorytoImageurl) {
        this.category = category;
        this.categorytoImageurl = categorytoImageurl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategorytoImageurl() {
        return categorytoImageurl;
    }

    public void setCategorytoImageurl(String categorytoImageurl) {
        this.categorytoImageurl = categorytoImageurl;
    }
}

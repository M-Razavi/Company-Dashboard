package net.mahdirazavi.companydashboard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "product_category")
public class ProductCategory extends KeyEntity {

    @Column
    private String categoryName;

    @Column
    private int percentage;

    @Column
    private boolean bestCategory;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public boolean isBestCategory() {
        return bestCategory;
    }

    public void setBestCategory(boolean bestCategory) {
        this.bestCategory = bestCategory;
    }
}

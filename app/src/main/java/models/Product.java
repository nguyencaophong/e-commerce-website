package models;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.List;

public class Product implements Serializable {
    private int resourceId;
    private String name;
    private String price;
    private List<String> description;
    private List<String> infoConfiguration;

    public Product(int resourceId, String name, String price, List<String> description, List<String> infoConfiguration) {
        this.resourceId = resourceId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.infoConfiguration = infoConfiguration;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public List<String> getInfoConfiguration() {
        return infoConfiguration;
    }

    public void setInfoConfiguration(List<String> infoConfiguration) {
        this.infoConfiguration = infoConfiguration;
    }
}

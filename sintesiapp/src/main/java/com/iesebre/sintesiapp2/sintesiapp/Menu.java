package com.iesebre.sintesiapp2.sintesiapp;

/**
 * Created by jordi on 11/06/14.
 */
public class Menu {
    private String image;
    private String name;
    private String description;
    private String m_type;
    private String price;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getM_type() {
        return m_type;
    }

    public void setM_type(String m_type) {
        this.m_type = m_type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "Menus {" +
                "image=' "+image + '\''+
                ", name= '"+name+ '\''+
                ", descripton= '"+description+ '\''+
                ", type= '"+m_type+ '\''+
                ", price= '"+price+ '\''+
                '}';

    }
}

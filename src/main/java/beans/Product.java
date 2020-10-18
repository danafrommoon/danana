package beans;

import java.util.ArrayList;
import java.util.Collections;
public class Product implements Comparable<Product> {
    private int id;
    private String name;
    private String price;
    private String category;
    private String featured;
    private String image;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getFeatured() {
        return featured;
    }
    public void setFeatured(String featured) {
        this.featured = featured;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", featured="
                + featured + ", image=" + image + "]";
    }
    //checking products in cart
    public boolean check(ArrayList<String> cartlist, String id2) {
        for(String id : cartlist) {
            if(id.equals(id2))
                return true;
        }
        return false;
    }
    //removing products in cart
    public ArrayList<String> remove(ArrayList<String> cartlist, String id) {
        for(String cid : cartlist) {
            if(cid.equals(id)) {
                cartlist.remove(cid);
                break;
            }

        }

        return cartlist;
    }
    //sorting products in main page with filter: Low to High
    public ArrayList<Product> lowtohigh(ArrayList<Product> list) {
        Collections.sort(list);
        return list;
    }
    @Override
    public int compareTo(Product p) {

        return Integer.parseInt(this.price) - Integer.parseInt(p.price);
    }
    //sorting products in main page with filter: High to Low
    public ArrayList<Product> hightolow(ArrayList<Product> list) {
        Collections.sort(list, new Temp());
        return list;
    }

}





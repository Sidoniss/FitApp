package pl.example.fitapp.ui.recipes;

public class Recipe {
    private String name;
    private String time;
    private String imageUrl;
    private String description;
    private String recipetxt;

    public Recipe(String name, String time, String imageUrl, String description, String recipetxt) {
        this.name = name;
        this.time = time;
        this.imageUrl = imageUrl;
        this.description = description;
        this.recipetxt = recipetxt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecipetxt() {
        return recipetxt;
    }

    public void setRecipetxt(String recipetxt) {
        this.recipetxt = recipetxt;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", recipetxt=" + recipetxt + '\'' +
                '}';
    }
}

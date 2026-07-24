import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Categories implements Serializable {

    @Serial
    private static final long serialVersionUID = 8L;

    private final List<Category> categories;

    public Categories(){
        this.categories = new ArrayList<>();
    }

    public Category getCategory(String name){
        for(Category c : this.categories){
            if(c.getName().equals(name.toUpperCase())){
                return c;
            }
        }
        return null;
    }

    public void createNewCategory(String name, String amount){
        this.categories.add(new Category(name, new BigDecimal(amount)));
    }

    public void deleteCategory(String name){
        this.categories.removeIf(c -> c.getName().equals(name));
    }

    public List<Category> getCategories(){
        return new ArrayList<>(this.categories);
    }
}

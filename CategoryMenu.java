import java.util.HashMap;
import java.util.Map;

public class CategoryMenu extends UI{

    private final Map<String, Runnable> commands = new HashMap<>();

    public CategoryMenu(Categories list) {
        super(list);
        commands.put("o", this::openCategory);
        commands.put("a", this::addCategory);
        commands.put("r", this::removeCategory);
        commands.put("v", this::displayCategories);
    }

    @Override
    public void start(){
        while(true){
            System.out.println("----Category Menu----");
            System.out.println("(O)pen category\n(A)dd category\n(R)emove category\n(V)iew categories\n(B)ack to previous menu");

            String command = scanner.nextLine().trim().toLowerCase();

            if(command.equals("b")){
                return;
            }

            Runnable action = commands.get(command);
            if(action != null){
                action.run();
            } else {
                System.out.println("Unknown command");
            }
        }
    }

    public void addCategory(){
        System.out.println("Enter name of the category to add");
        String name = scanner.nextLine().toUpperCase();
        System.out.println("Enter amount for initial funds");
        String initialFunds = scanner.nextLine();
        this.list.createNewCategory(name, initialFunds);
    }

    public void removeCategory(){
        System.out.println("Enter name of the category to remove");
        String name = scanner.nextLine().toUpperCase();
        this.list.deleteCategory(name);
    }

    public void openCategory(){
        System.out.println("Enter name of category to open");
        String name = scanner.nextLine().toUpperCase();
        Category category = list.getCategory(name);
        if(category == null){
            System.out.println("Category not found");
            return;
        }
        new CategoryActionMenu(this.list, this.list.getCategory(name)).start();
    }

    public void displayCategories(){
        for(Category c : this.list.getCategories()){
            System.out.println(c);
        }
    }
}

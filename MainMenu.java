import java.util.HashMap;
import java.util.Map;

public class MainMenu extends UI{

    private final Map<String, Runnable> commands = new HashMap<>();

    public MainMenu(Categories list){
        super(list);
        commands.put("c", new CategoryMenu(list)::start);
        commands.put("q", () -> System.exit(0));
    }

    @Override
    public void start(){

        while(true){
            System.out.println("----Finance Tracker 2.0----");
            System.out.println("Type in a command");
            System.out.println("Letters inside () are commands");
            System.out.println("(C)ategory Menu\n(Q)uit program");
            String command = scanner.nextLine().trim().toLowerCase();
            Runnable action = commands.get(command);
            if(action != null){
                action.run();
            } else {
                System.out.println("Unknown command");
            }
        }
    }
}

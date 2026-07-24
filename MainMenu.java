import java.util.HashMap;
import java.util.Map;

public class MainMenu extends UI {

    private final Map<String, Runnable> commands = new HashMap<>();

    public MainMenu(Categories list) {
        super(list);
        commands.put("c", new CategoryMenu(list)::start);
        commands.put("s", this::saveData);
        commands.put("q", this::shutdown);
    }

    @Override
    public void start() {

        while (true) {
            System.out.println("----Finance Tracker 2.0----");
            System.out.println("Type in a command");
            System.out.println("Letters inside () are commands");
            System.out.println("(C)ategory Menu\n(S)ave data\n(Q)uit program");
            String command = scanner.nextLine().trim().toLowerCase();
            Runnable action = commands.get(command);
            if (action != null) {
                action.run();
            } else {
                System.out.println("Unknown command");
            }
        }
    }

    public void saveData(){
        FileIO.saveData(list);
    }

    public void shutdown() {
        scanner.close();
        System.exit(0);
    }
}

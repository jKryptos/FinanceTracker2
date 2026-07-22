import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CategoryActionMenu extends UI{

    private final Category category;
    private final Map<String, Runnable> commands = new HashMap<>();

    public CategoryActionMenu(Categories list, Category category){
        super(list);
        this.category = category;
        this.commands.put("d", this::deposit);
        this.commands.put("w", this::withdraw);
        this.commands.put("t", this::showHistory);
    }

    @Override
    public void start(){
        while(true){
            System.out.println("----" + this.category.getName() + "----");
            System.out.println("Funds: $" + this.category.getFunds());
            System.out.println("(D)eposit\n(W)ithdraw\n(T)ransaction history\n(B)ack to previous menu");

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

    public void deposit(){
        try{
            System.out.println("Enter amount to deposit");
            String amount = scanner.nextLine();
            System.out.println("Enter description of the deposit");
            String description = scanner.nextLine();
            category.deposit(new BigDecimal(amount), description);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void withdraw(){
        try{
            System.out.println("Enter amount to withdraw");
            String amount = scanner.nextLine();
            System.out.println("Enter description of the withdrawal");
            String description = scanner.nextLine();
            category.withdraw(new BigDecimal(amount), description);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void showHistory(){
        this.category.getHistory();
    }
}

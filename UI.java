import java.util.Scanner;

public class UI{

    protected Categories list;
    protected Scanner scanner;

    public UI(Categories list){
        this.list = list;
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        MainMenu m = new MainMenu(list);
        m.start();
    }
}

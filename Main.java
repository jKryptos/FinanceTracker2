public class Main {
    public static void main(String[] args) {

        Categories list = FileIO.loadData();

        if(list.getCategories().isEmpty()) {
            Categories newList = new Categories();
            UI ui = new UI(newList);
            ui.start();
        } else {
            UI ui = new UI(list);
            ui.start();
        }
    }
}
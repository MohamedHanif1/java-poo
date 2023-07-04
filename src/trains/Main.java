package trains;

public class Main {

    public static void main(String[] args) {

        Train t = new Train("12345", new Personnel("12035m", "Alaoui", "Ali"), TypeTrain.PassagersMarchandise);
        try {
            t.ajouterWagonMarchandise("2536", "pomme de terre", 10);
            t.ajouterWagonMarchandise("2537", "orange", 13);
            t.ajouterWagonPassagers("2538", "Passagers", 40);
            t.ajouterWagonMarchandise("2539", "vêtements", 20);
        } catch (TrainWagonIncompatiblesException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(t.toString());


    }

}

package trains;

import java.util.ArrayList;

public class Train {
    private String code;
    private Personnel conducteur;
    private TypeTrain type;
    private int longueur;
    private ArrayList<Wagon> wagons;

    public Train(String code, Personnel conducteur, TypeTrain type) {
        this.code = code;
        this.conducteur = new Personnel(conducteur);
        this.type = type;
        this.longueur = 0;
        this.wagons = new ArrayList<>();
    }

    public Train(String code, Personnel conducteur, TypeTrain type, ArrayList<Wagon> wagons) {
        this.code = code;
        this.conducteur = new Personnel(conducteur);
        this.type = type;
        this.longueur = wagons.size();
        this.wagons = new ArrayList<>(wagons);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Personnel getConducteur() {
        return conducteur;
    }

    public void setConducteur(Personnel conducteur) {
        this.conducteur = conducteur;
    }

    public TypeTrain getType() {
        return type;
    }

    public void setType(TypeTrain type) {
        this.type = type;
    }

    public int getLongueur() {
        return longueur;
    }

    public ArrayList<Wagon> getWagons() {
        return wagons;
    }

    public void setWagons(ArrayList<Wagon> wagons) {
        this.wagons = wagons;
	this.longueur=wagons.size();
    }

    public void ajouterWagonPassagers(String code, String description, int nombrePassagers) throws TrainWagonIncompatiblesException {
        if ((this.type == TypeTrain.marchandise) || (this.type == TypeTrain.Minerai)) {
            throw new TrainWagonIncompatiblesException("Type wagon non autorisé pour ce type de train");
        }
        wagons.add(new WagonPassagers(code, description, nombrePassagers));
        this.longueur++;
    }

    public void ajouterWagonMinerai(String code, String description, float tonnage) throws TrainWagonIncompatiblesException {
        if (this.type != TypeTrain.Minerai) {
            throw new TrainWagonIncompatiblesException("Type wagon non autorisé pour ce type de train");
        }
        wagons.add(new WagonMinerai(code, description, tonnage));
        this.longueur++;
    }

    public void ajouterWagonMarchandise(String code, String description, float volume) throws TrainWagonIncompatiblesException {
        if ((this.type == TypeTrain.Minerai) || (this.type == TypeTrain.passagers)) {
            throw new TrainWagonIncompatiblesException("Type wagon non autorisé pour ce type de train");
        }
        wagons.add(new WagonMarchandise(code, description, volume));
        this.longueur++;
    }
    //tr.ajouterWagon(new WagonMinerai(.....));
    public void ajouterWagon(Wagon wagon) throws TrainWagonIncompatiblesException {
        if (((this.type == TypeTrain.Minerai) && (wagon instanceof WagonMinerai)) || ((this.type == TypeTrain.marchandise) && (wagon instanceof WagonMarchandise)) || ((this.type == TypeTrain.PassagersMarchandise) && ((wagon instanceof WagonMarchandise) || (wagon instanceof WagonPassagers)))) {
            wagons.add(wagon);
            this.longueur++;
        } else {
            throw new TrainWagonIncompatiblesException("Type wagon non autorisé pour ce type de train");
        }
    }

    public boolean supprimerWagon(String code) {
        boolean supprimé = false;
        for (Wagon w : wagons) {
            if (w.getCode().equals(code)) {
                wagons.remove(w);
                supprimé = true;
                this.longueur--;
                break;
            }
        }
        return supprimé;
    }

    @Override
    public String toString() {
        return "Train{" + "code=" + code + ", conducteur=" + conducteur + ", type=" + type + ", longueur=" + longueur + ", wagons=" + wagons + '}';
    }

  
    }




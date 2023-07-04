
package trains;

public class WagonMarchandise extends Wagon{
    private final static float volumeMax=72; // en mètre cube;
    private float volume;
    private static int nombreWagonsMarchandise=0;

    public WagonMarchandise(String code, String description,float volume) {
        super(code, description);
        this.volume = volume;
        nombreWagonsMarchandise++;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public static float getVolumeMax() {
        return volumeMax;
    }

    public static int getNombreWagonsMarchandise() {
        return nombreWagonsMarchandise;
    }
    

    @Override
    public String toString() {
        return "WagonMarchandise{" +super.toString()+ "volumeMax=" + volumeMax + " volume=" + volume+'}';
    }

    
    
}

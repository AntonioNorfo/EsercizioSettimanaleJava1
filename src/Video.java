public class Video extends ElementoMultimediale implements Riproducibile {
    private int durata;
    private int volume;
    private int luminosita;

    // Costruttore per inizializzare il titolo, la durata, il volume e la luminosità

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo); // Chiamo il costruttore della classe astratta ElementoMultimediale

        if (durata <= 0 || volume <= 0 || luminosita <= 0) {
            System.out.println("Durata, volume e luminosità devono essere positivi");
        }
        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;
    }

    public void abbassaVolume() {
        if (volume > 1) {
            volume--;
        } else {
            System.out.println("Il volume è già al minimo.");
        }
    }

    public void alzaVolume() {
        volume++;
    }

    public void diminuisciLuminosita() {
        if (luminosita > 1) {
            luminosita--;
        } else {
            System.out.println("La luminosità è già al minimo.");
        }
    }


    public void aumentaLuminosita() {
        luminosita++;
    }


    @Override
    public void play() {

        for (int i = 0; i < durata; i++) {

            System.out.println(titolo + " " + "!".repeat(volume) + " " + "*".repeat(luminosita));
        }
    }

    public int getDurata() {
        return durata;
    }

    public int getVolume() {
        return volume;
    }

    public int getLuminosita() {
        return luminosita;
    }
}

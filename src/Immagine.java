public class Immagine extends ElementoMultimediale {
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    public void aumentaLuminosita() {
        luminosita++;
    }

    public void diminuisciLuminosita() {
        luminosita--;
    }

    public void show() {
        System.out.println(titolo + " " + "*".repeat(luminosita));
    }
}

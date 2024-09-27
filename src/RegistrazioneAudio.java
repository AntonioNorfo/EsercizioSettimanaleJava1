public class RegistrazioneAudio extends ElementoMultimediale implements Riproducibile {
    private int durata;
    private int volume;



    public RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo);

        if (durata <= 0 || volume <= 0) {
            throw new IllegalArgumentException("Durata e volume devono essere positivi");
        }

        this.durata = durata;
        this.volume = volume;
    }


    public void abbassaVolume() {
        if (volume > 1) {
            volume--;
        } else {
            System.out.println("Non puoi abbassare ancora il volume");
        }
    }


    public void alzaVolume() {
        volume++;
    }


    @Override // usando il polimorfismo , sfrutto il metodo play richiamatomi dall interfaccia.

    public void play() {

        for (int i = 0; i < durata; i++) {
        System.out.println(titolo + " " + "!".repeat(volume));
        }
    }


    public int getDurata() {
        return durata;
    }

    public int getVolume() {
        return volume;
    }
}

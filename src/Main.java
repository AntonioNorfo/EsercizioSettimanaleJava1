public class Main {
    public static void main(String[] args) {

        // Creo un oggetto RegistrazioneAudio

        RegistrazioneAudio audio = new RegistrazioneAudio("Queen – Bohemian Rhapsody ", 6, 10); // metterei questa canzone ad audio ++++++++++++++

        // Riproduce la registrazione audio

        audio.play();

        // Abbassa il volume e riproduce di nuovo grazie ad audio.play

        audio.abbassaVolume();
        audio.play();

        // Alza il volume e riproduce di nuovo grazie ad audio.play

        audio.alzaVolume();
        audio.play();
    }
}

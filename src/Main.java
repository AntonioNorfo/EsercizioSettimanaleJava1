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


        Video video = new Video("Film", 5, 4, 15);

        // Riproduce il video
        video.play();

        // Abbassa il volume e riproduce di nuovo
        video.abbassaVolume();
        video.play();

        // Aumenta la luminosità e riproduce di nuovo
        video.aumentaLuminosita();
        video.play();



    }
}

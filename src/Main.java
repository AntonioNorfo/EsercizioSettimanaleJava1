import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

        // Lettura degli elementi multimediali
        for (int i = 0; i < 5; i++) {
            int scelta = 0;
            boolean inputValido = false;

            // Chiedi il tipo di elemento multimediale finché non viene inserito un numero valido
            while (!inputValido) {
                try {
                    System.out.println("Inserisci il tipo di elemento multimediale (1 = Immagine, 2 = Audio, 3 = Video): ");
                    String inputScelta = scanner.nextLine(); // Legge come stringa
                    scelta = Integer.parseInt(inputScelta);  // Converte in intero

                    if (scelta < 1 || scelta > 3) {
                        System.out.println("Scelta non valida. Inserisci un numero tra 1 e 3.");
                    } else {
                        inputValido = true; // Input corretto, esci dal ciclo
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Errore: devi inserire un numero valido.");
                }
            }

            System.out.println("Inserisci il titolo: ");
            String titolo = scanner.nextLine();

            switch (scelta) {
                case 1: // Immagine
                    int luminosita = leggiInteroDaInput("Inserisci la luminosità iniziale: ", scanner);
                    elementi[i] = new Immagine(titolo, luminosita);
                    break;
                case 2: // Audio
                    int durataAudio = leggiInteroDaInput("Inserisci la durata: ", scanner);
                    int volumeAudio = leggiInteroDaInput("Inserisci il volume: ", scanner);
                    elementi[i] = new RegistrazioneAudio(titolo, durataAudio, volumeAudio);
                    break;
                case 3: // Video
                    int durataVideo = leggiInteroDaInput("Inserisci la durata: ", scanner);
                    int volumeVideo = leggiInteroDaInput("Inserisci il volume: ", scanner);
                    int luminositaVideo = leggiInteroDaInput("Inserisci la luminosità: ", scanner);
                    elementi[i] = new Video(titolo, durataVideo, volumeVideo, luminositaVideo);
                    break;
                default:
                    System.out.println("Errore inatteso.");
            }
        }

        // Ciclo di esecuzione
        int scelta;
        do {
            scelta = leggiInteroDaInput("Quale elemento vuoi eseguire? (1-5, 0 per terminare): ", scanner);
            if (scelta >= 1 && scelta <= 5) {
                ElementoMultimediale elemento = elementi[scelta - 1];
                if (elemento instanceof Riproducibile) {
                    ((Riproducibile) elemento).play();
                } else if (elemento instanceof Immagine) {
                    ((Immagine) elemento).show();
                }
            } else if (scelta != 0) {
                System.out.println("Scelta non valida.");
            }
        } while (scelta != 0);

        System.out.println("Lettore multimediale terminato.");
        scanner.close();
    }

    // Metodo per leggere e convertire un input intero
    public static int leggiInteroDaInput(String messaggio, Scanner scanner) {
        int numero = 0;
        boolean inputValido = false;

        while (!inputValido) {
            System.out.println(messaggio);
            String input = scanner.nextLine();
            try {
                numero = Integer.parseInt(input); // Converte l'input in intero
                inputValido = true; // Esci dal ciclo se l'input è corretto
            } catch (NumberFormatException e) {
                System.out.println("Errore: devi inserire un numero valido.");
            }
        }
        return numero;
    }
}

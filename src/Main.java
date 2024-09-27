import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] elementi = new ElementoMultimediale[5]; // creo l array di elementi multimediali

        for (int i = 0; i < 5; i++) {

            int scelta = 0;
            boolean inputValido = false;

            while (!inputValido) {
                try {
                    System.out.println("Inserisci il tipo di elemento multimediale (1 = Immagine, 2 = Audio, 3 = Video): ");
                    String inputScelta = scanner.nextLine();
                    scelta = Integer.parseInt(inputScelta);

                    if (scelta < 1 || scelta > 3) {
                        System.out.println("Scelta non valida. Inserisci un numero tra 1 e 3.");
                    } else {
                        inputValido = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Errore: devi inserire un numero valido.");
                }


            }

            System.out.println("Inserisci il titolo: ");
            String titolo = scanner.nextLine();

            switch (scelta) {
                case 1:
                    int luminosita = leggiInteroDaInput("Inserisci la luminosità iniziale: ", scanner);
                    elementi[i] = new Immagine(titolo, luminosita);
                    break;
                case 2:
                    int durataAudio = leggiInteroDaInput("Inserisci la durata: ", scanner);
                    int volumeAudio = leggiInteroDaInput("Inserisci il volume: ", scanner);
                    elementi[i] = new RegistrazioneAudio(titolo, durataAudio, volumeAudio);
                    break;
                case 3:
                    int durataVideo = leggiInteroDaInput("Inserisci la durata: ", scanner);
                    int volumeVideo = leggiInteroDaInput("Inserisci il volume: ", scanner);
                    int luminositaVideo = leggiInteroDaInput("Inserisci la luminosità: ", scanner);
                    elementi[i] = new Video(titolo, durataVideo, volumeVideo, luminositaVideo);
                    break;
                default:
                    System.out.println("Errore inatteso.");
            }
        }

        int scelta;
        do {
            scelta = leggiInteroDaInput("Quale elemento vuoi eseguire? (1-5, 0 per terminare l esecuzione): ", scanner);
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

    public static int leggiInteroDaInput(String messaggio, Scanner scanner) {
        int numero = 0;
        boolean inputValido = false;

        while (!inputValido) {
            System.out.println(messaggio);
            String input = scanner.nextLine();
            try {
                numero = Integer.parseInt(input);
                inputValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Errore: devi inserire un numero valido.");
            }
        }
        return numero;
    }
}

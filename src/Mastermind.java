import java.util.Random;
import java.util.Scanner;

public class Mastermind {

    int stopHetSpel = 0;
    int aantalLettersJuistePlek = 0;
    int aantalLettersOnjuistePlek = 0;
    int aantalPogingen = 1;

    Scanner scanner = new Scanner(System.in);

    void gaanMetDieBanaan() {
        System.out.println("Hoi! Wij gaan Mastermind spelen. Laten we elkaar wat beter leren kennen. Ik heet Computer. Hoe heet jij?");
        String naam = scanner.nextLine();
        Speler speler = new Speler(naam);

        // Eerst de spelregels kort uitleggen.
        System.out.println("Welkom, " + speler.getNaamVanSpeler() + "! Het is de bedoeling dat je straks een reeks van 4 kleine karakters van a t/m f invult. Deze reeks noem ik 'code'.");
        System.out.println("Dit zou bijvoorbeeld 'abcd' kunnen zijn of 'effa'. Druk op 'q' om het spel te verlaten.");
        System.out.println("Je hebt gewonnen zodra je de code hebt geraden. Ik houd het aantal pogingen voor je bij. Gewoon, omdat het kan.");
        System.out.println("Klaar voor de start? Toets 'interim-hottentottententententoonstellingsterreincoördinatoropleidingsassistent' in of gewoon 'ja' om te starten.");

        for (int indexKlaarVoorDeStart = 0; indexKlaarVoorDeStart < 10; indexKlaarVoorDeStart++) {
            String volgendeStap = scanner.nextLine();
            if (volgendeStap.equals("Ja") || volgendeStap.equals("ja") || volgendeStap.equals("interim-hottentottententententoonstellingsterreincoördinatoropleidingsassistent")) {
                System.out.println("Let's go, " + speler.getNaamVanSpeler() + "!");
                break;
            } else {
                System.out.println("Zeg nou maar gewoon 'ja', " + speler.getNaamVanSpeler() + " ;)");
            }
        }

        Random random = new Random();
        int[] intArray = new int[]{97, 98, 99, 100, 101, 102};
        char[] charArray = new char[4];

        for (int index = 0; index < 4; index++) {
            int willekeurigElement = random.nextInt(intArray.length);
            int willekeurig = (intArray[willekeurigElement]);
            char ch = (char) willekeurig;
            charArray[index] = ch;
        }
        String code = new String(charArray);

        while (stopHetSpel == 0) {
            System.out.println("Voer alsjeblieft een code in");
            String antwoord = scanner.nextLine();
            if (antwoord.length() != 4) {
                System.out.println("Je code moet bestaan uit 4 karakters, van a t/m f.");
            } else if (antwoord.equals("q")) {
                System.out.println("Ik stop het spel, tot de volgende keer!");
                stopHetSpel++;
            } else if (antwoord.equals(code)) {
                System.out.println("Je hebt gewonnen, " + naam + "! Ik heb het even nagekeken en zag dat je " + aantalPogingen + " pogingen nodig had om de juiste code te raden. Gefeliciteerd!");
                break;
            } else {
                for (int index = 0; index < 4; index++) {

                    if (antwoord.contains(String.valueOf(code.charAt(index)))) { // beoordeel of de karakter voorkomt in de code
                        if (antwoord.charAt(index) == code.charAt(index)) { // zo ja, ga verder en bekijk of de karakters identiek zijn op dezelfde locaties
                            aantalLettersJuistePlek++;
                        } else { // gebruikt in het geval de karakter wel voorkomt in de code, maar niet op de juiste locatie staat
                            aantalLettersOnjuistePlek++;
                        }
                    }
                }
                aantalPogingen++;
            }
            System.out.println("Aantal correcte letters dat op de juiste plaats staat: " + aantalLettersJuistePlek);
            aantalLettersJuistePlek = 0;
            System.out.println("Aantal correcte letters dat niet op de juiste plaats staat: " + aantalLettersOnjuistePlek);
            aantalLettersOnjuistePlek = 0;
        }
    }
}

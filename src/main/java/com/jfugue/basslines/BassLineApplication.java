package com.jfugue.basslines;

import com.jfugue.basslines.generator.BassLineGenerator;
import com.jfugue.basslines.model.Bar;
import org.jfugue.player.Player;
import org.jfugue.theory.Note;

import java.util.List;
import java.util.stream.Collectors;

import static com.jfugue.basslines.util.ParseUtil.getBassLineGenerator;
import static com.jfugue.basslines.util.ParseUtil.parseSheet;

public class BassLineApplication {

    private static Player player = new Player();

    private static List<String> getBasslineForBar(Bar bar) throws Exception {
        System.out.println("Getting a bass line for the bar " + bar + "...");
        BassLineGenerator bassLineGenerator = getBassLineGenerator(bar);
        System.out.println("Bassline generator: " + bassLineGenerator.getClass().getName());
        List<Note> notes = bassLineGenerator.bassline(bar);

        return notes.stream().map(note -> note.toString() + " ").collect(Collectors.toList());
    }

    private static void playBassline(String sheet) throws Exception {
        StringBuilder stringBuilder = new StringBuilder("V0 I[ELECTRIC_BASS_FINGER] ");

        Bar[] bars = parseSheet(sheet);

        for (Bar bar : bars) {
            List<String> barBassline = getBasslineForBar(bar);

            for (String note : barBassline) {
                stringBuilder.append(note);
            }

            stringBuilder.append(" | ");
        }

        System.out.println("Final bass line: " + stringBuilder.toString());
        player.play(stringBuilder.toString());
    }


    public static void main(String[] args) throws Exception {
        String sheet = "EMIN7 ADOM7 | Dmin7 GDOM7";

        try {
            playBassline(sheet);
        } catch (Exception e) {
            System.err.println("Failed to play a bass line for sheet '" + sheet + "': " + e);
        }
    }

}

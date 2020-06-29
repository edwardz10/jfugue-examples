package com.jfugue.basslines;

import org.jfugue.player.Player;
import org.jfugue.theory.Chord;
import org.jfugue.theory.Note;

import java.util.Arrays;

public class BassLine {

    private static Player player = new Player();

    private static String[] getBasslineForMeasure(Measure measure) {
        System.out.println("Getting a bass line for the measure " + measure + "...");
        Note[] notes = measure.getChords()[0].getNotes();
        String[] bassNotes = new String[notes.length];

        for (int i = 0; i < notes.length; i++) {
            bassNotes[i] = notes[i] + "3q ";
        }

        return bassNotes;
    }

    private static Measure[] parseSheet(String sheet) {
        String[] measuresString = sheet.split(" \\| ");

        Measure[] measures = new Measure[measuresString.length];

        for (int i = 0; i < measuresString.length; i++) {
            String[] chordsString = measuresString[i].split(" ");
            Chord[] chords = new Chord[chordsString.length];

            for (int j = 0; j < chords.length; j++) {
                chords[j] = new Chord(chordsString[j]);
            }

            String[] nextChordsString = (i == measuresString.length - 1) ? null : measuresString[i + 1].split(" ");

            Note nextNote = (nextChordsString == null) ? null : new Chord(nextChordsString[0]).getBassNote();
            measures[i] = new Measure(chords, nextNote);
        }

        return measures;
    }

    private static void playBassline(String sheet) {
        StringBuilder stringBuilder = new StringBuilder("V0 I[ELECTRIC_BASS_FINGER] ");

        Measure[] measures = parseSheet(sheet);

        for (Measure measure : measures) {
            String[] notes = getBasslineForMeasure(measure);

            for (String note : notes) {
                stringBuilder.append(note);
            }
        }

        System.out.println("Final bass line: " + stringBuilder.toString());
        player.play(stringBuilder.toString());
    }


    public static void main(String[] args) {
        playBassline("Cmaj7 | Amin7 | Dmin7 | Gdom7");
    }

}

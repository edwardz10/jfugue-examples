package com.jfugue.basslines;

import org.jfugue.player.Player;
import org.jfugue.theory.Chord;
import org.jfugue.theory.Note;

public class BassLine {

    private static Player player = new Player();

    private static String[] getBasslineForBar(Bar bar) {
        System.out.println("Getting a bass line for the bar " + bar + "...");
        Note[] notes = bar.getChords()[0].getNotes();
        String[] bassNotes = new String[notes.length];

        for (int i = 0; i < notes.length; i++) {
            bassNotes[i] = notes[i] + "3q ";
        }

        return bassNotes;
    }

    private static Bar[] parseSheet(String sheet) {
        String[] barsString = sheet.split(" \\| ");

        Bar[] bars = new Bar[barsString.length];

        for (int i = 0; i < barsString.length; i++) {
            String[] chordsString = barsString[i].split(" ");
            Chord[] chords = new Chord[chordsString.length];

            for (int j = 0; j < chords.length; j++) {
                chords[j] = new Chord(chordsString[j]);
            }

            String[] nextChordsString = (i == barsString.length - 1) ? null : barsString[i + 1].split(" ");

            Note nextNote = (nextChordsString == null) ? null : new Chord(nextChordsString[0]).getBassNote();
            bars[i] = new Bar(chords, nextNote);
        }

        return bars;
    }

    private static void playBassline(String sheet) {
        StringBuilder stringBuilder = new StringBuilder("V0 I[ELECTRIC_BASS_FINGER] ");

        Bar[] bars = parseSheet(sheet);

        for (Bar bar : bars) {
            String[] notes = getBasslineForBar(bar);

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

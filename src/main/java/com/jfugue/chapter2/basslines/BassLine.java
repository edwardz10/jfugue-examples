package com.jfugue.chapter2.basslines;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jfugue.player.Player;
import org.jfugue.theory.Chord;
import org.jfugue.theory.Note;

public class BassLine {

    private static Player player = new Player();

    private static String getBassNotes(Chord chord, Chord nextChord) {
        System.out.println("Chord: " + chord + ", next chord: " + nextChord);

        StringBuilder stringBuilder = new StringBuilder();

        for (Note note : chord.getNotes()) {
            stringBuilder.append(note + "3q ");
        }

        stringBuilder.append("|  ");

        return stringBuilder.toString();
    }

    private static void playBassline(String chordSequenceString) {
        StringBuilder stringBuilder = new StringBuilder("V0 I[ELECTRIC_BASS_FINGER] ");

        String[] chordStrings = chordSequenceString.split("\\|");

        for (int i = 0; i < chordStrings.length; i++) {
            Chord chord = new Chord(chordStrings[i].trim());
            Chord nextChord = (i == chordStrings.length - 1) ? null : new Chord(chordStrings[i + 1].trim());

            stringBuilder.append(getBassNotes(chord, nextChord));
        }

        String sheet = stringBuilder.toString();
        System.out.println("Sheet: " + sheet);
        player.play(sheet);
    }


    public static void main(String[] args) {
        playBassline("Cmaj7 | Amin7 | Dmin7 | Gdom7");
    }

}

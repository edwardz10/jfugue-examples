package com.jfugue.chapter2.staccato;

import org.jfugue.player.Player;
import org.jfugue.theory.Chord;
import org.jfugue.theory.Note;

public class Chords {

    private static Player player = new Player();

    private static void playChord(String chordString) {
        player.play(chordString + "w");
        Chord chord = new Chord(chordString);

        for (Note note : chord.getNotes()) {
            System.out.print(note + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        String[] chords = {"Cmaj7", "Cmin7", "Cdom7", "Cdim7"};

        for (String chord : chords) {
            playChord(chord);
        }
    }
}

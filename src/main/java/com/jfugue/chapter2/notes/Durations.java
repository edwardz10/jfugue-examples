package com.jfugue.chapter2.notes;

import org.jfugue.player.Player;

public class Durations {
    public static void main(String[] args) {
        Player player = new Player();
        player.play("Aw"); // A5 whole note
        player.play("E7h"); // E7 half note
        player.play("60wq"); // Middle-C whole+quarter note
        player.play("60w5"); // Middle-C, 5 whole durations
        player.play("G8i."); // G8 dotted-eighth note
        player.play("Bb6/0.5"); // B-flat, 6th octave, half note
        player.play("C7maj^^q"); // C-major chord, 2nd inversion,
                                // 7th octave, quarter note
    }

}

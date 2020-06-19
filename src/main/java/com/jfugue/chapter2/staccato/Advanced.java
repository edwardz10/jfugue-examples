package com.jfugue.chapter2.staccato;

import org.jfugue.player.Player;

public class Advanced {
    public static void main(String[] args) {
        Player player = new Player();
        player.play("C");
        player.play("C7h");
        player.play("C5maj7w");
        player.play("G5h+B5h+C6q_D6q");
        player.play("G5q G5q F5q E5q D5h");
        player.play("T[Allegro] V0 I0 G6q A5q V1 A5q G6q");
        player.play("V0 Cmajw V1 I[Flute] G4q E4q C4q E4q");
        player.play("T120 V0 I[Piano] G5q G5q V9 [Hand_Clap]q Rq");
    }
}

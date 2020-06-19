package com.jfugue.chapter2.voices;

import org.jfugue.player.Player;

public class SimpleVoices {
    public static void main(String[] args) {
        Player player = new Player();
        player.play("V0 I[Piano] C D E V1 I[Flute] G A B");
    }
}

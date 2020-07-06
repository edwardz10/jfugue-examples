package com.jfugue.basslines.generator;

import com.jfugue.basslines.model.Bar;
import org.jfugue.theory.Note;

public class ArpeggioBassLineGenerator implements BassLineGenerator {

    private ArpeggioBassLineGenerator() {}

    public static ArpeggioBassLineGenerator INSTANCE;

    public Note[] bassline(Bar bar) {
        return bar.getChords()[0].getNotes();
    }
}

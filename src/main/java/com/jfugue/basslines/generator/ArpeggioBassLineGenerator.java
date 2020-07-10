package com.jfugue.basslines.generator;

import com.jfugue.basslines.model.Bar;

public class ArpeggioBassLineGenerator extends BaseBassLineGenerator {

    private ArpeggioBassLineGenerator() {}

    public static ArpeggioBassLineGenerator INSTANCE = new ArpeggioBassLineGenerator();

    protected void generateNotes(Bar bar) {
        notes = bar.getChords()[0].getNotes();
    }

}

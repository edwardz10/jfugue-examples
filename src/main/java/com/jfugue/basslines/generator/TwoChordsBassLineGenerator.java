package com.jfugue.basslines.generator;

import com.jfugue.basslines.model.Bar;
import org.jfugue.theory.Note;

public class TwoChordsBassLineGenerator implements BassLineGenerator {

    private TwoChordsBassLineGenerator() {}

    public static TwoChordsBassLineGenerator INSTANCE;

    public Note[] bassline(Bar bar) {
        Note[] notes = new Note[4];
        notes[0] = bar.getChords()[0].getBassNote();
        notes[1] = bar.getChords()[1].getBassNote().changeValue(getRandomAlteration());
        notes[2] = bar.getChords()[1].getBassNote();
        notes[3] = bar.getNextNote().changeValue(getRandomAlteration());
        return notes;
    }

    private int getRandomAlteration() {
        return (Math.random() < 0.5) ? -1 : 1;
    }
}

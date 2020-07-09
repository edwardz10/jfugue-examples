package com.jfugue.basslines.generator;

import com.jfugue.basslines.model.Bar;
import org.jfugue.theory.Note;

public abstract class BaseBassLineGenerator implements BassLineGenerator {

    protected Note[] notes;

    protected abstract void generateNotes(Bar bar);

    public Note[] bassline(Bar bar) {
        notes = new Note[4];

        generateNotes(bar);
        doPostGeneration();

        return notes;
    }

    private void doPostGeneration() {
        for (Note note : notes) {
            note.setDuration("q");
        }
    }

}

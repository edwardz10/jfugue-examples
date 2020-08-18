package com.jfugue.basslines.generator;

import com.jfugue.basslines.model.Bar;
import org.jfugue.theory.Note;

import java.util.List;

public abstract class BaseBassLineGenerator implements BassLineGenerator {

    protected static Note LOWEST_NOTE = new Note("E2");
    protected static Note HIGHEST_NOTE = new Note("A5");

    protected abstract List<Note> generateNotes(Bar bar);

    public List<Note> bassline(Bar bar) {
        List<Note> notes = generateNotes(bar);

        generateNotes(bar);
        doPostGeneration(notes, bar);

        return notes;
    }

    private void doPostGeneration(List<Note> notes, Bar bar) {
        for (int i = 0; i < notes.size(); i++) {
            notes.get(i).setOriginalString(
                    Note.getDispositionedToneStringWithoutOctave(1, notes.get(i).getValue()));

            if (bar.getNextNote() == null && i == notes.size() - 1) {
                notes.get(i).setDuration("w");
            } else {
                notes.get(i).setDuration("q");
            }
        }
    }

}

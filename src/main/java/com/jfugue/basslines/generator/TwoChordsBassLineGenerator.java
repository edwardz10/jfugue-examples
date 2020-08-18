package com.jfugue.basslines.generator;

import com.jfugue.basslines.model.Bar;
import org.jfugue.theory.Note;

import java.util.ArrayList;
import java.util.List;

public class TwoChordsBassLineGenerator extends BaseBassLineGenerator {

    private TwoChordsBassLineGenerator() {}

    public static TwoChordsBassLineGenerator INSTANCE = new TwoChordsBassLineGenerator();

    @Override
    protected List<Note> generateNotes(Bar bar) {
        List<Note> notes = new ArrayList<>();

        notes.add(bar.getChords()[0].getBassNote());
        notes.add(bar.getChords()[1].getBassNote().changeValue(getRandomAlteration()));
        notes.add(bar.getChords()[1].getBassNote());

        if (bar.getNextNote() != null) {
            notes.add(bar.getNextNote().changeValue(getRandomAlteration()));
        }

        return notes;
    }

    private int getRandomAlteration() {
        return (Math.random() < 0.5) ? -1 : 1;
    }
}

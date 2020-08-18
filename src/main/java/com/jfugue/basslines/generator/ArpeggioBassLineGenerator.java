package com.jfugue.basslines.generator;

import com.jfugue.basslines.model.Bar;
import org.jfugue.theory.Note;

import java.util.Arrays;
import java.util.List;

public class ArpeggioBassLineGenerator extends BaseBassLineGenerator {

    private ArpeggioBassLineGenerator() {}

    public static ArpeggioBassLineGenerator INSTANCE = new ArpeggioBassLineGenerator();

    @Override
    protected List<Note> generateNotes(Bar bar) {
        return Arrays.asList(bar.getChords()[0].getNotes());
    }

}

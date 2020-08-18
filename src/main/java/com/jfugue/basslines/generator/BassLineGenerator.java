package com.jfugue.basslines.generator;

import com.jfugue.basslines.model.Bar;
import org.jfugue.theory.Note;

import java.util.List;

public interface BassLineGenerator {
    List<Note> bassline(Bar bar);
}

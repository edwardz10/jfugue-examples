package com.jfugue.basslines.generator;

import com.jfugue.basslines.model.Bar;
import org.jfugue.theory.Note;

public interface BassLineGenerator {
    Note[] bassline(Bar bar);
}

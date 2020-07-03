package com.jfugue.basslines;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jfugue.theory.Chord;
import org.jfugue.theory.Note;

@Data
@AllArgsConstructor
public class Bar {
    private Chord[] chords;
    private Note nextNote;
}
package com.jfugue.basslines.util;

import com.jfugue.basslines.enums.BarTypesEnum;
import com.jfugue.basslines.generator.ArpeggioBassLineGenerator;
import com.jfugue.basslines.generator.BassLineGenerator;
import com.jfugue.basslines.generator.TwoChordsBassLineGenerator;
import com.jfugue.basslines.model.Bar;
import org.jfugue.theory.Chord;
import org.jfugue.theory.Note;

public class ParseUtil {

    public static Bar[] parseSheet(String sheet) {
        String[] barsString = sheet.split(" \\| ");

        Bar[] bars = new Bar[barsString.length];

        for (int i = 0; i < barsString.length; i++) {
            String[] chordsString = barsString[i].split(" ");
            Chord[] chords = new Chord[chordsString.length];

            for (int j = 0; j < chords.length; j++) {
                chords[j] = new Chord(chordsString[j]);
            }

            String[] nextChordsString = (i == barsString.length - 1) ? null : barsString[i + 1].split(" ");

            Note nextNote = (nextChordsString == null) ? null : new Chord(nextChordsString[0]).getBassNote();
            bars[i] = new Bar(chords, nextNote, (i == 0));
        }

        return bars;
    }

    public static BarTypesEnum getBarType(Bar bar) throws Exception {
        switch (bar.getChords().length) {
            case 1:
                String chordType = bar.getChords()[0].getChordType();
                if ("MAJ".equals(chordType)
                        || "MAJ6".equals(chordType)
                        || "MAJ7".equals(chordType)
                        || "ADD9".equals(chordType)
                        || "MAJ6%9".equals(chordType)
                        || "MAJ7%6".equals(chordType)
                        || "MAJ13".equals(chordType)) {
                    return BarTypesEnum.MAJOR;
                } else if ("DOM7".equals(chordType)
                        || "DOM7%6".equals(chordType)
                        || "DOM7%11".equals(chordType)
                        || "DOM7SUS".equals(chordType)
                        || "DOM7%6SUS".equals(chordType)
                        || "DOM9".equals(chordType)
                        || "DOM11".equals(chordType)
                        || "DOM13".equals(chordType)
                        || "DOM13SUS".equals(chordType)
                        || "DOM7%6%11".equals(chordType)) {
                    return BarTypesEnum.DOMINANT;
                } else if ("MIN".equals(chordType)
                        || "MIN6".equals(chordType)
                        || "MIN7".equals(chordType)
                        || "MIN9".equals(chordType)
                        || "MIN11".equals(chordType)
                        || "MIN7%11".equals(chordType)
                        || "MINADD9".equals(chordType)
                        || "MIN6%9".equals(chordType)
                        || "MINMAJ7".equals(chordType)
                        || "MINMAJ9".equals(chordType)) {
                    return BarTypesEnum.MINOR;
                } else if ("HALFDIM".equals(chordType)) {
                    return BarTypesEnum.HALF_DIMINISHED;
                } else if ("DIM".equals(chordType) || "DIM7".equals(chordType)) {
                    return BarTypesEnum.HALF_DIMINISHED;
                }
            case 2:
                return BarTypesEnum.TWO_CHORDS;
            default:
                throw new Exception("Bars like " + bar + " are not supported");
        }
    }

    public static BassLineGenerator getBassLineGenerator(Bar bar) throws Exception {
        switch (getBarType(bar)) {
            case TWO_CHORDS:
                return TwoChordsBassLineGenerator.INSTANCE;
            default:
                return ArpeggioBassLineGenerator.INSTANCE;
        }
    }
}


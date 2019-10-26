const ALL_NOTES_SHARPS = [
  'C', 'C#', 'D', 'D#', 'E', 'F', 'F#', 'G', 'G#', 'A', 'A#', 'B'
];
const ALL_NOTES_FLATS = [
  'F', 'Gb', 'G', 'Ab', 'A', 'Bb', 'B', 'C', 'Db', 'D', 'Eb', 'E'
];
const USES_FLATS = {
  'F': true, 'Bb': true, 'Eb': true, 'Ab': true, 'Db': true, 
  'Gb': true, 'd': true, 'g': true, 'c': true, 'f': true, 
  'bb': true, 'eb': true
};
const INTERVAL_SIZE = {
  'm': 1,
  'M': 2,
  'A': 3
};

/* Generates the list of notes that are used to build scales
   for the given tonic note. The list starts at the tonic. */
const build_note_list_on = (tonic) => {
  let notes = [];
  
  if (USES_FLATS[tonic]) {
    notes = ALL_NOTES_FLATS;
  }
  else {
    notes = ALL_NOTES_SHARPS;
  }

  // Make the note letter uppercase to allow searching for it
  // in the note list.
  const tonic_upper = tonic.replace(/^./, tonic[0].toUpperCase());

  // Rebuilds the note list starting at the given tonic.
  const start_index = notes.indexOf(tonic_upper);
  const scale_start = notes.slice(start_index);
  const scale_end = notes.slice(0, start_index);

  return scale_start.concat(scale_end);
}


export class Scale {

  constructor(tonic) {
    this.all_notes = build_note_list_on(tonic);
  }

  chromatic() {
    return this.all_notes;
  }

  interval(intervals) {

    let i = 0;
    // The tonic note is handled separately.
    let output_scale = [this.all_notes[i]]

    // The last interval is ignored because it is used
    // only to return to the tonic.
    for (const inter of intervals.slice(0, -1)) {
      
      i += INTERVAL_SIZE[inter];
      output_scale.push(this.all_notes[i]);
    }
    return output_scale;
  }
}

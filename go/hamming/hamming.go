// Package hamming provides a utility to get the Hamming distance
// between two DNA strands.
package hamming

import "errors"

// Distance returns the Hamming distance between two DNA strands.
// ASSUMES: a and b only contain 'A', 'C', 'G', 'T'
func Distance(a, b string) (int, error) {

	if len(a) != len(b) {
		return 0, errors.New("DNA strand lengths don't match")
	}

	distance := 0

	for i := 0; i < len(a); i++ {
		if a[i] != b[i] {
			distance++
		}
	}

	return distance, nil
}

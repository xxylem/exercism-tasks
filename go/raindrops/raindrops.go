// Package raindrops contains a utility that returns the
// raindrop text of the given number n.
package raindrops

import "strconv"

// Convert returns the raindrop text of the given number n.
func Convert(n int) string {

	output := ""

	if n%3 == 0 {
		output += "Pling"
	}

	if n%5 == 0 {
		output += "Plang"
	}

	if n%7 == 0 {
		output += "Plong"
	}

	if output != "" {
		return output
	}

	return strconv.Itoa(n)
}

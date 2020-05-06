// Package raindrops contains a utility that returns the
// raindrop text of the given number n.
package raindrops

import "strconv"

type drop struct {
	factor int
	text   string
}

var drops = []drop{
	{
		factor: 3,
		text:   "Pling",
	},
	{
		factor: 5,
		text:   "Plang",
	},
	{
		factor: 7,
		text:   "Plong",
	},
}

// Convert returns the raindrop text of the given number n.
func Convert(n int) string {

	output := ""

	for _, drop := range drops {
		if n%drop.factor == 0 {
			output += drop.text
		}
	}

	if output != "" {
		return output
	}

	return strconv.Itoa(n)
}

package twofer

import (
	"fmt"
)

// ShareWith returns a message based on the given name.
func ShareWith(name string) string {

	if name == "" {
		name = "you"
	}

	return fmt.Sprintf("One for %s, one for me.", name)
}

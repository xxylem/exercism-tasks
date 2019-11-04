#include "resistor_color.h"
#include <stdlib.h>
#include <string.h>

int color_code(resistor_band_t c)
{
	return c;
}

resistor_band_t* colors()
{
	resistor_band_t* all_colors_copy = malloc(TOTAL_NUM_COLORS * sizeof(resistor_band_t));

	if (all_colors_copy)
		memcpy(all_colors_copy, all_colors, TOTAL_NUM_COLORS * sizeof(resistor_band_t));

	return all_colors_copy;
}

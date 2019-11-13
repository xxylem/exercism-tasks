#include "resistor_color.h"

int color_code(resistor_band_t c)
{
	return c;
}

resistor_band_t* colors()
{
	static resistor_band_t all_colors[] = {
	  BLACK, BROWN, RED, ORANGE, YELLOW,
	  GREEN, BLUE, VIOLET, GREY, WHITE
	};

	return all_colors;
}

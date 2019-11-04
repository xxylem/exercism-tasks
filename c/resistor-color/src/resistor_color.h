#ifndef RESISTOR_COLOR_H
#define RESISTOR_COLOR_H

typedef enum {
	BLACK, BROWN, RED, ORANGE, YELLOW,
	GREEN, BLUE, VIOLET, GREY, WHITE
} resistor_band_t;

static const int TOTAL_NUM_COLORS = 10;
static const resistor_band_t all_colors[] = {
	  BLACK, BROWN, RED, ORANGE, YELLOW,
	  GREEN, BLUE, VIOLET, GREY, WHITE
};

int color_code(resistor_band_t c);

// Returns an array containing all the resistor colors. The caller
// must free the array.
resistor_band_t* colors();

#endif

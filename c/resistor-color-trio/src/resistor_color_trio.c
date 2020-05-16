#include "resistor_color_trio.h"

resistor_value_t color_code(resistor_band_t bands[])
{
	uint32_t value = 10 * bands[0] + bands[1];
	uint16_t num_zeros = bands[2];

	for (int i = 0; i < num_zeros; i++)
	{
		value *= 10;
	}

	unit_t unit = OHMS;
	if (value >= 1000)
	{
		value /= 1000;
		unit = KILOOHMS;
	}

	resistor_value_t ret_val = { value, unit };
	return ret_val;
}

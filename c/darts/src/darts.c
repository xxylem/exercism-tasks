#include "darts.h"
#include <math.h>

int score(coordinate_t c)
{
	double dist = hypot(c.x, c.y);

	return dist > 10 ? 0
		  : dist > 5 ? 1
		  : dist > 1 ? 5
					 : 10;
}

#include "gigasecond.h"


namespace gigasecond {

	boost::posix_time::ptime advance(boost::posix_time::ptime t) { return t + GIGASECOND; }

}  // namespace gigasecond

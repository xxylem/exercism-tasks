#if !defined(GIGASECOND_H)
#define GIGASECOND_H

#include <boost\date_time\posix_time\ptime.hpp>
#include <boost\date_time\time_duration.hpp>

namespace gigasecond {

	const boost::posix_time::time_duration GIGASECOND(0, 0, 1000000000, 0);
	boost::posix_time::ptime advance(boost::posix_time::ptime t);

}  // namespace gigasecond

#endif // GIGASECOND_H
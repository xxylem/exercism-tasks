/** Input: a datetime object.
 *  Output: a new datetime set to one gigasecond after the input datetime. */
export const gigasecond = (datetime) => {

  // Datetimes are in milliseconds.
  return new Date(datetime.getTime() + GIGASECOND * 1e3)
};

const GIGASECOND = 1e9

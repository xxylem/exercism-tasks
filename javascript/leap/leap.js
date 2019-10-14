/** INPUT: year (integer)
 *  OUTPUT: true if the year is a leap year
 *          false otherwise */
export const isLeap = (year) => {

  if (year % 400 == 0)
    return true;

  else if (year % 100 == 0)
    return false;

  else if (year % 4 == 0)
    return true;
    
  else
    return false;
  
};

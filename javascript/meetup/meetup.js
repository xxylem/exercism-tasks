const DAY_NUMBER = {
  "Sunday": 0,
  "Monday": 1,
  "Tuesday": 2,
  "Wednesday": 3,
  "Thursday": 4,
  "Friday": 5,
  "Saturday": 6,
};


// Adds days to the current Date.
// SIDE-EFFECTS: modifies this.
Date.prototype.addDays = function(days) {

  this.setDate(this.getDate() + days);
  return this;
};


// Gets the first ocurrence of a day (of the week) of given month.
const first = (year, month, day) => {

  // JS Date: month is 0-indexed, date is 1-indexed, day is 0-indexed 
  // getDay returns the day of the week.
  // getDate returns the day of the month.
  // (because reasons).
  const day_num = DAY_NUMBER[day];
  const dt = new Date(year, month, 1);

  while (dt.getDay() !== day_num)
    dt.addDays(1);

  return dt;
};


// Similar to first but for later ocurrences.
const second = (year, month, day) => first(year, month, day).addDays(7);
const third = (year, month, day) => first(year, month, day).addDays(14);
const fourth = (year, month, day) => first(year, month, day).addDays(21);
const fifth = (year, month, day) => {

  const dt = first(year, month, day).addDays(28);

  if (dt.getMonth() !== month)
    throw new Error(`There is no fifth ${day}`);

  return dt;
};


// Gets the last ocurrence of a day (of the week) of given month.
const last = (year, month, day) => {

  const day_num = DAY_NUMBER[day];
  const dt = new Date(year, month + 1, 0);
  
  while (dt.getDay() !== day_num)
    dt.addDays(-1);

  return dt;
};


// Gets the 'teenth' ocurrence of a day (of the week) of given month.
// I.e. the date between 13 and 19 that is the given day of the week.
const teenth = (year, month, day) => {

  const dt = first(year, month, day);

  while (dt.getDate() < 13)
    dt.addDays(7);

  return dt;
};


const dateFunctions = {
  '1st': first,
  '2nd': second,
  '3rd': third,
  '4th': fourth,
  '5th': fifth,
  'last': last,
  'teenth': teenth
};

export const meetupDay = (year, month, day, ordinal) =>  {
  
  return dateFunctions[ordinal](year, month, day);
};

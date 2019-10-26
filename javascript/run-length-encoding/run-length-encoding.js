const encode_repeated_char = (char, count) => {
  
  if (count < 2) {
    return char;
  }
  
  return count.toString() + char;
}

export const encode = (string) => {

  let encoded_string = '';
  let current_char = '';
  let current_char_count = 0;

  for (const c of string) {

    if (c === current_char) {
      current_char_count += 1;
      continue;
    }

    encoded_string += encode_repeated_char(current_char, current_char_count);

    current_char = c;
    current_char_count = 1;
  }

  encoded_string += encode_repeated_char(current_char, current_char_count);

  return encoded_string;
};

export const decode = (string) => {

  let decoded_string = '';
  let number = '';

  for (const c of string) {

    if (/[A-Z ]/i.test(c)) {
      
      if (number) {
        decoded_string += c.repeat(number.toString());
        number = '';
      }

      else
        decoded_string += c;
    }

    else
      number += c;
  }

  return decoded_string;
};

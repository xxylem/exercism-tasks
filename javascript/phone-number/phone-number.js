
const phone_number_pattern = 
  /^\s*(?:\+?1)?\s*\(?([2-9]\d\d)\)?\s*[.-]?\s*([2-9]\d\d)\s*[.-]?\s*(\d{4})\s*$/;
const phone_number_replace_pattern = 
  "$1$2$3";

export class PhoneNumber {

  constructor(phone_number) {

    this._number = 
      phone_number_pattern.test(phone_number)
        ? phone_number.replace(phone_number_pattern,
            phone_number_replace_pattern)
        : null;
  }

  number() {
    return this._number;
  }
}

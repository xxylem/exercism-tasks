export const hey = (message) => {
  
  if (isShouting(message) && isQuestion(message))
  {
    return "Calm down, I know what I'm doing!";
  }

  if (isShouting(message))
  {
    return "Whoa, chill out!";
  }

  if (isQuestion(message))
  {
    return "Sure.";
  }

  if (isEmpty(message))
  {
    return "Fine. Be that way!";
  }

  return "Whatever.";
};

const isShouting = message => /^[^a-z]*[A-Z][^a-z]*$/.test(message);

const isQuestion = message => /^.*\?\s*$/.test(message);

const isEmpty = message => /^\s*$/.test(message);
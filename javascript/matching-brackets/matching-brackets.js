const brackets_pattern = /{}|\[\]|\(\)/;

const removeInnerBrackets = (string) => {
  return string.replace(brackets_pattern, '');
}

export const matchingBrackets = (brackets) => {

  let old_length = brackets.length;
  brackets = removeInnerBrackets(brackets);

  while (brackets.length !== old_length) {
    
    old_length = brackets.length;
    brackets = removeInnerBrackets(brackets)
    
  }

  return brackets.length === 0;
};

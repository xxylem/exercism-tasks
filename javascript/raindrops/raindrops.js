const DROPS = {
  3: "Pling",
  5: "Plang",
  7: "Plong"
};

export const convert = (number) => {
  let output = "";
  for (const [factor, drop] of Object.entries(DROPS)) {
    if (number % factor == 0)
      output += drop;
  }

  if (!output)
    output = number.toString();

  return output;
};

export const solve = (x, y) => {
  
  const dist = Math.hypot(x, y);

  return dist > 10 ? 0 :
          dist > 5 ? 1 :
            dist > 1 ? 5 : 
                        10;
};

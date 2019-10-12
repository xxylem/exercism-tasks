import { colorCode } from '../resistor-color/resistor-color.js';


export const value = (colors) => {
  return colorCode(colors[0]) * 10 + colorCode(colors[1]);
};

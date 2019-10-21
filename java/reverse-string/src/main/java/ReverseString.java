class ReverseString {

    String reverse(String inputString) {
        StringBuilder sb = new StringBuilder();
        sb.append(inputString);
        return sb.reverse().toString();
    }
  
}
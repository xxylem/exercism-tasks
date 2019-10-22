class Bob {

    private static final String questionResponse = "Sure.";
    private static final String yellResponse = "Whoa, chill out!";
    private static final String yellQuestionResponse = "Calm down, I know what I'm doing!";
    private static final String emptyResponse = "Fine. Be that way!";
    private static final String otherResponse = "Whatever.";

    private static final String yellPattern = "[^a-z]*[A-Z][^a-z]*";
    private static final String questionPattern = ".*\\?$";


    String hey(String message) {

        String strippedMessage = message.strip();

        if (strippedMessage.length() == 0)
            return emptyResponse;

        boolean isQuestion = strippedMessage.matches(questionPattern);
        boolean isYelled = strippedMessage.matches(yellPattern);

        if (isQuestion && isYelled)
            return yellQuestionResponse;

        if (isQuestion)
            return questionResponse;

        if (isYelled)
            return yellResponse;

        return otherResponse;
    }

}
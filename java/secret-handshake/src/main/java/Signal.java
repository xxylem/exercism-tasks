enum Signal {

    WINK(0b1), DOUBLE_BLINK(0b10), CLOSE_YOUR_EYES(0b100), JUMP(0b1000);

    private final int binaryFlag;

    Signal(int binaryFlag)
    {
        this.binaryFlag = binaryFlag;
    }

    public boolean isOperationUsed(int number)
    {
        return (binaryFlag & number) > 0;
    }
}

package day2;

public class GameRequirement {
    private int red;
    private int blue;
    private int green;
    private int minRed;
    private int minBlue;
    private int minGreen;

    public GameRequirement(int red, int blue, int green) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    public void reset() {
        this.minRed = 0;
        this.minBlue = 0;
        this.minGreen = 0;
    }

    public int powerOfDices() {
        return (this.minRed * this.minBlue * this.minGreen);
    }

    public int getRed() {
        return red;
    }

    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getMinRed() {
        return minRed;
    }

    public void setMinRed(int minRed) {
        this.minRed = minRed;
    }

    public int getMinBlue() {
        return minBlue;
    }

    public void setMinBlue(int minBlue) {
        this.minBlue = minBlue;
    }

    public int getMinGreen() {
        return minGreen;
    }

    public void setMinGreen(int minGreen) {
        this.minGreen = minGreen;
    }

    @Override
    public String toString() {
        return "GameRequirement [red=" + red + ", blue=" + blue + ", green=" + green + "]";
    }

}

package day2;

public class Round {
    private int red;
    private int blue;
    private int green;

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

    @Override
    public String toString() {
        return "Round [red=" + red + ", blue=" + blue + ", green=" + green + "]";
    }

}

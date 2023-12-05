package day5;

public class MapEntry {
    private long destRange;
    private long sourceRange;
    private long offset;

    public MapEntry(long destRange, long sourceRange, long offset) {
        this.destRange = destRange;
        this.sourceRange = sourceRange;
        this.offset = offset;
    }

    public long getDestRange() {
        return destRange;
    }

    public void setDestRange(long destRange) {
        this.destRange = destRange;
    }

    public long getSourceRange() {
        return sourceRange;
    }

    public void setSourceRange(long sourceRange) {
        this.sourceRange = sourceRange;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "MapEntry [destRange=" + destRange + ", sourceRange=" + sourceRange + ", offset=" + offset + "]";
    }

    public static void test() {

    }

}

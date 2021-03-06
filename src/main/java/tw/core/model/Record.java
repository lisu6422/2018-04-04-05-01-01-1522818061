package tw.core.model;

public class Record {
    private int[] value;

    public Record() {
        this.value = new int[]{0, 0};

    }

    public int[] getValue() {
        return value;
    }

    public void increaseCurrentNum() {
        this.value[0]++;
    }

    public void increaseIncludeOnlyNum() {
        this.value[1]++;
    }

    @Override
    public String toString() {
        return value[0] + ":" + value[1];
    }
}

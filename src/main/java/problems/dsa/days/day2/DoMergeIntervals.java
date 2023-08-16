package problems.dsa.days.day2;

class Interval {
    int start;
    int end;

    @Override
    public String toString() {
        return "{" + start + ", " + end + "}";
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}


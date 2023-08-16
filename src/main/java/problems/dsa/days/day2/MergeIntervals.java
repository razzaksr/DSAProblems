package problems.dsa.days.day2;

import java.util.*;

public class MergeIntervals {

    public static void mergeIntervalsUsingStackAndList(List<Interval> intervals)
    {
        // sort the intervals in increasing order of their starting time
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));

        // create an empty stack
        Stack<Interval> stack = new Stack<>();

        // do for each interval
        for (Interval curr: intervals)
        {
            // if the stack is empty or the top interval in the stack does not overlap
            // with the current interval, push it into the stack
            if (stack.empty() || curr.start > stack.peek().end) {
                stack.push(curr);
            }

            // if the top interval of the stack overlaps with the current interval,
            // merge two intervals by updating the end of the top interval
            // to the current interval
            if (stack.peek().end < curr.end) {
                stack.peek().end = curr.end;
            }
        }

        // print all non-overlapping intervals
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public static void mergeIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return;
        }

        // Sort intervals based on start points
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = 0; j < intervals.length - i - 1; j++) {
                if (intervals[j].start > intervals[j + 1].start) {
                    Interval temp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }
            }
        }

        // Merge overlapping intervals
        Interval currentInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (currentInterval.end >= intervals[i].start) {
                currentInterval.end = Math.max(currentInterval.end, intervals[i].end);
            } else {
                System.out.print("{" + currentInterval.start + ", " + currentInterval.end + "} ");
                currentInterval = intervals[i];
            }
        }
        System.out.println("{" + currentInterval.start + ", " + currentInterval.end + "}");
    }

    public static void main(String[] args) {
        Interval[] intervals = {
                new Interval(1, 5), new Interval(2, 3),
                new Interval(4, 6), new Interval(7, 8),
                new Interval(8, 10), new Interval(12, 15)
        };

        mergeIntervals(intervals);

        List<Interval> intervalsList = Arrays.asList(
                new Interval(1, 5), new Interval(2, 3),
                new Interval(4, 6), new Interval(7, 8),
                new Interval(8, 10), new Interval(12, 15)
        );
        mergeIntervalsUsingStackAndList(intervalsList);
    }
}

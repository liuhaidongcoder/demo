package com.liuhaidongcoder.latencyutils;

import org.HdrHistogram.Histogram;
import org.LatencyUtils.IntervalEstimator;
import org.LatencyUtils.LatencyStats;
import org.LatencyUtils.PauseDetectorListener;

/**
 * @author Liu Haidong
 * @date 20/5/26
 */
public class LatencyUtilsTest {
    public static void main(String[] args) throws InterruptedException {
        LatencyStats latencyStats = new LatencyStats();
        latencyStats.recordLatency(10000);
        latencyStats.recordLatency(10000);

        Histogram histogram = new Histogram(500,1000,2);
        histogram.recordValue(3);
        histogram.recordValue(3);
        histogram.recordValue(6);
        histogram.recordValue(9);
        System.out.println(histogram.getTotalCount());
        System.out.println(histogram.getMaxValue());
        System.out.println(histogram.getMean());
        System.out.println(histogram.getValueAtPercentile(90D));
        System.out.println(histogram.getMinValue());
        System.out.println(histogram.getCountAtValue(3));
        System.out.println(histogram.getCountBetweenValues(4,7));
        System.out.println(histogram.getLowestDiscernibleValue());
        System.out.println(histogram.getEndTimeStamp());

        histogram.outputPercentileDistribution(System.out,1D);


    }
}

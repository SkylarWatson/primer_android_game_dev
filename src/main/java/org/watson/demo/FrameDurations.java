package org.watson.demo;

public class FrameDurations {
    public long[] getDurations(int frames, int duration) {
        long[] huh = new long[frames];
        for (int i = 0; i <= frames -1; ++i) {
            huh[i] = duration;
        }
        return huh;
    }
}

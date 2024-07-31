package com.codewithmosh;

import com.codewithmosh.visitor.*;

import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Operation reverb = new OperationReverb();
        List<Segment> segments = new WavFile.read("Name").getSegments();
        for (int i = 0; i < segments.size(); i++) {
            reverb.apply(segments.get(i));
        }
    }
}

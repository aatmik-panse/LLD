package com.example.video;

public class SharpenAdapter {
    private final LegacySharpen legacySharpen;

    public SharpenAdapter(LegacySharpen legacySharpen) {
        this.legacySharpen = legacySharpen;
    }

    public Frame[] sharpen(Frame[] frames, int strength) {
        String handle = "FRAMES:" + frames.length;
        legacySharpen.applySharpen(handle, strength);
        return frames;
    }
}

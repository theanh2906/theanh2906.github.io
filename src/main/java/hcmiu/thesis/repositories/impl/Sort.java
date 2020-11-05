package hcmiu.thesis.repositories.impl;

import java.util.Comparator;

public class Sort implements Comparator<Node>{
    public int compare(Node a, Node b) {
        return b.freq - a.freq;
    }
}
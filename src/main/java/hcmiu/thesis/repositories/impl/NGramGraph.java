package hcmiu.thesis.repositories.impl;

import java.util.List;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

import opennlp.tools.ngram.NGramModel;

public class NGramGraph {
    public void generate(List<Node> list){
        Graph graph = new SingleGraph("Ngram graph");
        graph.addAttribute("ui.stylesheet", "url(/style)");
        for (Node node : list){
            graph.setStrict(false);
            graph.setAutoCreate(true);
            // graph.addEdge(id, node1, node2)
        }
    }
}
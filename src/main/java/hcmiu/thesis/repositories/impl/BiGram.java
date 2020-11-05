package hcmiu.thesis.repositories.impl;
//package hcmiu.thesis.dao.impl;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.*;
//
//import org.graphstream.graph.*;
//import org.graphstream.graph.implementations.*;
//import org.graphstream.ui.view.*;
//
//import java.nio.file.*;
//
//import opennlp.tools.ngram.NGramModel;
//import opennlp.tools.sentdetect.SentenceDetectorME;
//import opennlp.tools.sentdetect.SentenceModel;
//import opennlp.tools.tokenize.SimpleTokenizer;
//import opennlp.tools.util.*;
//
//public class BiGram extends NGram{
//    // @Override
//    public void filterStopWords() throws IOException {
//        this.list = new ArrayList<Node>();
//        for (StringList gram : this.model) {
//            this.list.add(new Node(gram.getToken(0),gram.getToken(1),this.model.getCount(gram)));
//        }
//        List<String> stopwords = Files.readAllLines(Paths.get("./stopwords.txt"));
//        
//        for (String word : stopwords){
//            for (int i = 0; i<this.list.size();i++){
//                Node node = this.list.get(i);
//                if (node.getValue(1).equals(word) || node.getValue(2).equals(word)){
//                    this.list.remove(node);
//                }
//            }
//        }
//            // System.out.println(node.getValue());
//        }
//
//        public void sort() {
//
//            Collections.sort(this.list, new Sort());
//            // this.sorted = new ArrayList<String>();
//            // for (Node node : this.list) {
//            //     this.sorted.add(node.getValue().replace("[", "").replace("]", ""));
//            // }
//    
//        }
//    public static void main(String[] args) throws IOException {
//        BiGram bi = new BiGram();
//        Graph graph = new SingleGraph("Bigram graph");
//        graph.addAttribute("ui.stylesheet", "url(./style)");
//        StringList words = bi.tokenize();
//        bi.generate(words, 2);
//        bi.filterStopWords();
//        bi.sort();
//
//        for (Node node : bi.list){
//            // System.out.println(node.getKey() + "-" + node.getValue(1)+ "," + node.getValue(2));
//            graph.setStrict(false);
//            graph.setAutoCreate(true);
//            graph.addEdge(node.getName(), node.getValue(1), node.getValue(2)).setAttribute("length", node.getKey());;
//        }
//        for (org.graphstream.graph.Node node : graph){
//            node.addAttribute("ui.label", node.getId());
//        }
//        for (Edge edge : graph.getEachEdge()) {
//            edge.addAttribute("ui.label","" + (int) edge.getNumber("length"));
//        }
//        // Viewer viewer = graph.display();
//        // View view = viewer.getDefaultView();
//        // view.getCamera().setViewCenter(2, 3, 4);
//        // view.getCamera().setViewPercent(0.5);
//    }
//}
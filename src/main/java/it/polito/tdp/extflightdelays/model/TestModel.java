package it.polito.tdp.extflightdelays.model;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();

		model.createGraph(300);

		System.out.println("Creati " + model.getVertexNumber() + " vertici e " + model.getEdgesNumber() + " archi.\n");
		//for(DefaultEdge e: model.getEdges()) {
		//	System.out.print(Graphs.getEdgeSource(e));
		//}
		
		
	}

}

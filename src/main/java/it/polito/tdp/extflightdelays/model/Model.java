package it.polito.tdp.extflightdelays.model;

import java.util.List;
import java.util.Set;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class Model {

	private ExtFlightDelaysDAO ExtFlightDelaysDAO;
	private List<Airport> airports;
	private SimpleWeightedGraph<Airport, DefaultEdge> graph;

	public Model() {
		ExtFlightDelaysDAO = new ExtFlightDelaysDAO();
	}
	
	public void createGraph(int distanzaMinima) {
		
		airports = ExtFlightDelaysDAO.loadAllAirportsWALOF();
		
		graph = new SimpleWeightedGraph<>(DefaultEdge.class);
		
		for(Airport a:airports) {
			graph.addVertex(a);
		}
		
		for(Airport ao:airports) {
			
			for(Airport ad:airports) {
				if(airports.indexOf(ad) > airports.indexOf(ao)) {
					Double avg_distance = ExtFlightDelaysDAO.avgFlightDistanceBetweenAirports(ad, ao);
					if(avg_distance >= distanzaMinima) {
						Graphs.addEdgeWithVertices(graph, ao, ad, avg_distance);
					}
				}
			}
		}
	
	}
	
	public int getVertexNumber() {
		return graph.vertexSet().size();
	}
	
	public int getEdgesNumber() {
		return graph.edgeSet().size();
	}
	
	public Set<DefaultEdge> getEdges() {
		return graph.edgeSet();
	}
	
}

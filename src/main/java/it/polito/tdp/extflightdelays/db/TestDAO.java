package it.polito.tdp.extflightdelays.db;

import it.polito.tdp.extflightdelays.model.Airport;

public class TestDAO {

	public static void main(String[] args) {

		ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();

		System.out.println(dao.loadAllAirlines());
		System.out.println(dao.loadAllAirports().size());
		System.out.println(dao.loadAllAirportsWALOF().size());
		System.out.println(dao.loadAllFlights().size());
		System.out.println(dao.avgFlightDistanceBetweenAirports(new Airport(20), new Airport(228)));
		System.out.println(dao.avgFlightDistanceBetweenAirports(new Airport(228), new Airport(20)));
	}

}

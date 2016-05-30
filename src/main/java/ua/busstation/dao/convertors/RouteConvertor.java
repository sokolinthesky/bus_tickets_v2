package ua.busstation.dao.convertors;

import ua.busstation.core.route.Route;
import ua.busstation.dao.models.RouteModel;

public class RouteConvertor {

	public static Route convertToRoute(RouteModel model) {
		return new Route(model.getId(), model.getName(), model.getDepartureTime(), model.getDestinationTime(),
				model.getPrice(), BusConvertor.convertListToBus(model.getBusModels()));
	}
	
	public static RouteModel convertToRouteModel(Route route) {
		return new RouteModel(route.getId(), route.getName(), route.getPrice(),route.getDepartureTime(),
				route.getDestinationTime(), BusConvertor.convertListToBusModel(route.getBuses()));
	}

}

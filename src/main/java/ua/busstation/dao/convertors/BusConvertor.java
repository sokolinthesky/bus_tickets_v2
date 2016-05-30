package ua.busstation.dao.convertors;

import ua.busstation.core.bus.Bus;
import ua.busstation.dao.models.BusModel;

import java.util.ArrayList;
import java.util.List;

public class BusConvertor {

    public static BusModel convetToBusModel(Bus bus) {
        return new BusModel(bus.getId(), bus.getTrainNumber(), bus.getSeats());
    }

    public static Bus convertToBus(BusModel model) {
        return new Bus(model.getId(), model.getTrainNumber(), model.getSeats());
    }

    public static List<BusModel> convertListToBusModel(List<Bus> buses) {
        List<BusModel> models = new ArrayList<>();

        for(Bus bus : buses) {
            models.add(convetToBusModel(bus));
        }

        return models;
    }

    public static List<Bus> convertListToBus(List<BusModel> models) {
        List<Bus> buses = new ArrayList<>();

        for(BusModel model : models) {
            buses.add(convertToBus(model));
        }

        return buses;
    }
}

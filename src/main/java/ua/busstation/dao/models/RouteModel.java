package ua.busstation.dao.models;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "routes")
public class RouteModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private double price;

	@Column(name = "departure_time")
	private Time departureTime;

	@Column(name = "destination_time")
	private Time destinationTime;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "route_id")
	@OrderBy
	private List<BusModel> busModels;

	public RouteModel() {
	}

	public RouteModel(String id, String name, double price, Time departureTime, Time destinationTime, List<BusModel> busModels) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.departureTime = departureTime;
		this.destinationTime = destinationTime;
		this.busModels = busModels;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public Time getDestinationTime() {
		return destinationTime;
	}

	public void setDestinationTime(Time destinationTime) {
		this.destinationTime = destinationTime;
	}

	public List<BusModel> getBusModels() {
		return busModels;
	}

	public void setBusModels(List<BusModel> busModels) {
		this.busModels = busModels;
	}
}

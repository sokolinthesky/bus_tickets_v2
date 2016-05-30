package ua.busstation.dao.models;

import javax.persistence.*;

@Entity
@Table(name = "buses")
public class BusModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private String id;

    @Column(name = "train_number")
    private String trainNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id")
    private RouteModel routeModel;

    @Column(name = "seats")
    private int seats;

    /*@Column(name = "date")
    private Date date;*/

    public BusModel(){}

    public BusModel(String id, String trainNumber, RouteModel routeModel, int seats/*, Date date*/) {
        this.id = id;
        this.trainNumber = trainNumber;
        this.routeModel = routeModel;
        this.seats = seats;
        /*this.date = date;*/
    }

    public BusModel(String id, String trainNumber, int seats/*, Date date*/) {
        this.id = id;
        this.trainNumber = trainNumber;
        this.seats = seats;
        /*this.date = date;*/
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public RouteModel getRouteModel() {
        return routeModel;
    }

    public void setRouteModel(RouteModel routeModel) {
        this.routeModel = routeModel;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    /*public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }*/
}

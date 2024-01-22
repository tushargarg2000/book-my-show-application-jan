package com.acciojob.bookmyshowapplication.Entities;

import com.acciojob.bookmyshowapplication.Enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "show_seats")
@Data
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private int price;

    private boolean isAvailable;

    private boolean foodAttached;

    private String seatNo; //These values will
    private SeatType seatType; //come from the Theater seats
    //based on mapping or seat structure


    @JoinColumn
    @ManyToOne
    private Show show;
}

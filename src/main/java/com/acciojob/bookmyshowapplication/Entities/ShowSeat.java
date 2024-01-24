package com.acciojob.bookmyshowapplication.Entities;

import com.acciojob.bookmyshowapplication.Enums.SeatType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "show_seats")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;

    private int price;

    private boolean isAvailable;

    private boolean foodAttached;

    private String seatNo; //These values will

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType; //come from the Theater seats
    //based on mapping or seat structure

    @JoinColumn
    @ManyToOne
    @JsonIgnore
    private Show show;
}

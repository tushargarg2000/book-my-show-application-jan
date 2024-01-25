package com.acciojob.bookmyshowapplication.Response;

import com.acciojob.bookmyshowapplication.Enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowTicketResponse {

    private String movieName;
    private String theaterInfo;
    private LocalDate showDate;
    private LocalTime showTime;
    private int totalAmt;
    private String seatNos;
    private SeatType seatType;

}

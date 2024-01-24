package com.acciojob.bookmyshowapplication.Services;

import com.acciojob.bookmyshowapplication.Entities.Show;
import com.acciojob.bookmyshowapplication.Entities.ShowSeat;
import com.acciojob.bookmyshowapplication.Entities.Ticket;
import com.acciojob.bookmyshowapplication.Repository.ShowRepository;
import com.acciojob.bookmyshowapplication.Repository.TicketRepository;
import com.acciojob.bookmyshowapplication.Requests.BookTicketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public String bookTicket(BookTicketRequest bookTicketRequest) throws Exception{

        Show show = showRepository.findById(bookTicketRequest.getShowId()).get();


        //Check for seat available or not
        List<ShowSeat> showSeatList = show.getShowSeatList();
        int totalBookingAmount = 0;

        for(String seatNoToBeBooked : bookTicketRequest.getSeatList()){

            for(ShowSeat showSeat:showSeatList){

                if(showSeat.getSeatNo().equals(seatNoToBeBooked)&&
                (bookTicketRequest.getSeatType().equals(showSeat.getSeatType()))){

                    if(showSeat.isAvailable()){
                        showSeat.setAvailable(Boolean.FALSE);
                        totalBookingAmount = totalBookingAmount+showSeat.getPrice();
                    }else{
                        throw new Exception("Seat No "+showSeat.getSeatNo()+" is already booked.");
                    }
                }
            }
        }

        //All the seats were available

        Ticket ticket = Ticket.builder()
                .seatNosBooked(bookTicketRequest.getSeatList().toString())
                .totalAmountPaid(totalBookingAmount)
                .show(show) //FK being set
                .build();


        show.getTicketList().add(ticket); //Bidirectional mapping

        ticket = ticketRepository.save(ticket);

        return "This is the ticket with the ticketId"+ticket.getTicketId();
    }


}

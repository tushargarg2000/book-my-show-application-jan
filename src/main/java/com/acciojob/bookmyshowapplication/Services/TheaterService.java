package com.acciojob.bookmyshowapplication.Services;

import com.acciojob.bookmyshowapplication.Entities.Theater;
import com.acciojob.bookmyshowapplication.Entities.TheaterSeat;
import com.acciojob.bookmyshowapplication.Enums.SeatType;
import com.acciojob.bookmyshowapplication.Repository.TheaterRepository;
import com.acciojob.bookmyshowapplication.Requests.AddTheaterRequest;
import com.acciojob.bookmyshowapplication.Requests.AddTheaterSeatsRequest;
import com.acciojob.bookmyshowapplication.Transformers.TheaterTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public String addTheater(AddTheaterRequest theaterRequest){

        Theater theater = TheaterTransformers.convertRequestToEntity(theaterRequest);

        theater = theaterRepository.save(theater);
        return "Theater has been saved to DB with theaterId"+theater.getTheaterId();
    }


    public String addTheaterSeats(AddTheaterSeatsRequest theaterSeatsRequest){

        int noOfClassicSeats = theaterSeatsRequest.getNoOfClassicSeats();
        int noOfPremiumSeats = theaterSeatsRequest.getNoOfPremiumSeats();
        Theater theater = theaterRepository.findById(theaterSeatsRequest.getTheaterId()).get();

        int quoClassic = noOfClassicSeats/5;

        int remClassic = noOfClassicSeats%5;

        //TODO Make sure the theater Seats are unique
        //So that you dont need to store the seatType

        List<TheaterSeat> theaterSeatList = new ArrayList<>();

        for(int row = 1;row<=quoClassic;row++){

            for(int col = 1;col<=5;col++) {
                char ch = (char)('A'+(col-1));
                String seatNo = row+""+ch;

                TheaterSeat theaterSeatEntity = TheaterSeat.builder()
                        .seatNo(seatNo)
                        .seatType(SeatType.CLASSIC)
                        .theater(theater)
                        .build();

                theaterSeatList.add(theaterSeatEntity);
            }
        }

        int rowNoForRemainder = quoClassic+1;

        for(int col=1;col<=remClassic;col++){

            char ch = (char)('A'+(col-1));
            String seatNo = rowNoForRemainder+""+ch;
            TheaterSeat theaterSeatEntity = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .theater(theater)
                    .build();
            theaterSeatList.add(theaterSeatEntity);
        }

        int quoPremium = noOfPremiumSeats/5;
        int remPremium = noOfPremiumSeats%5;
        for(int row = 1;row<=quoPremium;row++){
            for(int col = 1;col<=5;col++) {

                char ch = (char)('A'+(col-1));
                String seatNo = row+""+ch;
                TheaterSeat theaterSeatEntity = TheaterSeat.builder()
                        .seatNo(seatNo)
                        .seatType(SeatType.PREMIUM)
                        .theater(theater)
                        .build();

                theaterSeatList.add(theaterSeatEntity);
            }
        }

        rowNoForRemainder = quoPremium+1;

        for(int col=1;col<=remPremium;col++){

            char ch = (char)('A'+(col-1));
            String seatNo = rowNoForRemainder+""+ch;
            TheaterSeat theaterSeatEntity = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .theater(theater)
                    .build();

            theaterSeatList.add(theaterSeatEntity);
        }
        //Created a TheaterSeat Entity : set the FK in the Theater Seat Entity
        //Setting the variable of the Bidirectional mapping in the parent class
        theater.setTheaterSeatList(theaterSeatList);

        //Save both parent and child : Not required , only save the parent :
        theaterRepository.save(theater);

        return "Theater seats have been added";

    }

}

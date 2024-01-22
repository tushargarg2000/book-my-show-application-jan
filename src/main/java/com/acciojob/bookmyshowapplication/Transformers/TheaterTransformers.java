package com.acciojob.bookmyshowapplication.Transformers;

import com.acciojob.bookmyshowapplication.Entities.Theater;
import com.acciojob.bookmyshowapplication.Requests.AddTheaterRequest;

public class TheaterTransformers {


    public static Theater convertRequestToEntity(AddTheaterRequest theaterRequest){

        Theater theater = Theater.builder()
                .address(theaterRequest.getAddress())
                .noOfScreens(theaterRequest.getNoOfScreens())
                .name(theaterRequest.getName())
                .build();

        return theater;
    }

}

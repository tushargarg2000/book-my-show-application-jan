package com.acciojob.bookmyshowapplication;

import com.acciojob.bookmyshowapplication.Entities.Movie;
import com.acciojob.bookmyshowapplication.Entities.Show;
import com.acciojob.bookmyshowapplication.Entities.Ticket;

public class DemoTest {

    public static void main(String[] args) {

        Ticket ticketEntityObj = new Ticket();



        Show show =  ticketEntityObj.getShow(); //Line 1

        Movie movie = show.getMovie(); //Line 2

        String movieName = movie.getMovieName(); //Line 3


        String movieName1 = ticketEntityObj.getShow().getMovie().getMovieName();


    }
}

package com.acciojob.bookmyshowapplication.Controllers;

import com.acciojob.bookmyshowapplication.Requests.BookTicketRequest;
import com.acciojob.bookmyshowapplication.Response.ShowTicketResponse;
import com.acciojob.bookmyshowapplication.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/bookTicket")
    public ResponseEntity bookTicket(@RequestBody BookTicketRequest bookTicketRequest){

        try {
            String result = ticketService.bookTicket(bookTicketRequest);
            return new ResponseEntity(result,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/viewTicket")
    public ShowTicketResponse viewTicket(@RequestParam("ticketId")Integer ticketId){
        ShowTicketResponse showTicketResponse = ticketService.viewTicket(ticketId);
        return showTicketResponse;
    }

}

package com.acciojob.bookmyshowapplication.Controllers;


import com.acciojob.bookmyshowapplication.Requests.AddShowRequest;
import com.acciojob.bookmyshowapplication.Requests.AddShowSeatsRequest;
import com.acciojob.bookmyshowapplication.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("addShow")
    public ResponseEntity addShow(@RequestBody AddShowRequest addShowRequest){

        try {
            String result = showService.addShow(addShowRequest);
            return new ResponseEntity(result, HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addShowSeats")
    public ResponseEntity addShowSeats(@RequestBody AddShowSeatsRequest addShowSeats){

        //try {
            String result = showService.addShowSeats(addShowSeats);
            return new ResponseEntity(result,HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }
}

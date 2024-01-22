package com.acciojob.bookmyshowapplication.Requests;

import com.acciojob.bookmyshowapplication.Enums.Genre;
import com.acciojob.bookmyshowapplication.Enums.Language;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddMovieRequest {

    private String movieName;
    private Genre genre;
    private Language movieLanguage;
    private LocalDate releaseDate;
    private double duration;
    private double rating;
}

package b_bookmyshow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import b_bookmyshow.Enums.City;

public class TheatreController {
    Map<City, List<Theatre>> cityVsTheatre;
    List<Theatre> allTheatre;

    TheatreController(){
        cityVsTheatre = new HashMap<>();
        allTheatre = new ArrayList<>();
    }

    void addTheatre(Theatre theatre, City city){
        allTheatre.add(theatre);
        List<Theatre> theatres = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatre.put(city, theatres);
    }

    Map<Theatre, List<Show>> getAllShow(Movie movie, City city){
        List<Theatre> theatres = cityVsTheatre.get(city);
        Map<Theatre, List<Show>> threatresVsShow = new HashMap<>();
        for(Theatre theatre: theatres){
            List<Show> givenMoviesShow = new ArrayList<>();
            for(Show show: theatre.getShow()){
                if(movie.getMovieId() == show.getMovie().getMovieId()){
                    givenMoviesShow.add(show);
                }
            }

            if(!givenMoviesShow.isEmpty()){
                threatresVsShow.put(theatre, givenMoviesShow);
            }
        }
        return threatresVsShow;
    }  

}

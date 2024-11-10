package b_bookmyshow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import b_bookmyshow.Enums.City;
import b_bookmyshow.Enums.SeatCategory;

public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;

    BookMyShow(){
        movieController = new MovieController();
        theatreController = new TheatreController();
    }

    public void createMovies(){
        Movie avengers = new Movie(1, "Avengers", 180);
        movieController.allMovies.add(avengers);

        Movie bahubali = new Movie(2, "Bahubali", 200);
        movieController.allMovies.add(bahubali);

        movieController.addMovie(avengers, City.Delhi);
        movieController.addMovie(avengers, City.Bangalore);
        movieController.addMovie(bahubali, City.Delhi);
        movieController.addMovie(bahubali, City.Bangalore);
    }

    public void createTheatre(){
        Movie avengers = movieController.getMovieByName("Avengers");
        Movie bahubali = movieController.getMovieByName("Bahubali");

        Theatre inox = new Theatre(1, "Address-1", City.Bangalore, createScreen(), new ArrayList<>());
        Show inoxShowMorning = new Show(1, bahubali, inox.getScreen().get(0), 7, new ArrayList<>());
        inox.addShow(inoxShowMorning);

        Theatre pvr = new Theatre(2, "Address-2", City.Delhi, createScreen(), new ArrayList<>());
        Show pvrShowMorning = new Show(1, avengers, inox.getScreen().get(0), 7, new ArrayList<>());
        Show pvrShowEvening = new Show(1, avengers, inox.getScreen().get(0), 14, new ArrayList<>());
        pvr.addShow(pvrShowMorning);
        pvr.addShow(pvrShowEvening);

        theatreController.addTheatre(inox, City.Bangalore);
        theatreController.addTheatre(pvr, City.Delhi);

    }

    public List<Screen> createScreen(){
        Screen screen = new Screen(1, createSeats());
        List<Screen> screens = new ArrayList<>();
        screens.add(screen);
        return screens;
    }

    public List<Seat> createSeats(){
        List<Seat> seats = new ArrayList<>();

        for(int i = 1; i <= 40; i++){
            seats.add(new Seat(i, 1, SeatCategory.SILVER));
            
        }
        for(int i = 41; i <= 60; i++){
            seats.add(new Seat(i, 2, SeatCategory.SILVER));
            
        }
        for(int i = 61; i <= 70; i++){
            seats.add(new Seat(i, 3, SeatCategory.PLATINUM));
        }
        return seats;
    }

    public void createBooking(String movieName, City city){
        Movie interestedMovie = null;
        for(Movie movie: movieController.getMoviesByCity(city)){
            if(movie.getMovieName().equals(movieName)){
                interestedMovie = movie;
            }
        }

        Map<Theatre, List<Show>> showsTheatreWise = theatreController.getAllShow(interestedMovie, city);
        for (Map.Entry<Theatre, List<Show>> entry : showsTheatreWise.entrySet()) {
            Theatre t = entry.getKey(); // TODO: check it
            List<Show> s = entry.getValue();
            for(Show currentShow : s){
                int seatNumber = 30;
                if(currentShow.bookedSeatIds.contains(seatNumber)){
                    currentShow.bookedSeatIds.add(seatNumber);
                    Booking booking = new Booking();
                    List<Seat> myBookedSeats = new ArrayList<>();
                    for(Seat screenSeat : currentShow.getScreen().getSeats()) {
                        if(screenSeat.getSeatId() == seatNumber) {
                            myBookedSeats.add(screenSeat);
                        }
                    }        
                    booking.setBookedSeats(myBookedSeats);
                    booking.setShow(currentShow);
                }else{
                    System.out.println("seat already booked, try again");
                    return;        
                }
            }
        }
        System.out.println("BOOKING SUCCESSFUL");
    }

    public void initialize(){
        // create Movies
        createMovies();

        // create theatre
        createTheatre();

        // user1
        createBooking("Avengers", City.Delhi);
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();
    }

}

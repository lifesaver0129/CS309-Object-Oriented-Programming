class Rental {

    private Movie _movie;
    private int _daysRented;


    public Rental(Movie movie, DataRange dataRange) {
        _movie = movie;
        _daysRented = (int) ((dataRange.getEnd().getTime() - dataRange.getStart().getTime()) / (1000 * 60 * 60 * 24));
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public String getTitle() {
        return _movie.get_title();
    }

    public int getPriceCode() {
        return _movie.get_priceCode();
    }

    public void set_movie(Movie _movie) {
        this._movie = _movie;
    }

    public void set_daysRented(int _daysRented) {
        this._daysRented = _daysRented;
    }

    public Movie get_movie() {

        return _movie;
    }

    public int get_daysRented() {
        return _daysRented;
    }

    double getCharge() {
        return _movie.getCharge(_daysRented);
    }

    int getFrequentRenterPoints(){
        return _movie.getfrequentRenterPoints(_daysRented);
    }
}

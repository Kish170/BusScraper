public class TripResults {
    public TripResults(float price, String departureLoc, String destinationLoc, int travelers, int duration, String provider, int stops, Date date, String departureTime, String arrivalTime) {
        this.price = price;
        this.departureLoc = departureLoc;
        this.destinationLoc = destinationLoc;
        this.travelers = travelers;
        this.duration = duration;
        this.provider = provider;
        this.stops = stops;
        this.date = date;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public String getDepartureLoc() {
        return departureLoc;
    }
    public void setDepartureLoc(String departureLoc) {
        this.departureLoc = departureLoc;
    }
    public String getDestinationLoc() {
        return destinationLoc;
    }
    public void setDestinationLoc(String destinationLoc) {
        this.destinationLoc = destinationLoc;
    }
    public int getTravelers() {
        return travelers;
    }
    public void setTravelers(int travelers) {
        this.travelers = travelers;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getProvider() {
        return provider;
    }
    public void setProvider(String provider) {
        this.provider = provider;
    }
    public int getStops() {
        return stops;
    }
    public void setStops(int stops) {
        this.stops = stops;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public String getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    @Override
    public String toString() {
        return "TripResults{" +
                "departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", price=" + price +
                ", departureLoc='" + departureLoc + '\'' +
                ", destinationLoc='" + destinationLoc + '\'' +
                ", travelers=" + travelers +
                ", duration=" + duration +
                ", provider='" + provider + '\'' +
                ", stops=" + stops +
                ", date=" + date +
                '}';
    }
    //private String tripType; deal with this later
    private String departureTime;
    private String arrivalTime;
    private float price;
    private String departureLoc;
    private String destinationLoc;
    private int travelers;
    private int duration;
    private String provider;
    private int stops;
    private Date date;
}

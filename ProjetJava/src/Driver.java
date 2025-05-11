public class Driver {
  private String name;
  private String licenseNumber;

  public Driver(String name, String licenseNumber) {
      this.name = name;
      this.licenseNumber = licenseNumber;
  }

  // Méthode pour créer une course
  public Trip createTrip(Itinerary itinerary, Preferences preferences, String date) {
    return new Trip(this, itinerary, preferences, date);
}

}
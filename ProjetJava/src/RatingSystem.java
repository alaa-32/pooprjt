

import java.util.ArrayList;
import java.util.List;

// System to store and manage ratings
// Users input scores in TestRating
public class RatingSystem {
    private List<Rating> ratings; // All ratings

    public RatingSystem() {
        this.ratings = new ArrayList<>();
    }

    // Passenger rates driver, with role validation
    public void passengerRatesDriver(User passenger, User driver, int score, String comment) {
        if (!passenger.getRole().equals("Passenger") || !driver.getRole().equals("Driver")) {
            throw new IllegalArgumentException("Wrong roles, check passenger/driver!");
        }
        Rating rating = new Rating(score, comment, passenger, driver);
        ratings.add(rating);
        rating.applyRating();
    }

    // Driver rates passenger
    public void driverRatesPassenger(User driver, User passenger, int score, String comment) {
        if (!driver.getRole().equals("Driver") || !passenger.getRole().equals("Passenger")) {
            throw new IllegalArgumentException("Wrong roles, check driver/passenger!");
        }
        Rating rating = new Rating(score, comment, driver, passenger);
        ratings.add(rating);
        rating.applyRating();
    }

    // Retrieves ratings for a user
    public List<Rating> getRatingsForUser(User user) {
        List<Rating> userRatings = new ArrayList<>();
        for (Rating rating : ratings) {
            if (rating.getRated().getId().equals(user.getId())) {
                userRatings.add(rating);
            }
        }
        return userRatings;
    }
}
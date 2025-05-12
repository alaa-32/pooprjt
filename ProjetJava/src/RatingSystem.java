//ja lai changer 
import java.util.ArrayList;
import java.util.List;

public class RatingSystem {
    private List<Rating> ratings;

    public RatingSystem() {
        this.ratings = new ArrayList<>();
    }

    public void rate(User rater, User rated, int score, String comment) {
        Rating rating = new Rating(score, comment, rater, rated);
        ratings.add(rating);
        rating.applyRating();
    }

    public List<Rating> getRatingsForUser(User user) {
        List<Rating> result = new ArrayList<>();
        for (Rating r : ratings) {
            if (r.getRated().getId().equals(user.getId())) {
                result.add(r);
            }
        }
        return result;
    }
}

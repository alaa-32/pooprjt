

import java.util.Date;

// Stores the score and comment for a ride, along with who rates and who is rated.
// Scores are now chosen by the user in TestRating.
public class Rating {
    
    private int score; // Score from 1 to 5
    private String comment; // Comment about the ride
    private User rater; // The one who rates
    private User rated; // The one who is rated
    private final Date ratingDate; // Date set at creation
    private static int ratingCount = 0; // Counter for ratings

    // Main constructor, validates score and saves everything
    public Rating(int score, String comment, User rater, User rated) {
        this.setScore(score);
        this.comment = comment;
        this.rater = rater;
        this.rated = rated;
        this.ratingDate = new Date();
        ratingCount++;
    }

    // Constructor without comment, for quick ratings
    public Rating(int score, User rater, User rated) {
        this(score, "No comment", rater, rated);
    }

    public int getScore() {
        return score;
    }

    // Checks that the score is between 1 and 5
    public void setScore(int score) {
        if (score >= 1 && score <= 5) {
            this.score = score;
        } else {
            throw new IllegalArgumentException("Score must be between 1 and 5, that's wrong!");
        }
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getRater() {
        return rater;
    }

    public User getRated() {
        return rated;
    }

    public Date getRatingDate() {
        return ratingDate;
    }

    // Global counter for ratings
    public static int getRatingCount() {
        return ratingCount;
    }

    // Displays the rating nicely
    @Override
    public String toString() {
        return "Rating: " + score + "/5, \"" + comment + "\", from " + rater.getLastName() +
               " for " + rated.getLastName() + ", date: " + ratingDate;
    }

    // Member 3: Applies the rating to update reputation
    public void applyRating() {
        rated.addRating(this);
    }
}
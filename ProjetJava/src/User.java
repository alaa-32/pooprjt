

import java.util.ArrayList;
import java.util.List;

// User class, for all users (students, professors, staff)
public class User {
    private String lastName; // User's last name
    private String firstName; // User's first name
    private String id; // Unique ID
    private String faculty ;
    private float reputation; // Average of scores
    private List<Rating> ratings; // Received ratings
    private String role; // Passenger or Driver

    public User(String lastName, String firstName, String id, float reputation, String role,String faculty) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
        this.reputation = reputation;
        this.ratings = new ArrayList<>();
        this.role = role;
        this.faculty = faculty;
    }

    public String getLastName() {
        return lastName+ firstName;
        
    }

    public String getId() {
        return id;
    }

    public float getReputation() {
        return reputation;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

     public String getFaculty() {
      return faculty;
  }

    // Copy of ratings to protect data
    public List<Rating> getRatings() {
        return new ArrayList<>(ratings);
    }

    // Member 3: Adds a rating and recalculates reputation
    public void addRating(Rating rating) {
        ratings.add(rating);
        updateReputation();
    }

    // Calculates the average of scores
    private void updateReputation() {
        if (ratings.isEmpty()) {
            reputation = 0.0f;
        } else {
            float sum = 0.0f;
            for (Rating rating : ratings) {
                sum += rating.getScore();
            }
            reputation = sum / ratings.size();
        }
    }
}
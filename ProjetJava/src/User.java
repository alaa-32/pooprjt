

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
    //private String role; // Passenger or Driver

   // 🔹 Constructeur minimal pour les classes filles : Student, Teacher, etc.
   public User(String id, String name) {
    this.id = id;
    this.lastName = name;  // ou tu peux changer "lastName" par "fullName" selon ton besoin
    this.firstName = "";   // vide si pas fourni
    this.faculty = "";
    this.reputation = 0.0f;
    this.ratings = new ArrayList<>();
}

// 🔹 Constructeur complet si besoin
public User(String lastName, String firstName, String id, float reputation, String faculty) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.id = id;
    this.reputation = reputation;
    this.faculty = faculty;
    this.ratings = new ArrayList<>();
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

   /*  public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
*/
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
import java.util.List;

public class Itinerary {
    private String startPoint;
    private List<String> dropPoints;

    public Itinerary(String startPoint, List<String> dropPoints) {
        this.startPoint = startPoint;
        this.dropPoints = dropPoints;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public List<String> getDropPoints() {
        return dropPoints;
    }
}

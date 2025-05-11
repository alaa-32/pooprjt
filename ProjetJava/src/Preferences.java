public class Preferences {
    private String genderPreference;
    private boolean musicAllowed;
    private boolean baggageAllowed;

    public Preferences(String genderPreference, boolean musicAllowed, boolean baggageAllowed) {
        this.genderPreference = genderPreference;
        this.musicAllowed = musicAllowed;
        this.baggageAllowed = baggageAllowed;
    }

    public String getGenderPreference() {
        return genderPreference;
    }

    public boolean isMusicAllowed() {
        return musicAllowed;
    }

    public boolean isBaggageAllowed() {
        return baggageAllowed;
    }
}

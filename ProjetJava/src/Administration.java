public class Administration {

    private User[] users;
    private Trip[] trips;
    private int userCount;
    private int tripCount;
    private int maxUsers;
    private int maxTrips;

    public Administration(int maxUsers, int maxTrips) {
        this.maxUsers = maxUsers;
        this.maxTrips = maxTrips;
        this.users = new User[maxUsers];
        this.trips = new Trip[maxTrips];
        this.userCount = 0;
        this.tripCount = 0;
    }

    // AJOUTS
    public void addUser(User u) {
        if (userCount < maxUsers && u != null) {
            users[userCount++] = u;
        }
    }

    public void addTrip(Trip t) {
        if (tripCount < maxTrips && t != null) {
            trips[tripCount++] = t;
        }
    }

    // STATISTIQUES
    public void showStatistics() {
        int students = 0, teachers = 0, staff = 0, drivers = 0, passengers = 0;
        for (int i = 0; i < userCount; i++) {
            if (users[i] != null) {
                String role = users[i].getRole();
                switch (role) {
                    case "Student": students++; break;
                    case "Teacher": teachers++; break;
                    case "Staff": staff++; break;
                    case "Driver": drivers++; break;
                    case "Passenger": passengers++; break;
                }
            }
        }

        System.out.println("=== User Statistics ===");
        System.out.println("Students   : " + students);
        System.out.println("Teachers   : " + teachers);
        System.out.println("Staff      : " + staff);
        System.out.println("Drivers    : " + drivers);
        System.out.println("Passengers : " + passengers);
    }

    // LISTE NOIRE
    public void showBlacklist() {
        System.out.println("=== Users with reputation < 2 ===");
        for (int i = 0; i < userCount; i++) {
            if (users[i] != null && users[i].getReputation() < 2) {
                System.out.println(users[i].getFullName() + " (" + users[i].getId() + ") - " + users[i].getReputation());
            }
        }
    }

    public void banLowReputationUsers() {
        System.out.println("=== Banning low reputation users ===");
        for (int i = 0; i < userCount; i++) {
            if (users[i] != null && users[i].getReputation() < 2) {
                System.out.println("Banned: " + users[i].getFullName());
                users[i] = null;
            }
        }
    }

    // TOP 10 CHAUFFEURS
    public void top10Drivers() {
        User[] drivers = new User[userCount];
        int cpt = 0;

        for (int i = 0; i < userCount; i++) {
            if (users[i] != null && users[i].getRole().equals("Driver")) {
                drivers[cpt++] = users[i];
            }
        }

        for (int i = 0; i < cpt - 1; i++) {
            for (int j = i + 1; j < cpt; j++) {
                if (drivers[i].getReputation() < drivers[j].getReputation()) {
                    User temp = drivers[i];
                    drivers[i] = drivers[j];
                    drivers[j] = temp;
                }
            }
        }

        System.out.println("=== Top 10 Drivers ===");
        for (int i = 0; i < cpt && i < 10; i++) {
            User u = drivers[i];
            System.out.println((i + 1) + ". " + u.getFullName() + " - Reputation: " + u.getReputation());
        }
    }

    // COURSES EN COURS
    public void showOngoingTrips(String now) {
        System.out.println("=== Ongoing Trips ===");
        for (int i = 0; i < tripCount; i++) {
            if (trips[i] != null && trips[i].isInProgress(now)) {
                trips[i].showTripInfo();
            }
        }
    }

    // PLANNING JOURNALIER
    public void showDailyPlanning(String date) {
        System.out.println("=== Daily Planning for " + date + " ===");
        for (int i = 0; i < tripCount; i++) {
            if (trips[i] != null && trips[i].getDate().equals(date)) {
                trips[i].showTripInfo();
            }
        }
    }

    // PLANNING HEBDOMADAIRE
    public void showWeeklyPlanning(String[] weekDates) {
        System.out.println("=== Weekly Planning ===");
        for (int i = 0; i < tripCount; i++) {
            for (String d : weekDates) {
                if (trips[i] != null && trips[i].getDate().equals(d)) {
                    trips[i].showTripInfo();
                    break;
                }
            }
        }
    }

    // HISTORIQUE DES COURSES
    public void showTripHistory() {
        System.out.println("=== Trip History ===");
        for (int i = 0; i < tripCount; i++) {
            if (trips[i] != null && trips[i].isFinished()) {
                trips[i].showTripInfo();
            }
        }
    }

    // CATÉGORIE LA PLUS ACTIVE
    public void mostActiveCategory() {
        int students = 0, teachers = 0, staff = 0;

        for (int i = 0; i < tripCount; i++) {
            if (trips[i] != null) {
                String role = trips[i].getDriver().getRole();
                if (role.equals("Student")) students++;
                else if (role.equals("Teacher")) teachers++;
                else if (role.equals("Staff")) staff++;
            }
        }

        System.out.println("=== Most Active Category ===");
        if (students >= teachers && students >= staff) System.out.println("Student");
        else if (teachers >= staff) System.out.println("Teacher");
        else System.out.println("Staff");
    }

    // FACULTÉ LA PLUS ACTIVE
    public void mostActiveFaculty() {
        String[] facs = new String[userCount];
        int[] counts = new int[userCount];
        int n = 0;

        for (int i = 0; i < tripCount; i++) {
            String fac = trips[i].getDriver().getFaculty();
            if (fac == null) continue;

            int index = -1;
            for (int j = 0; j < n; j++) {
                if (fac.equals(facs[j])) {
                    index = j;
                    break;
                }
            }

            if (index == -1) {
                facs[n] = fac;
                counts[n] = 1;
                n++;
            } else {
                counts[index]++;
            }
        }

        int max = 0;
        String topFac = "";
        for (int i = 0; i < n; i++) {
            if (counts[i] > max) {
                max = counts[i];
                topFac = facs[i];
            }
        }

        System.out.println("=== Most Active Faculty: " + topFac);
    }
}

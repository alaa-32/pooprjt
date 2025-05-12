public class Driver extends User implements Role {
    private String licenseNumber;

    // ➤ Constructeur complet
    public Driver(String id, String name, String licenseNumber) {
        super(id, name);
        this.licenseNumber = licenseNumber;
    }

    // ➤ Constructeur simplifié
    public Driver(String id, String name) {
        super(id, name);
        this.licenseNumber = "UNKNOWN"; // valeur par défaut si non précisée
    }

    @Override
    public void displayRoleInfo() {
        System.out.println("Role: Driver");
        System.out.println("License Number: " + licenseNumber);
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }
}

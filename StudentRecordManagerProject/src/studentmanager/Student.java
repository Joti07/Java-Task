package studentmanager;

public final class Student {
    // private properties (encapsulation)
    private final long id;
    private final String fullName;
    private final String bloodGroup;
    private final float cgpa;

    // constructor
    public Student(long id, String fullName, String bloodGroup, float cgpa) {
        this.id = id;
        this.fullName = fullName;
        this.bloodGroup = bloodGroup;
        this.cgpa = cgpa;
    }


    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public float getCgpa() {
        return cgpa;
    }

    // print student info (no parameter)
    public void printInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + fullName);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("CGPA: " + cgpa);
        System.out.println("----------------------");
    }

    // matching criteria (last name OR blood group)
    public boolean matches(String query) {
        // check last name
        String[] parts = fullName.trim().split("\\s+");
        String lastName = parts.length > 1 ? parts[parts.length - 1] : "";

        return lastName.equalsIgnoreCase(query) || bloodGroup.equalsIgnoreCase(query);
    }
}

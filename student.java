public class student {
    private String id;
    private String name;
    private String age;
    private String course;

    public student() {
    }

    public student(String id, String name, String age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public String setId(String id) {
        this.id = id;
        return id;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String setAge(String age) {
        this.age = age;
        return age;
    }

    public String setCourse(String course) {
        this.course = course;
        return course;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }
}

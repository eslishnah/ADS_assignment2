public class MyTestingClass {

    private int id;
    private String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // hashcode
    @Override
    public int hashCode() {
        return id * 31 + (name == null ? 0 : name.length());
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        MyTestingClass other = (MyTestingClass) obj;
        return this.id == other.id;
    }

    // optional
    @Override
    public String toString() {
        return "MyTestingClass{id=" + id + ", name='" + name + "'}";
    }
}
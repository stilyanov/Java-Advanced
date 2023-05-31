package DefiningClasses.Exercise.P01_OpinionPoll;

public class Person {
    private String name;
    private int age;

    //constructor

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        if (getAge() >= 30) {
        return String.format("%s - %d", getName(), getAge());
        }
        return "";
    }
}

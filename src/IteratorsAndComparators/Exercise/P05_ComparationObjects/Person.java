package IteratorsAndComparators.Exercise.P05_ComparationObjects;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int compareTo(Person o) {
        if (this.getName().equals(o.getName())) {
            if (this.age == o.getAge()) {
                return this.town.compareTo(o.getTown());
            } else {
                return Integer.compare(this.getAge(), o.getAge());
            }
        } else {
            return this.name.compareTo(o.getName());
        }
    }
}

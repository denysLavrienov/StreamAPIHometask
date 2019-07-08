package io.javaclasses.streamapihomework;

class Person implements Comparable<Person> {
    private String uuid;
    private String name;
    private int age;
    private int experience;
    private long salary;
    private PersonType personType;

    private Person() {

    }

    public static Builder newBuilder() {
        return new Person().new Builder();
    }

    Person(String uuid, String name, int age, int experience, long salary, PersonType personType) {
        this.uuid = uuid;
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.salary = salary;
        this.personType = personType;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private int getExperience() {
        return experience;
    }

    public long getSalary() {
        return salary;
    }

    public PersonType getPersonType() {
        return personType;
    }

    @Override
    public int compareTo(Person o) {

        return Long.compare(this.getExperience(), o.getExperience());
    }

    @Override
    public String toString() {
        return "Person{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", experience=" + experience +
                ", salary=" + salary +
                ", personType=" + personType +
                '}';
    }


    public class Builder {

        private String uuid;
        private String name;
        private int age;
        private int experience;
        private long salary;
        private PersonType personType;

        private Builder() {
        }

        public Builder setUuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setExperience(int experience) {
            this.experience = experience;
            return this;
        }

        public Builder setSalary(long salary) {
            this.salary = salary;
            return this;

        }

        public Builder setPersonType(PersonType personType) {
            this.personType = personType;
            return this;
        }

        public Person build() {
            return Person.this;
        }

    }

}

enum PersonType {
    USELESS, USEFUL
}
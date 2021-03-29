package local.snk;

public class PersonBuilder {
    private String name;
    private String login;
    private Position position;

    private PersonBuilder() {
    }

    public static PersonBuilder Person(String name) {
        return new PersonBuilder().withName(name);
    }

    public PersonBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder withLogin(String login) {
        this.login = login;
        return this;
    }

    public PersonBuilder withPosition(Position position) {
        this.position = position;
        return this;
    }

    public Person build() {
        Person newPerson = new Person();

        newPerson.setName(name);
        newPerson.setLogin(login);
        newPerson.setPosition(position);

        return newPerson;
    }

}

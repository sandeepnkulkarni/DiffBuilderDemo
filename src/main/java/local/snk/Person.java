package local.snk;

import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Person implements Diffable<Person> {
    private String login;
    private String name;
    private Position position;

    Person() {
    }

    public Person(String login, String name) {
        this.login = login;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Person{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", position=" + position +
                '}';
    }

    @Override
    public DiffResult<Person> diff(Person newPerson) {
        return new DiffBuilder<Person>(this, newPerson, ToStringStyle.JSON_STYLE)
                .append("name", this.name, newPerson.name)
                .append("login", this.login, newPerson.login)
                .append("position", this.position, newPerson.position)
                .build();
    }
}
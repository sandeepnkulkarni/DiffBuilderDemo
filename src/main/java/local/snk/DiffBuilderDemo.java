package local.snk;

import org.apache.commons.lang3.builder.Diff;
import org.apache.commons.lang3.builder.DiffResult;

public class DiffBuilderDemo {
    public static void main(String[] args) {
        Person personOld = PersonBuilder.Person("Sandeep")
                .withLogin("sandeep@abc.com")
                .withPosition(Position.Developer)
                .build();

        System.out.println(personOld);

        Person personNew = PersonBuilder.Person("Sandip")
                .withLogin("sandip@abc.com")
                .withPosition(Position.Assistant)
                .build();

        System.out.println(personNew);

        DiffResult<Person> diffResult = personOld.diff(personNew);
        System.out.println("Diff result: \n" + diffResult.toString());

        StringBuilder personDiff = new StringBuilder();
        diffResult.forEach(diff -> {
            personDiff.append( String.format("Field: %s, OldValue: %s, NewValue: %s %n", diff.getFieldName(), diff.getLeft(), diff.getRight()));
        });

        System.out.println("Custom diff result: \n" + personDiff.toString());
    }
}

package assignment.exceptionhandlingapplication.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Person {
    private Long id;
    private String name;
    private short age;
}

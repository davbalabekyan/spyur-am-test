package jdbc.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UsefulResource {

    private int id;
    private String name;
    private String href;
}

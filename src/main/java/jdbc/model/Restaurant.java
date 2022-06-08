package jdbc.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Restaurant {

    private int id;
    private String name;
    private String href;
}

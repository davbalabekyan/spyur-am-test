package jdbc.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Article {

    private int id;
    private String name;
    private String href;
}

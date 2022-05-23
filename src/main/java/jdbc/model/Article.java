package jdbc.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Article {

    private int id;
    private String name;
    private String href;
}

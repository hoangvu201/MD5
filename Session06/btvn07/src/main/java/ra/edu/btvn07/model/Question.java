package ra.edu.btvn07.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Question {
    private int id;
    private String imageUrl;
    private String answer;

    public Question() {}

    public Question(int id, String imageUrl, String answer) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.answer = answer;
    }

}

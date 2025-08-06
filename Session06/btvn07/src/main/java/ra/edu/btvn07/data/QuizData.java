    package ra.edu.btvn07.data;

    import ra.edu.btvn07.model.Question;

    import java.util.ArrayList;
    import java.util.List;

    public class QuizData {
        public static List<Question> getQuestions() {
            List<Question> list = new ArrayList<>();
            list.add(new Question(1, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/June_odd-eyed-cat.jpg/320px-June_odd-eyed-cat.jpg", "cat"));
            list.add(new Question(2, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Red_Apple.jpg/320px-Red_Apple.jpg", "apple"));
            list.add(new Question(3, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Coca-Cola_logo.svg/320px-Coca-Cola_logo.svg.png", "coca cola"));
            return list;
        }
    }

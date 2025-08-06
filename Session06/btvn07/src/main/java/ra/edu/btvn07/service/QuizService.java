package ra.edu.btvn07.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.btvn07.data.QuizData;
import ra.edu.btvn07.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuizService {
    private final List<Question> list;

    public QuizService() {
        this.list = QuizData.getQuestions();
    }

    public Question getRandomQuestion() {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }


    public boolean checkAnswer(Question question, String userAnswer) {
        if (question == null||userAnswer==null) {
            return false;
        }

        String correctAnswer = question.getAnswer();

        return correctAnswer.equalsIgnoreCase(userAnswer.trim());
    }

    public Question getQuestionById(int id) {
        return list.stream()
                .filter(q -> q.getId() == id)
                .findFirst()
                .orElse(null);
    }

}

package ra.edu.btvn07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.edu.btvn07.model.Question;
import ra.edu.btvn07.service.QuizService;

@Controller
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    private static final int MAX_ATTEMPTS = 3;

    @GetMapping
    public String showQuiz(Model model) {
        Question question = quizService.getRandomQuestion();
        model.addAttribute("question", question);
        model.addAttribute("attempts", 0);
        return "quiz";
    }

    @PostMapping("/guess")
    public String checkAnswer(@RequestParam("questionId") int questionId,
                              @RequestParam("userAnswer") String userAnswer,
                              @RequestParam("attempts") int attempts,
                              Model model) {
        attempts++;

        Question question = quizService.getQuestionById(questionId);

        model.addAttribute("attempts", attempts);
        model.addAttribute("userAnswer", userAnswer);
        model.addAttribute("question", question);

        if (quizService.checkAnswer(question, userAnswer)) {
            model.addAttribute("message", "Chính xác! Bạn đã đoán đúng.");
            model.addAttribute("success", true);
        } else if (attempts >= MAX_ATTEMPTS) {
            model.addAttribute("message", "Bạn đã hết lượt đoán. Đáp án đúng là: " + question.getAnswer());
            model.addAttribute("fail", true);
        } else {
            model.addAttribute("message", "Đáp án sai, bạn còn " + (MAX_ATTEMPTS - attempts) + " lượt đoán.");
        }

        return "quiz";
    }

}

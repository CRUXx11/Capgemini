package assignments.assignment2.classes;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Question {
    Integer questionId;
    String question;
    List<String> answerList;
    Set<String> answerSet;
    Map<Integer, String> answerMap;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<String> answerList) {
        this.answerList = answerList;
    }

    public Set<String> getAnswerSet() {
        return answerSet;
    }

    public void setAnswerSet(Set<String> answerSet) {
        this.answerSet = answerSet;
    }

    public Map<Integer, String> getAnswerMap() {
        return answerMap;
    }

    public void setAnswerMap(Map<Integer, String> answerMap) {
        this.answerMap = answerMap;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", answerList=" + answerList +
                ", answerSet=" + answerSet +
                ", answerMap=" + answerMap +
                '}';
    }
}

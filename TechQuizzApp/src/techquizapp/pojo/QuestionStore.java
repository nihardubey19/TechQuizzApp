
package techquizapp.pojo;

import java.util.ArrayList;


public class QuestionStore {
    ArrayList<Question> questionlist;
    public QuestionStore(){
        questionlist=new ArrayList<>();
    }
    
    public void addQuestion(Question p){
        questionlist.add(p);
    }
    
    public Question getQuestion(int pos){
        return questionlist.get(pos);
    }
    
    public Question getQuestionByQno(int qno){
        for(Question quest: questionlist){
            if(quest.getQno() == qno)
                return quest;
        }
        return null;
    }
    
    public void removeQuestion(int pos){
        questionlist.remove(pos);
    }
    
    public void setQuestionAt(int pos, Question q){
        questionlist.add(pos,q);
    }
    
    public ArrayList<Question> getAllQuestions(){
        return questionlist;
    }
    
    public int getCount(){
        return questionlist.size();
    }

    @Override
    public String toString() {
        return "QuestionStore{" + "questionlist=" + questionlist + '}';
    }
    
    
    
}

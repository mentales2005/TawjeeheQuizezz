package ps.projects.foxy.tawjeehequizezz.Objects;

public class Game_Question {
    private String name;
    private String f1;
    private String f2;
    private String f3;
    private String correct;

    public Game_Question(String name, String f1,String f2, String f3, String correct){
        this.name=name;
        this.f1=f1;
        this.f2=f2;
        this.f3=f3;
        this.correct=correct;

    }

    public Game_Question(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    public String getF3() {
        return f3;
    }

    public void setF3(String f3) {
        this.f3 = f3;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }
}

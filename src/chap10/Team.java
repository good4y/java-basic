package chap10;

import java.util.ArrayList;
import java.util.List;

record Affiliation(String name, String type, String countryCode) {

    @Override
    public String toString() {
        return name + " (" + type + " in " + countryCode + ")";
    }
}

// E : element
// K : key
// V : value
// T : type
// N : number
// S, U, V : 2nd, 3rd, 4th type
// T 는 player 또는 그 하위 클래스만 가능하다. -> upper bound
public class Team<T extends Player, S> {

    private String teamName;
    private List<T> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;
    private S affiliation;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, S affiliation) {
        this.teamName = teamName;
        this.affiliation = affiliation;
    }

    public void addTeamMember(T player){

        if(!teamMembers.contains(player)){
            teamMembers.add(player);
        }
    }

    public void listTeamMembers(){

        System.out.print(teamName + " Roster:");
        System.out.println((affiliation == null? "": " Affiliation: " + affiliation));
        for (T teamMember : teamMembers) {

            // 만약, 제너릭 선언 시 upper bound 설정을 하지 않았다면, Object 클래스의 메소드만 사용 가능하다.
            // 따라서 아래와 같은 name()메서드는 사용할 수 없다.
            System.out.println(teamMember.name());
        }
    }

    public int ranking(){
        return (totalLosses * 2) + totalTies + 1;
    }

    public String setScore(int ourScore, int theirScore){

        String message = "lost to";
        if(ourScore > theirScore){
            totalWins++;
            message = "beat";
        } else if(ourScore == theirScore){
            totalTies++;
            message = "tied";
        } else{
            totalLosses++;
        }

        return message;

    }

    @Override
    public String toString() {
        return teamName + " (Ranked " + ranking() + ")";
    }
}

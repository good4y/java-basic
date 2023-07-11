package chap10;

interface Player {
    String name();
}

record BaseBallPlayer(String name, String position) implements Player {
}

record FootBallPlayer(String name, String position) implements Player {
}

record VolleyballPlayer(String name, String position) implements Player {
}

public class Main {
    public static void main(String[] args) {

        Affiliation philly = new Affiliation("city", "Philadelphia, PA", "US");
        BaseballTeam phillies1 = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros1 = new BaseballTeam("Houston Astros");
        scoreResult(phillies1, 3, astros1, 5);

        SportsTeam phillies2 = new SportsTeam("Philadelphia Phillies");
        SportsTeam astros2 = new SportsTeam("Houston Astros");
        scoreResult(phillies2, 3, astros2, 5);

        // 참조 형식의 원시 타입 사용
        // 타입을 지정하지 않으면 Object 타입으로 지정된다. 따라서 런타임에 에러가 발생할 수 있다.
        Team<BaseBallPlayer, Affiliation> phillies = new Team<>("Philadelphia Phillies", philly);
        Team<BaseBallPlayer, Affiliation> astros = new Team<>("Houston Astros");
        scoreResult(phillies, 3, astros, 5);

        var harper = new BaseBallPlayer("B Harper", "Right Fielder");
        var marsh = new BaseBallPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        var guthrie = new BaseBallPlayer("D Guthrie", "Center Fielder");
        phillies.addTeamMember(guthrie);
        phillies.listTeamMembers();

        SportsTeam afc1 = new SportsTeam("adelaide Crows");
        Team<FootBallPlayer, String> afc = new Team<>("adelaide Crows",
                "City of Adelaide, South Australia, in AU");
        var tex = new FootBallPlayer("Tex Walker", "Centre half forward");
        afc.addTeamMember(tex);
        var rory = new FootBallPlayer("Rory Laird", "Midfielder");
        afc.addTeamMember(rory);
        afc.listTeamMembers();

        Team<VolleyballPlayer, Affiliation> adelaide = new Team<>("Adelaide Storm");
        adelaide.addTeamMember(new VolleyballPlayer("N Roberts", "Setter"));
        adelaide.listTeamMembers();

        var canberra = new Team<VolleyballPlayer, Affiliation>("Canberra Heat");
        canberra.addTeamMember(new VolleyballPlayer("B Black", "Opposite"));
        canberra.listTeamMembers();
        scoreResult(canberra, 0, adelaide, 1);

//        Team<Integer> melbourneVB = new Team<>("Melbourne Vipers");
    }

    public static void scoreResult(BaseballTeam team1, int t1_score,
                                   BaseballTeam team2, int t2_score) {

        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(SportsTeam team1, int t1_score,
                                   SportsTeam team2, int t2_score) {

        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(Team team1, int t1_score,
                                   Team team2, int t2_score) {

        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}

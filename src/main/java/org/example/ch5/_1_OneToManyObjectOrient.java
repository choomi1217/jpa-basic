package org.example.ch5;

public class _1_OneToManyObjectOrient {
    public static void main(String[] args) {
        ObjectOrientMember member1 = new ObjectOrientMember("member1", "회원1");
        ObjectOrientMember member2 = new ObjectOrientMember("member1", "회원1");
        ObjectOrientTeam team1 = new ObjectOrientTeam("team1", "팀1");

        member1.setTeam(team1);
        member2.setTeam(team1);

        ObjectOrientTeam findTeam = member1.getTeam();

    }
}

class ObjectOrientMember {

    private String id;
    private String username;
    private ObjectOrientTeam team;

    public ObjectOrientMember(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ObjectOrientTeam getTeam() {
        return team;
    }

    public void setTeam(ObjectOrientTeam team) {
        this.team = team;
    }
}

class ObjectOrientTeam {

    private String id;
    private String name;

    public ObjectOrientTeam(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


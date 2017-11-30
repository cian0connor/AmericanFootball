import java.io.Serializable;

public class Team implements Serializable {
    private String teamName;

    public Team(String teamName)
    {
        setTeamName(teamName);
    }

    public String getTeamName()
    {
        return teamName;
    }

    public void setTeamName(String teamName)
    {
        this.teamName = teamName;
    }

    @Override
    public String toString()
    {
        return "Team: " + teamName;
    }
}

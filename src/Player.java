public abstract class Player implements Interface {
    private String name;
    private Team team;
    private int age;


    public Player(String name, Team team, int age) {
        this.name = name;
        this.team = team;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Team getTeam()
    {
        return team;
    }

    public void setTeam(Team team)
    {
        this.team = team;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Player Name: " + getName() + "\nAge: " + getAge() + "\n" + team.toString();
    }

    public void runPlay()
    {

    }
}

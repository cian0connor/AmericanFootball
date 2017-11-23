public abstract class Player implements Interface {
    private String name;
    private Team team;
    private int age;
    private double height;


    public Player(String name, Team team, int age, double height) {
        this.name = name;
        this.team = team;
        this.age = age;
        this.height = height;
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

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    @Override
    public String toString()
    {
        return "Player Name: " + getName() + "\nAge: " + getAge() + "\n" + "\nHeight: " + getHeight() + "\n" + team.toString();
    }

    public void runPlay()
    {

    }
}

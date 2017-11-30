import java.io.Serializable;

public abstract class Player implements Interface, Serializable {
    private String name;
    private Team team;
    private int age;
    private double height;
    private int throwingPower;
    private int throwingAccuracy;
    private int catching;
    private int speed;
    private int covering;


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

    public int getThrowingPower()
    {
        return throwingPower;
    }

    public int getThrowingAccuracy()
    {
        return throwingAccuracy;
    }

    public int getCatching()
    {
        return catching;
    }

    public int getSpeed()
    {
        return speed;
    }

    public int getCovering()
    {
        return covering;
    }

    public int getOffSkill(Player y)
    {
        int offSkill = ((this.getThrowingPower() + this.getThrowingAccuracy()) + (y.getCatching()+y.getSpeed()));
        return offSkill;
    }

    public int getDefSkill()
    {
        int defSkill = ((this.getCovering() + this.getSpeed())) * 2;
        return defSkill;
    }


    @Override
    public String toString()
    {
        return "Player Name: " + getName() + "\nAge: " + getAge() + "\n" + "Height: " + getHeight() + "m\n" + team.toString();
    }


}

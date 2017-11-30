import java.io.Serializable;

public class Defender extends Player implements Serializable {
    private int covering;
    private int speed;

    public Defender(String name, Team team, int age, double height, int covering, int speed)
    {
        super(name,team,age,height);
        this.covering = covering;
        this.speed = speed;
    }

    public int getCovering()
    {
        return covering;
    }


    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public int getDefSkill()
    {
        int defSkill = ((this.getCovering() + this.getSpeed())) * 2;
        return defSkill;
    }

    @Override
    public String toString()
    {
        return super.toString() + "\nCovering skill: " + getCovering() + "\nSpeed: " + getSpeed();
    }
}

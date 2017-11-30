import java.io.Serializable;

public class Receiver extends Player implements Serializable {

    private int catching;
    private int speed;

    public Receiver(String name, Team team, int age, double height, int catching, int speed)
    {
        super(name,team,age,height);
        this.catching = catching;
        this.speed = speed;
    }

    public int getCatching()
    {
        return catching;
    }

    public void setCatching(int catching)
    {
        this.catching = catching;
    }

    public int getSpeed()
    {
        return speed;
    }

    public int getOffSkill(Player y)
    {
        int offSkill = ((this.getThrowingPower() + this.getThrowingAccuracy()) + (y.getCatching()+y.getSpeed()));
        return offSkill;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    @Override
    public String toString()
    {
        return super.toString() + "\nCatching skill: " + getCatching() + "\nSpeed: " + getSpeed();
    }




}

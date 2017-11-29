public class QB extends Player {

    private int throwingPower;
    private int throwingAccuracy;

    public QB(String name, Team team, int age, double height, int throwingPower, int throwingAccuracy)
    {
        super(name,team,age,height);
        this.throwingAccuracy = throwingAccuracy;
        this.throwingPower = throwingPower;
    }

    public int getThrowingPower()
    {
        return throwingPower;
    }

    public void setThrowingPower(int throwingPower)
    {
        this.throwingPower = throwingPower;
    }

    public int getThrowingAccuracy()
    {
        return throwingAccuracy;
    }

    public void setThrowingAccuracy(int throwingAccuracy)
    {
        this.throwingAccuracy = throwingAccuracy;
    }

    public int getOffSkill(Player y)
    {
        int offSkill = ((this.getThrowingPower() + this.getThrowingAccuracy()) + (y.getCatching()+y.getSpeed()));
        return offSkill;
    }

    @Override
    public String toString()
    {
        return super.toString() + "\nThrowing Power: " + getThrowingPower() + "\nThrowing Accuracy: " + getThrowingAccuracy();
    }
}

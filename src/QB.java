public class QB extends Player {

    private int throwingPower;
    private int throwingAccuracy;

    public QB(String name, Team team, int age, int throwingPower, int throwingAccuracy)
    {
        super(name,team,age);
        this.throwingAccuracy = throwingAccuracy;
        this.throwingPower = throwingPower;
    }

    public int getThrowingPower() {
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

    @Override
    public String toString() {
        return super.toString() + "\nPower: " + getThrowingPower() + "\nAccuracy"
    }
}

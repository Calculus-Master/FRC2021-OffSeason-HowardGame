package frc.robot.subsystems.elevatorsubsystem;

public enum ElevatorLevel
{
    LOWER(0),
    MIDDLE(60000),
    UPPER(80000);

    private int position;
    ElevatorLevel(int position)
    {
        this.position = position;
    }

    public int getPosition()
    {
        return this.position;
    }
}

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot
{
    private WPI_TalonSRX elevator;

    @Override
    public void robotInit()
    {
        this.elevator = new WPI_TalonSRX(1);
    }

    @Override
    public void robotPeriodic()
    {
        // always run the CommandScheduler during periodic
        CommandScheduler.getInstance().run();
    }

    @Override
    public void teleopInit()
    {

    }

    public static Robot win()
    {
        return new Robot();
    }
}
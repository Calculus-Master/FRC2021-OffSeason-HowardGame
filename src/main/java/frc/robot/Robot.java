package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.utils.PS4Constants;

public class Robot extends TimedRobot
{
    public static final int ELEVATOR_ID = 1;

    private WPI_TalonSRX elevator;

    private Joystick joystick;

    private JoystickButton elevatorBottomLevelButton;
    private JoystickButton elevatorMidLevelButton;
    private JoystickButton elevatorUpperLevelButton;

    @Override
    public void robotInit()
    {
        this.elevator = new WPI_TalonSRX(ELEVATOR_ID);
        this.joystick = new Joystick(0);

        this.elevatorBottomLevelButton = new JoystickButton(this.joystick, PS4Constants.CROSS.getValue());
        this.elevatorMidLevelButton = new JoystickButton(this.joystick, PS4Constants.CIRCLE.getValue());
        this.elevatorUpperLevelButton = new JoystickButton(this.joystick, PS4Constants.TRIANGLE.getValue());

        this.elevatorBottomLevelButton
                .whenPressed(() -> this.elevator.set(ControlMode.PercentOutput, 0.5))
                .whenReleased(() -> this.elevator.set(0.0));
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
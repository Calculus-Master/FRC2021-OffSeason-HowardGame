package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.armsubsystem.ArmSubsystem;
import frc.robot.subsystems.elevatorsubsystem.ElevatorLevel;
import frc.robot.subsystems.elevatorsubsystem.ElevatorSubsystem;
import frc.robot.utils.PS4Constants;

public class Robot extends TimedRobot
{
    private ArmSubsystem armSubsystem;
    private ElevatorSubsystem elevatorSubsystem;

    private Joystick joystick;

    private JoystickButton armToggleButton;

    private JoystickButton elevatorLowerLevelButton;
    private JoystickButton elevatorMiddleLevelButton;
    private JoystickButton elevatorUpperLevelButton;

    @Override
    public void robotInit()
    {
        this.armSubsystem = new ArmSubsystem().initialize();
        this.elevatorSubsystem = new ElevatorSubsystem().initialize();

        this.joystick = new Joystick(0);

        this.armToggleButton = new JoystickButton(this.joystick, PS4Constants.SQUARE.getValue()); //1

        this.elevatorLowerLevelButton = new JoystickButton(this.joystick, PS4Constants.CROSS.getValue()); //2
        this.elevatorMiddleLevelButton = new JoystickButton(this.joystick, PS4Constants.CIRCLE.getValue()); //3
        this.elevatorUpperLevelButton = new JoystickButton(this.joystick, PS4Constants.TRIANGLE.getValue()); //4

        this.armToggleButton.whenReleased(this.armSubsystem::toggleArms, this.armSubsystem);

        this.elevatorLowerLevelButton.whenReleased(() -> this.elevatorSubsystem.setLevel(ElevatorLevel.LOWER), this.elevatorSubsystem);
        this.elevatorMiddleLevelButton.whenReleased(() -> this.elevatorSubsystem.setLevel(ElevatorLevel.MIDDLE), this.elevatorSubsystem);
        this.elevatorUpperLevelButton.whenReleased(() -> this.elevatorSubsystem.setLevel(ElevatorLevel.UPPER), this.elevatorSubsystem);
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
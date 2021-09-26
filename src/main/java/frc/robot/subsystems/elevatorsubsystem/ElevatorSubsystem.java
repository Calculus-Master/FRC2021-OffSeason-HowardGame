package frc.robot.subsystems.elevatorsubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase
{
    private WPI_TalonSRX elevator;
    private ElevatorLevel level;

    public ElevatorSubsystem initialize()
    {
        this.elevator = new WPI_TalonSRX(1);
        this.elevator.config_kP(0, 5);

        this.level = ElevatorLevel.LOWER;

        return this;
    }

    public void setLevel(ElevatorLevel level)
    {
        this.level = level;
        this.elevator.set(ControlMode.MotionMagic, this.level.getPosition());
    }
}

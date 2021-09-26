package frc.robot.subsystems.armsubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase
{
    private WPI_TalonSRX leftArm;
    private WPI_TalonSRX rightArm;

    private boolean areArmsClosed;

    public ArmSubsystem initialize()
    {
        this.leftArm = new WPI_TalonSRX(2);
        this.rightArm = new WPI_TalonSRX(3);

        this.areArmsClosed = false;

        return this;
    }

    public void toggleArms()
    {
        this.areArmsClosed = !this.areArmsClosed;

        this.leftArm.set(ControlMode.PercentOutput, this.areArmsClosed ? 1.0 : 0.0);
        this.rightArm.set(ControlMode.PercentOutput, this.areArmsClosed ? 1.0 : 0.0);
    }
}

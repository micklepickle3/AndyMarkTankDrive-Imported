package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;

//change those thingies
//hello
import ; // ????????
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends SubsystemBase { 
// there are 4 motor thingies
  private WPI_TalonSRX frontLeftMaster;
  private WPI_TalonSRX frontRightMaster;
  private WPI_TalonSRX bottomLeftSlave;
  private WPI_TalonSRX bottomRightSlave; 
  // phoenix tuner is awesome sauce
  private DifferentialDrive drive;

  public Drivetrain() {
    // Assigns IDs to the motor objects; // change accordingly
    frontRightMaster = new WPI_TalonSRX(42);
    bottomLeftSlave = new WPI_TalonSRX(1);
    bottomRightSlave = new WPI_TalonSRX(3);

    // Makes one motor follow the operations of another.
    bottomLeftSlave.follow(frontLeftMaster);
    bottomRightSlave.follow(frontRightMaster);

    frontRightMaster.setInverted(true);

    drive = new DifferentialDrive(frontLeftMaster, frontRightMaster);
  }

  public void tankDriveLeft(double leftSpeed) {
    frontLeftMaster.set(leftSpeed);
  }

  public void tankDriveRight(double rightSpeed) {
    frontRightMaster.set(rightSpeed);
  }
  
  public void arcadeDrive(double output, double rotation) {
    drive.arcadeDrive(output, rotation);
  }

  public void stop(){
    drive.stopMotor();
  }
}
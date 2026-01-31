package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax; //is this right? shouldnt it be com.revrobotics.CANSparkMax?
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Drivetrain extends SubsystemBase { 
// there are 4 motor thingies
  private SparkMax frontLeftMaster;
  private SparkMax frontRightMaster;
  private SparkMax bottomLeftSlave;
  private SparkMax bottomRightSlave; 
  // phoenix tuner is awesome sauce
  private DifferentialDrive drive;

  public Drivetrain() {
    // Assigns IDs to the motor objects; // change accordingly
    frontLeftMaster = new SparkMax(0, MotorType.kBrushless);
    frontRightMaster = new SparkMax(42, MotorType.kBrushless);
    bottomLeftSlave = new SparkMax(1, MotorType.kBrushless);
    bottomRightSlave = new SparkMax(3, MotorType.kBrushless);

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
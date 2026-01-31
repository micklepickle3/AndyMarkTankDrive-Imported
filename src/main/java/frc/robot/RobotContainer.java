package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArcadeDrive;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
//awesome sauce
//why wont this push to github?

public class RobotContainer {
  // subsystem 
  int example = 0;
  private final Drivetrain m_Drivetrain = new Drivetrain();

  //controller
  private final Joystick controller = new Joystick(0); //driver station

  //axes
  private final int driveAxis = XboxController.Axis.kLeftY.value; //left joystick
  private final int rotationAxis = XboxController.Axis.kRightX.value; //right joystick

  public RobotContainer() {
    m_Drivetrain.setDefaultCommand(
      new ArcadeDrive(
        () -> controller.getRawAxis(driveAxis),
        () -> controller.getRawAxis(rotationAxis),
        m_Drivetrain
      )
    );
    configureBindings();
  }

  private void configureBindings() {
    //No buttons to configure; only joystick
  }

 
  public Command getAutonomousCommand() {
    return null;
  }
}

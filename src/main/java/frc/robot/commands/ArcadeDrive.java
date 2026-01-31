package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import java.util.function.DoubleSupplier;

import frc.robot.subsystems.Drivetrain;

public class ArcadeDrive extends Command {
  private final Drivetrain m_Drivetrain;
  private final DoubleSupplier outputSupplier;
  private final DoubleSupplier rotationSupplier;
  
  public ArcadeDrive(DoubleSupplier outputSupplier, DoubleSupplier rotationSupplier, Drivetrain m_Drivetrain) {
    this.m_Drivetrain = m_Drivetrain;
    this.outputSupplier = outputSupplier;
    this.rotationSupplier = rotationSupplier;

    addRequirements(m_Drivetrain);
  }

 
  @Override
  public void initialize() {}

  
  @Override
  public void execute() {
    m_Drivetrain.arcadeDrive(outputSupplier.getAsDouble(), rotationSupplier.getAsDouble());
  }

  @Override
  public boolean isFinished() {
    return false;
  }
 
  @Override
  public void end(boolean interrupted){
    m_Drivetrain.stop();
  }
}

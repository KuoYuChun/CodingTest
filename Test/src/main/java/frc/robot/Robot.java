/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//Part A
package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
// import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive; 






public class Robot extends TimedRobot {
  //Part B
  DifferentialDrive m_robotDrive; 
  Joystick m_stick = new Joystick(0);
  WPI_TalonSRX left; 
  WPI_TalonSRX right; 
  WPI_TalonSRX arm; 


   //Part B
  @Override
  public void robotInit() {
    //m_stick = new Joystick(0);
    left = new WPI_TalonSRX(1);
    right = new WPI_TalonSRX(2);
    arm = new WPI_TalonSRX(3);
    m_robotDrive = new DifferentialDrive(left, right); 
  }

  @Override
  public void autonomousInit() {

  }


  @Override
  public void autonomousPeriodic() {

  }


  @Override
  public void teleopInit() {
  }


   //Part C
  @Override
  public void teleopPeriodic() {
    if(m_stick.getRawAxis(5) > 0.3 || m_stick.getRawAxis(5) < -0.3)
    {
      arm.set(m_stick.getRawAxis(5)*0.5);
    }else{
      arm.set(0);
    }
    m_robotDrive.arcadeDrive(m_stick.getRawAxis(1), m_stick.getRawAxis(0)); 
 
  }

  @Override
  public void testPeriodic() {
  }
}

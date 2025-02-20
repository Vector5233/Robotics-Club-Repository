package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
// updated
//@Disabled
@TeleOp(name="learning",group="robotics club")
public class LEARNING_TO_PROGRAM extends LinearOpMode {

    DcMotor leftMotor;
    DcMotor rightMotor;
    double Left;
    double Right;
    @Override
    public void runOpMode() throws InterruptedException {
        initializedRobot();
      waitForStart();

      while (opModeIsActive()) {
          moveForward();
          turnLeft();
          moveBackward();
        }
      }



    private void moveBackward() {
    }

    private void turnLeft() {
    }

    private void moveForward() {
        Left=gamepad1.left_stick_y;
        Right=gamepad1.right_stick_y;
        leftMotor.setPower(Left);
        rightMotor.setPower(Right);

    }

    private void initializedRobot() {
        leftMotor= hardwareMap.get(DcMotor.class,"lw");
        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightMotor= hardwareMap.get(DcMotor.class,"rw");
        rightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
     }
    }


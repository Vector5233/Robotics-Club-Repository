package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
//@Disabled
@TeleOp(name="learning",group="robotics club")
public class VEXOSNEW extends LinearOpMode {

    DcMotor leftMotor;
    DcMotor rightMotor;

    DcMotor arm;
    double Left;
    double Right;
    double armPower = 1.0;

    @Override
    public void runOpMode() throws InterruptedException {
        initializedRobot();
        while (!isStarted()) {

        }
        waitForStart();

        while (opModeIsActive()) {
            moveForward();
            armLift();
            moveBackward();
        }
    }


    private void moveBackward() {
    }

    private void armLift() {
        if (gamepad1.y) {
            arm.setPower(armPower);
        } else if (gamepad1.a) {
            arm.setPower(-armPower);
        } else {
            arm.setPower(0);
        }
    }

    private void moveForward() {
        Left = gamepad1.left_stick_y;
        Right = gamepad1.right_stick_y;
        leftMotor.setPower(Left);
        rightMotor.setPower(Right);

    }

    private void initializedRobot() {
        leftMotor = hardwareMap.get(DcMotor.class, "lw");
        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightMotor = hardwareMap.get(DcMotor.class, "rw");
        rightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        //we will need to test which direction the arm is rotating in.
        // if it is rotating in the wrong direction change the direction to...
        arm = hardwareMap.get(DcMotor.class, "arm");
        arm.setDirection(DcMotorSimple.Direction.FORWARD);
        arm.setPower(armPower);
    }
}



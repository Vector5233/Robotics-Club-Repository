package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class VEXOS extends LinearOpMode{

    DcMotor arm = null;
    DcMotor lw = null;
    DcMotor rw = null;

    double ARM_TICKS_PER_DEGREE = 28 * 250047.0 / 4913 * 100 / 20 * 1 / 360;
    double ARM_COLLAPSED_INTO_ROBOT = 0;

    double ARM_COLLECT = 250 * ARM_TICKS_PER_DEGREE;

    double ARM_CLEAR_BARRIER = 230 * ARM_TICKS_PER_DEGREE;
    

    public void runOpMode() throws InterruptedException {
        initHardware();
        while (!isStarted()) {
            motorTelemetry();
        }
        waitForStart();
        while (opModeIsActive()) {
            driverControls();
        }
    }
    public void initHardware(){
                arm = hardwareMap.get(DcMotor.class, "arm");
                arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            }

            public void motorTelemetry(){


    }

    public void driverControls(){
        ((DcMotorEx) arm).setCurrentAlert(5, CurrentUnit.AMPS);
        arm.setTargetPosition(0);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }


}

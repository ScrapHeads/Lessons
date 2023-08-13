package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

//Tells the robot that it's in teleop, and the name that will show up on the drivers hub
@Autonomous(name="ForwardAndSlideAuto", group="FTCLessons")
// Makes the program not show up on the drivers hub, comment this out if you want to use the code
@Disabled
public class ForwardAndSlideAuto extends OpMode {
    private static DcMotor leftFront;
    private static DcMotor leftBack;
    private static DcMotor rightFront;
    private static DcMotor rightBack;

    // performs once when you hit the init button on the drivers hub
    @Override
    public void init() {

        // Finds the hardware who's configured name matches the name in the string
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");

        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Displays on the drivers hub when it finishes initialization
        telemetry.addData("status", "Initialized");
    }

    // called constantly while the program is running
    @Override
    public void loop() {

    }
}

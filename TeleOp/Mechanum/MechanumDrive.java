// If you have completed the Arcade drive lesson use a copy of the file you made then

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

//Tells the robot that it's in teleop, and the name that will show up on the drivers hub
@TeleOp(name="MechanumDrive", group="FTCLessons")
// Makes the program not show up on the drivers hub, comment this out if you want to use the code
@Disabled
public class MechanumDrive extends OpMode {
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

        // Displays on the drivers hub when it finishes initialization
        telemetry.addData("status", "Initialized");
    }

    // called constantly while the program is running
    @Override
    public void loop() {
        double forwards = -gamepad1.left_stick_y;
        double turning = gamepad1.right_stick_x;

        double leftFrontPower = forwards + turning;
        double leftBackPower = forwards + turning;
        double rightFrontPower = forwards - turning;
        double rightBackPower = forwards - turning;

        leftFront.setPower(leftFrontPower);
        leftBack.setPower(leftBackPower);
        rightFront.setPower(rightFrontPower);
        rightBack.setPower(rightBackPower);

        telemetry.addData("Motors", "leftFrontWheel:" + leftFront.getPower());
        telemetry.addData("Motors", "leftBackWheel:" + leftBack.getPower());
        telemetry.addData("Motors", "rightFrontWheel:" + rightFront.getPower());
        telemetry.addData("Motors", "rightBackWheel:" + rightBack.getPower());
        telemetry.addData("Input", "left y:" + gamepad1.left_stick_y +
                ", right x:" + gamepad1.right_stick_x);
    }
}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//Tells the robot that it's in teleop, and the name that will show up on the drivers hub
@TeleOp(name="OneMotorAndServoCompleted", group="FTCLessons")
// Makes the program not show up on the drivers hub, comment this out if you want to use the code
@Disabled
public class OneMotorAndServoCompleted extends OpMode {
    // Creates the Motor called testMotor and Servo called testServo
    private DcMotor testMotor = null;
    private Servo testServo = null;

    // performs once when you hit the init button on the drivers hub
    @Override
    public void init() {
        // Finds the hardware who's configured name matches the name in the string
        testMotor = hardwareMap.get(DcMotor.class, "testmotor");
        testServo = hardwareMap.get(Servo.class, "testservo");

        // Displays on the drivers hub when it finishes initialization
        telemetry.addData("status", "Initialized");
    }

    // called constantly while the program is running
    @Override
    public void loop() {
        // Grabs a power from the left joystick (from -1 to 1) It's negative because the Y direction is the opposite what we'd expect
        double motorPower = -gamepad1.left_stick_y;

        // Sets the power of the motor to make it move
        testMotor.setPower(motorPower);

        // Checks to see if certain buttons are pressed
        if (gamepad1.a) {
            // sets the servo to the high position
            testServo.setPosition(1.0);
        } else if (gamepad1.b) {
            // sets the servo to the low position
            testServo.setPosition(0.0);
        } else if (gamepad1.x) {
            // sets the servo to the center
            testServo.setPosition(0.5);
        } else if (gamepad1.right_trigger > 0.0) {
            // sets the servo to a position based on how much you press the right trigger
            testServo.setPosition(gamepad1.right_trigger);
        }
    }
}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//Tells the robot that it's in teleop, and the name that will show up on the drivers hub
@TeleOp(name="OneMotorAndServo", group="FTCLessons")
// Makes the program not show up on the drivers hub, comment this out if you want to use the code
@Disabled
public class OneMotorAndServo extends OpMode {
    // Creates the Motor called testMotor and Servo called testServo


    // performs once when you hit the init button on the drivers hub
    @Override
    public void init() {
        // Finds the hardware who's configured name matches the name in the string


        // Displays on the drivers hub when it finishes initialization
        telemetry.addData("status", "Initialized");
    }

    // called constantly while the program is running
    @Override
    public void loop() {
        // Grabs a power from the left joystick (from -1 to 1) It's negative because the Y direction is the opposite what we'd expect


        // Sets the power of the motor to make it move


        // Checks to see if certain buttons are pressed

    }
}

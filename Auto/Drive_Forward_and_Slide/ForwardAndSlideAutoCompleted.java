package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

//Tells the robot that it's in teleop, and the name that will show up on the drivers hub
@Autonomous(name="ForwardAndSlideAutoCompleted", group="FTCLessons")
// Makes the program not show up on the drivers hub, comment this out if you want to use the code
@Disabled
public class ForwardAndSlideAutoCompleted extends OpMode {
    private static DcMotor leftFront;
    private static DcMotor leftBack;
    private static DcMotor rightFront;
    private static DcMotor rightBack;

    private double startingSleepTime;
    private boolean isDoneSleeping;
    private ElapsedTime runtime = new ElapsedTime();


    enum MachineStates {
        STOPPED,
        INIT,
        MOVE_FORWARD,
        SLEEP,
        SLIDE,
        END
    }
    private MachineStates currentState;
    private MachineStates previousState;
    private boolean isFirstTimeInThisState;

    // performs once when you hit the init button on the drivers hub
    @Override
    public void init() {
        currentState = MachineStates.INIT;
        previousState = MachineStates.STOPPED;

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
        isFirstTimeInThisState = (currentState != previousState);
        previousState = currentState;

        switch (currentState) {
            case INIT:
                currentState = MachineStates.MOVE_FORWARD;
                break;

            case MOVE_FORWARD:
                if (isFirstTimeInThisState) {
                    int distance = 5000;
                    double speed = 0.5;

                    leftFront.setTargetPosition(distance);
                    leftBack.setTargetPosition(distance);
                    rightFront.setTargetPosition(distance);
                    rightBack.setTargetPosition(distance);

                    leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                    leftFront.setPower(speed);
                    leftBack.setPower(speed);
                    rightFront.setPower(speed);
                    rightBack.setPower(speed);
                }

                if (!leftFront.isBusy() || !leftBack.isBusy() || !rightFront.isBusy() || !rightBack.isBusy()) {
                    leftFront.setPower(0);
                    leftBack.setPower(0);
                    rightFront.setPower(0);
                    rightBack.setPower(0);

                    leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                    currentState = MachineStates.SLEEP;
                }

            case SLEEP:
                double SLEEP_SECONDS = 5;

                if (isFirstTimeInThisState) {
                    startingSleepTime = runtime.time();
                }

                isDoneSleeping = ((runtime.time() - startingSleepTime) > SLEEP_SECONDS);
                if (isDoneSleeping) {
                    currentState = MachineStates.SLIDE;
                }
                break;

            case SLIDE:
                if (isFirstTimeInThisState) {
                    int distance = 5000;
                    double speed = 0.5;

                    leftFront.setTargetPosition(distance);
                    leftBack.setTargetPosition(distance);
                    rightFront.setTargetPosition(distance);
                    rightBack.setTargetPosition(distance);

                    leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                    rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                    leftFront.setPower(speed);
                    leftBack.setPower(-speed);
                    rightFront.setPower(-speed);
                    rightBack.setPower(speed);
                }

                if (!leftFront.isBusy() || !leftBack.isBusy() || !rightFront.isBusy() || !rightBack.isBusy()) {
                    leftFront.setPower(0);
                    leftBack.setPower(0);
                    rightFront.setPower(0);
                    rightBack.setPower(0);

                    leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                    currentState = MachineStates.SLEEP;
                }

            case END:
                // stop driving
                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);
                break;
        }
    }
}

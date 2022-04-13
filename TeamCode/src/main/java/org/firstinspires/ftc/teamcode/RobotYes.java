/*
Copyright 2021 FIRST Tech Challenge Team 10284

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a PushBot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Remove a @Disabled the on the next line or two (if present) to add this opmode to the Driver Station OpMode list,
 * or add a @Disabled annotation to prevent this OpMode from being added to the Driver Station
 */
@TeleOp

public class RobotYes extends LinearOpMode {
    private DcMotor bLmotor;
    private DcMotor bRmotor;
    private Blinker expansion_Hub_2;
    private DcMotor fLmotor;
    private DcMotor fRmotor;
    private DcMotor SpinMotor;
    private DcMotor StrafeMotor;
    private Gyroscope imu;



    @Override
    public void runOpMode() {
        bLmotor = hardwareMap.get(DcMotor.class, "BLmotor");
        bRmotor = hardwareMap.get(DcMotor.class, "BRmotor");
        expansion_Hub_2 = hardwareMap.get(Blinker.class, "Expansion Hub 2");
        fLmotor = hardwareMap.get(DcMotor.class, "FLmotor");
        fRmotor = hardwareMap.get(DcMotor.class, "FRmotor");
        SpinMotor = hardwareMap.get(DcMotor.class, "SpinMotor");
        StrafeMotor = hardwareMap.get(DcMotor.class, "StrafeMotor");
        imu = hardwareMap.get(Gyroscope.class, "imu");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();


        double tgtPower = 0;
        double tgtPower2 = 0;
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();


            tgtPower = -this.gamepad1.right_stick_y;
            fRmotor.setPower(tgtPower);
            telemetry.addData("Target Power", tgtPower);
            telemetry.addData("Motor Power", fRmotor.getPower());
            telemetry.addData("Status", "Running");
            telemetry.update();

            tgtPower = this.gamepad1.left_stick_y;
            fLmotor.setPower(tgtPower);
            telemetry.addData("Target Power", tgtPower);
            telemetry.addData("Motor Power", fLmotor.getPower());
            telemetry.addData("Status", "Running");
            telemetry.update();

            tgtPower = -this.gamepad1.right_stick_y;
            bRmotor.setPower(tgtPower);
            telemetry.addData("Target Power", tgtPower);
            telemetry.addData("Motor Power", bRmotor.getPower());
            telemetry.addData("Status", "Running");
            telemetry.update();

            tgtPower = this.gamepad1.left_stick_y;
            bLmotor.setPower(tgtPower);
            telemetry.addData("Target Power", tgtPower);
            telemetry.addData("Motor Power", bLmotor.getPower());
            telemetry.addData("Status", "Running");
            telemetry.update();

            tgtPower2 = this.gamepad1.left_trigger;
            StrafeMotor.setPower(tgtPower2);
            telemetry.addData("Target Power", tgtPower2);
            telemetry.addData("Motor Power", StrafeMotor.getPower());
            telemetry.addData("Status", "Running");
            telemetry.update();

            tgtPower2 = -this.gamepad1.right_trigger;
            StrafeMotor.setPower(tgtPower2);
            telemetry.addData("Target Power", tgtPower2);
            telemetry.addData("Motor Power", StrafeMotor.getPower());
            telemetry.addData("Status", "Running");
            telemetry.update();


            if (gamepad1.a) {
                SpinMotor.setPower(0.70);
            }
            if (gamepad1.b) {
                SpinMotor.setPower(0);
            }
            if (gamepad1.y) {
                SpinMotor.setPower(-0.70);
            }
        }      
    }
}
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

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gyroscope;

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
@Autonomous

public class BlueAutonomous2 extends LinearOpMode {
    private DcMotor bLmotor;
    private DcMotor bRmotor;
    private Blinker expansion_Hub_2;
    private DcMotor fLmotor;
    private DcMotor fRmotor;
    private DcMotor spinMotor;
    private DcMotor StrafeMotor;
    private Gyroscope imu;


    @Override
    public void runOpMode() {
        bLmotor = hardwareMap.get(DcMotor.class, "BLmotor");
        bRmotor = hardwareMap.get(DcMotor.class, "BRmotor");
        expansion_Hub_2 = hardwareMap.get(Blinker.class, "Expansion Hub 2");
        fLmotor = hardwareMap.get(DcMotor.class, "FLmotor");
        fRmotor = hardwareMap.get(DcMotor.class, "FRmotor");
        spinMotor = hardwareMap.get(DcMotor.class, "SpinMotor");
        StrafeMotor = hardwareMap.get(DcMotor.class, "StrafeMotor");
        imu = hardwareMap.get(Gyroscope.class, "imu");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();


            class MoveRobot {

                public int duration = 1000;
                public double speed = 0.75;

                void forward(int milliseconds, double speed) {
                    //move forward |amount|
                    bRmotor.setPower(speed);
                    bLmotor.setPower(-speed);
                    fRmotor.setPower(speed);
                    fLmotor.setPower(-speed);
                    sleep(duration);
                    fLmotor.setPower(0);
                    fRmotor.setPower(0);
                    bLmotor.setPower(0);
                    bRmotor.setPower(0);
                }
                void right(int milliseconds, double speed) {
                    //turn |amount|
                    bRmotor.setPower(-speed);
                    bLmotor.setPower(-speed);
                    fRmotor.setPower(-speed);
                    fLmotor.setPower(-speed);
                    sleep(duration);
                    fLmotor.setPower(0);
                    fRmotor.setPower(0);
                    bLmotor.setPower(0);
                    bRmotor.setPower(0);
                }
                 void left(int milliseconds, double speed) {
                    //turn |amount|
                    bRmotor.setPower(speed);
                    bLmotor.setPower(speed);
                    fRmotor.setPower(speed);
                    fLmotor.setPower(speed);
                    sleep(duration);
                    fLmotor.setPower(0);
                    fRmotor.setPower(0);
                    bLmotor.setPower(0);
                    bRmotor.setPower(0);
                }
                void backward(int milliseconds, double speed) {
                    //move backward |amount|
                    bRmotor.setPower(-speed);
                    bLmotor.setPower(speed);
                    fRmotor.setPower(-speed);
                    fLmotor.setPower(speed);
                    sleep(duration);
                    fLmotor.setPower(0);
                    fRmotor.setPower(0);
                    bLmotor.setPower(0);
                    bRmotor.setPower(0);
                }



            }




            MoveRobot move = new MoveRobot();
            class StrafeRobot {

                public int duration = 1000;
                public double speed = 0.75;


                void left(int milliseconds, double speed) {
                    //strafe |amount|
                    StrafeMotor.setPower(speed);
                    sleep(duration);
                    StrafeMotor.setPower(0);
                }

                void right(int milliseconds, double speed) {
                    //strafe |amount|
                    StrafeMotor.setPower(-speed);
                    sleep(duration);
                    StrafeMotor.setPower(0);
                }
            }

            StrafeRobot strafe = new StrafeRobot();

            class SpinRobot {

                public int duration = 1000;
                public double speed = 0.75;

                void counterclockwise(int milliseconds, double speed) {
                        //strafe |amount|
                        spinMotor.setPower(-speed);
                        sleep(duration);
                        spinMotor.setPower(0);
                    }

                    void clockwise(int milliseconds, double speed) {
                        //strafe |amount|
                        spinMotor.setPower(speed);
                        sleep(duration);
                        spinMotor.setPower(0);
                    }
            }







            SpinRobot spin = new SpinRobot();



            //Start writing code here \/ \/ \/
            //-----------------------------------------------------------------------------------------------------------------

            move.right(2700,0.75);
            move.forward(9000,0.75);










        break;
        }
    }
}

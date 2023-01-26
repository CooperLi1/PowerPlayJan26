package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import org.firstinspires.ftc.teamcode.subsystems.Robot;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class JudgingOpMode extends LinearOpMode{
    private Robot robot;
    private ElapsedTime timer;

    public void runOpMode(){
        robot = new Robot(telemetry, hardwareMap);
        timer = new ElapsedTime();
        robot.init();

        waitForStart();
        timer.reset();
        while(!isStopRequested() && opModeIsActive()) {
            if (timer.seconds()<0.2){
                robot.lift.setHorizontalPosition(1);
            }else if(timer.seconds()>0.2 && timer.seconds()<1.5) {
                robot.lift.setHorizontalPosition(0.3);
                robot.turret.setTargetAngle(640);
                robot.lift.setTargetHeight(1200);
                robot.intake.liftArm();
            }else if(timer.seconds()>1.5&&timer.seconds()<2){
                robot.lift.setHorizontalPosition(1);
            }else if(timer.seconds()>2 && timer.seconds()<2.2){
                robot.intake.openClaw();
            }else if(timer.seconds()>2.2){
                robot.intake.closeClaw();
                robot.turret.setTargetAngle(0);
                robot.lift.setTargetHeight(200);
                robot.lift.setHorizontalPosition(0.3);
            }
        }
    }

}
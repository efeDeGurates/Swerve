package frc.robot.subsystems;

import org.ironmaple.simulation.drivesims.SwerveDriveSimulation;
import org.ironmaple.simulation.drivesims.SelfControlledSwerveDriveSimulation;
import org.ironmaple.simulation.drivesims.configs.DriveTrainSimulationConfig;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MapleSimSwerve implements SwerveDrive {
    private final SelfControlledSwerveDriveSimulation simulatedDrive;
    private final Field2d field2d;

    public MapleSimSwerve() {
        final DriveTrainSimulationConfig config = DriveTrainSimulationConfig.Default();

        this.simulatedDrive = new SelfControlledSwerveDriveSimulation(
                new SwerveDriveSimulation(config, new Pose2d(0, 0, new Rotation2d())));

        // Register the drivetrain simulation (kontrol et: getInstance() gerekiyor mu?)
        simulatedDrive.getInstance().addDriveTrainSimulation(simulatedDrive.getDriveTrainSimulation());

        field2d = new Field2d();
        SmartDashboard.putData("simulation field", field2d);
    }
}

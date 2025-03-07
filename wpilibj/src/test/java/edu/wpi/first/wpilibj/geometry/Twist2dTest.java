/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class Twist2dTest {
  private static final double kEpsilon = 1E-9;

  @Test
  void testStraightLineTwist() {
    var straight = new Twist2d(5.0, 0.0, 0.0);
    var straightPose = new Pose2d().exp(straight);

    assertAll(
        () -> assertEquals(straightPose.getTranslation().getX(), 5.0, kEpsilon),
        () -> assertEquals(straightPose.getTranslation().getY(), 0.0, kEpsilon),
        () -> assertEquals(straightPose.getRotation().getRadians(), 0.0, kEpsilon)
    );
  }

  @Test
  void testQuarterCirleTwist() {
    var quarterCircle = new Twist2d(5.0 / 2.0 * Math.PI, 0, Math.PI / 2.0);
    var quarterCirclePose = new Pose2d().exp(quarterCircle);

    assertAll(
        () -> assertEquals(quarterCirclePose.getTranslation().getX(), 5.0, kEpsilon),
        () -> assertEquals(quarterCirclePose.getTranslation().getY(), 5.0, kEpsilon),
        () -> assertEquals(quarterCirclePose.getRotation().getDegrees(), 90.0, kEpsilon)
    );
  }

  @Test
  void testDiagonalNoDtheta() {
    var diagonal = new Twist2d(2.0, 2.0, 0.0);
    var diagonalPose = new Pose2d().exp(diagonal);

    assertAll(
        () -> assertEquals(diagonalPose.getTranslation().getX(), 2.0, kEpsilon),
        () -> assertEquals(diagonalPose.getTranslation().getY(), 2.0, kEpsilon),
        () -> assertEquals(diagonalPose.getRotation().getDegrees(), 0.0, kEpsilon)
    );
  }

  @Test
  void testEquality() {
    var one = new Twist2d(5, 1, 3);
    var two = new Twist2d(5, 1, 3);
    assertEquals(one, two);
  }

  @Test
  void testInequality() {
    var one = new Twist2d(5, 1, 3);
    var two = new Twist2d(5, 1.2, 3);
    assertNotEquals(one, two);
  }
}

package com.codec.test;

import org.junit.Assert;

import org.junit.Test;

/**
 * Unit test for Robot.
 */
public class RobotTest 
{
     public Robot testRobot;

    @Test
    public void shouldFaceCorrectDirection(){
        testRobot = new Robot(5, 5);
        char input = 'L';

        this.testRobot.changeDirection(input);
        Assert.assertEquals("West", testRobot.currentDirection);

        this.testRobot.changeDirection(input);
        Assert.assertEquals("South", testRobot.currentDirection);
    }

    @Test
    public void shouldBeInCorrectPosition() {
        testRobot = new Robot(5, 5);

        this.testRobot.changeDirection('R');
        this.testRobot.changePosition();
        Assert.assertArrayEquals(new int[]{2, 1}, this.testRobot.currentPosition);

        this.testRobot.changeDirection('L');
        this.testRobot.changePosition();
        Assert.assertArrayEquals(new int[]{2, 2}, this.testRobot.currentPosition);
    }

    @Test
    public void shouldReturnCorrectResult() {
        testRobot = new Robot(5, 5);

        char[] input = "FFRFLFLF".toCharArray();
        Assert.assertEquals("1,4,West", this.testRobot.runMovement(input));

        testRobot = new Robot(3, 4);
        input = "FRFLFFRFL".toCharArray();
        Assert.assertEquals("3,4,North", this.testRobot.runMovement(input));
    }
}

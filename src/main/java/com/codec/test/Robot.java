package com.codec.test;
import java.util.*;

public class Robot
{
    public String currentDirection;
    public int[] currentPosition;
    public int xLimit;
    public int yLimit;
    public HashMap<List<String>, String> compass;

    public Robot(int x, int y){
        this.currentDirection = "North";
        this.currentPosition = new int[]{1, 1};
        this.xLimit = x;
        this.yLimit = y;

        this.compass = new HashMap<List<String>, String>();
        this.compass.put(Collections.unmodifiableList(Arrays.asList("North", "L")), "West");
        this.compass.put(Collections.unmodifiableList(Arrays.asList("North", "R")), "East");
        this.compass.put(Collections.unmodifiableList(Arrays.asList("South", "L")), "West");
        this.compass.put(Collections.unmodifiableList(Arrays.asList("South", "R")), "East");
        this.compass.put(Collections.unmodifiableList(Arrays.asList("East", "L")), "North");
        this.compass.put(Collections.unmodifiableList(Arrays.asList("East", "R")), "South");
        this.compass.put(Collections.unmodifiableList(Arrays.asList("West", "L")), "South");
        this.compass.put(Collections.unmodifiableList(Arrays.asList("West", "R")), "North");
    }

    public void changeDirection(char dir) {
        this.currentDirection = this.compass.get(Arrays.asList(this.currentDirection, Character.toString(dir)));
    }

    public void changePosition() {
        if(this.currentDirection.equals("North") && this.currentPosition[1] <= this.yLimit) {
            this.currentPosition[1] += 1; 
        }
        else if(this.currentDirection.equals("South") && this.currentPosition[1] >= 1){
            this.currentPosition[1] -= 1; 
        }
        else if(this.currentDirection.equals("East") && this.currentPosition[0] <= this.xLimit){
            this.currentPosition[0] += 1;
        }
        else if(this.currentDirection.equals("West") && this.currentPosition[0] >= 1){
            this.currentPosition[0] -= 1;
        }
    }

    public String runMovement(char[] input){
        for(char m : input) {
            if(m == 'F') {
                this.changePosition();
            }
            else {
                this.changeDirection(m);
            }
        }

        return this.currentPosition[0] + "," + this.currentPosition[1] + ","+ this.currentDirection;
    }

    public static void main( String[] args )
    {
       if(args.length == 2){
        char x = args[0].charAt(0);
        char y = args[0].charAt(2);
        char[] inputDirections = args[1].toCharArray();

        Robot robot = new Robot(Character.getNumericValue(x), Character.getNumericValue(y));

        System.out.println(robot.runMovement(inputDirections));
       }
       else {
        System.out.println("Please write correct input.");
       }
        
    }
}

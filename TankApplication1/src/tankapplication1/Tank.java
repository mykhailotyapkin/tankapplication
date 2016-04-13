/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankapplication1;

import java.awt.MouseInfo;



class outOfFuelException extends Exception{
    
}
/**
 *
 * @author Michael
 */
public class Tank {
    
    private double tankX = 500;
    private double tankY = 250;
    private double tankVY = 0 ;
    private double tankVX = 0;
    private int tankWidth = 42;
    private int tankHeight = 88;
    public static  int speed = 1;
    private double angle = 0;
    private boolean isRotating = false;
    private double turretX = tankX+(tankWidth/4) ;
    private double turretY = tankY + tankHeight/2;
    private int turretRadius = 40;
    private double turretAngle = 0;
    private double fuel = 10;
    private double k = 0.02;
    /**
     * @return the tankX
     */
    public double getTankX() {
        return tankX;
    }

    /**
     * @return the tankY
     */
    public double getTankY() {
        return tankY;
    }

    /**
     * @return the tankWidth
     */
    public int getTankWidth() {
        return tankWidth;
    }

    /**
     * @return the tankHeight
     */
    public int getTankHeight() {
        return tankHeight;
    }

    /**
     * @return the angle
     */
    public double getAngle() {
        return angle;
    }

    /**
     * @param angle the angle to set
     */
    public void setAngle(double angle) {
        this.angle = angle;
    }

    /**
     * @return the isRotating
     */
    public boolean IsRotating() {
        return isIsRotating();
    }

    /**
     * @param isRotating the isRotating to set
     */
    public void setIsRotating(boolean isRotating) {
        this.isRotating = isRotating;
    }

    /**
     * @return the turretX
     */
    public double getTurretX() {
        return turretX;
    }

    /**
     * @return the turretY
     */
    public double getTurretY() {
        return turretY;
    }

    /**
     * @return the turretRadius
     */
    public int getTurretRadius() {
        return turretRadius;
    }

    /**
     * @return the turretAnle
     */
    public double getTurretAngle() {
        return turretAngle;
    }

    /**
     * @param turretAnle the turretAnle to set
     */
    public void setTurretAngle(double turretAnle) {
        this.turretAngle = turretAnle;
    }

    /**
     * @param tankX the tankX to set
     */
    public void setTankX(double tankX) {
        this.tankX = tankX;
    }

    /**
     * @param tankY the tankY to set
     */
    public void setTankY(double tankY) {
        this.tankY = tankY;
    }

    /**
     * @param tankWidth the tankWidth to set
     */
    public void setTankWidth(int tankWidth) {
        this.tankWidth = tankWidth;
    }

    /**
     * @param tankHeight the tankHeight to set
     */
    public void setTankHeight(int tankHeight) {
        this.tankHeight = tankHeight;
    }

    /**
     * @return the isRotating
     */
    public boolean isIsRotating() {
        return isRotating;
    }

    /**
     * @param turretX the turretX to set
     */
    public void setTurretX(double turretX) {
        this.turretX = turretX;
    }

    /**
     * @param turretY the turretY to set
     */
    public void setTurretY(double turretY) {
        this.turretY = turretY;
    }

    /**
     * @param turretRadius the turretRadius to set
     */
    public void setTurretRadius(int turretRadius) {
        this.turretRadius = turretRadius;
    }

    /**
     * @return the fuel
     */
    public double getFuel() {
        return fuel;
    }

    /**
     * @param fuel the fuel to set
     */
    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    /**
     * @return the k
     */
    public double getK() {
        return k;
    }

    /**
     * @param k the k to set
     */
    public void setK(double k) {
        this.k = k;
    }

    /**
     * @return the tankVY
     */
    public double getTankVY() {
        return tankVY;
    }

    /**
     * @param tankVY the tankVY to set
     */
    public void setTankVY(double tankVY) {
        this.tankVY = tankVY;
    }

    /**
     * @return the tankVX
     */
    public double getTankVX() {
        return tankVX;
    }

    /**
     * @param tankVX the tankVX to set
     */
    public void setTankVX(double tankVX) {
        this.tankVX = tankVX;
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    
}

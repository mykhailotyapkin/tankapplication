/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankapplication1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.util.ArrayList;



class outOfFuelException extends Exception{
    
}

interface emptyFuel  {
    void empty() throws outOfFuelException; 
}

class OutOfBulletException extends Exception{
    
}

interface emptyAmmo{
    void outOfAmmo() throws OutOfBulletException;
}

/**
 *
 * @author Michael
 */
public class Tank implements emptyFuel , emptyAmmo {
    
    public static double tankX = 500;
    public static double tankY = 250;
    public static double tankVY = 0 ;
    public static double tankVX = 0;
    public static int tankWidth = 55;
    public static int tankHeight = 110;
    public static  int speed = 1;
    public static double angle = 0;
    public static boolean isRotating = false;
    public static double turretX = tankX+(tankWidth/4) ;
    public static double turretY = tankY + tankHeight/2;
    public static int turretRadius = 40;
    public static double turretAngle = 0;
    public static double fuel = 50;
    public static double k = 0.02;
    static ArrayList bullet_list = new ArrayList();
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

    @Override
    public void empty() throws outOfFuelException {
        if(this.getFuel() <= 0){
            setTankVX(0);
            setTankVY(0);
            setSpeed(0);
            throw new outOfFuelException();
        }
    }

    @Override
    public void outOfAmmo() throws OutOfBulletException {
        if(this.bullet_list.size() >= Variables.maxBulletAmmount){
            throw new OutOfBulletException();
        }
        
    }    
}
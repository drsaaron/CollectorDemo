/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.collectorsdemo;

/**
 *
 * @author aar1069
 */
public class Vector2D {
    
    private double x;
    private double y;

    public Vector2D() {
        x = 0;
        y = 0;
    }
    
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public Vector2D plus(Vector2D v) {
        return new Vector2D(x + v.x, y + v.y);
    }
    
    public Vector2D minus(Vector2D v) {
        return new Vector2D(x - v.x, y - v.y);
    }
    
    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return "Vector2D{" + "x=" + x + ", y=" + y + '}';
    }
    
    
}

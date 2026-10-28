/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blazartech.collectorsdemo;

/**
 *
 * @author aar1069
 */
public record Vector2D(double x, double y) {

    public Vector2D() {
        this(0, 0);
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
    
}

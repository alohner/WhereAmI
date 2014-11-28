package com.example.whereami.whereami;

/**
 * Created by Quentin on 26/11/2014.
 */

public class mapPosition {
    String NamePosition;
    int X;
    int Y;

    public mapPosition(String namePosition, int x, int y) {
        NamePosition = namePosition;
        X = x;
        Y = y;
    }

    public mapPosition(String namePosition) {
        NamePosition = namePosition;
        X = 0;
        Y = 0;
    }

    public String getNamePosition() {
        return NamePosition;
    }

    public void setNamePosition(String namePosition) {
        NamePosition = namePosition;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }
}

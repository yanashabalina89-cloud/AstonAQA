package org.example.Figures;
import java.awt.*;

public abstract class Figure implements Shape {
    protected Color backgroundColor;
    protected Color borderColor;

    protected Color getBackgroundColor(){
       return backgroundColor;
    }

    protected Color getBorderColor(){
       return borderColor;
    }

    public void getInformation(){
        System.out.println("Background color: " + getBackgroundColor() +
                "\nBorder color: " + getBorderColor() +
                "\nArea: " + getArea() +
                "\nPerimeter: " + getPerimeter()
        );
    }
}

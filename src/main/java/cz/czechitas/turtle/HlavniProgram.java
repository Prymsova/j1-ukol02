package cz.czechitas.turtle;

import dev.czechitas.java1.turtle.engine.Turtle;

public class HlavniProgram {
    private Turtle zofka = new Turtle();

    public static void main(String[] args) {
        new HlavniProgram().start();
    }

    public void start() {
        if (zofka.isPenDrawing()) {
            zofka.penUp();
        }
        nakresliRovnostrannyTrojuhelnik(50.0);
        nakresliCtverec(100.0);
        nakresliObdelnik(150.0, 250.0);

        zofka.turnRight(90);
        zofka.move(450);
        zofka.turnLeft(90);

        nakresliKolecko(50.0);
        nakresliKolecko(100);
        nakresliKolecko(200);
    }

    public void nakresliRovnostrannyTrojuhelnik(double velikostStrany) {
        if (!zofka.isPenDrawing()) {
            zofka.penDown();
        }
        for (int i = 0; i < 3; i++) {
            zofka.move(velikostStrany);
            zofka.turnLeft(120.0);
        }
        zofka.penUp();
    }

    public void nakresliCtverec(double velikostStrany) {
        if (!zofka.isPenDrawing()) {
            zofka.penDown();
        }
        for (int i = 0; i < 4; i++) {
            zofka.move(velikostStrany);
            zofka.turnLeft(90.0);
        }
        zofka.penUp();
    }

    public void nakresliObdelnik(double velikostStranyA, double velikostStranyB) {
        if (!zofka.isPenDrawing()) {
            zofka.penDown();
        }
        for (int i = 0; i < 2; i++) {
            zofka.move(velikostStranyA);
            zofka.turnLeft(90.0);
            zofka.move(velikostStranyB);
            zofka.turnLeft(90.0);
        }
        zofka.penUp();
    }

    public void nakresliKolecko(double polomer) {
        if (!zofka.isPenDrawing()) {
            zofka.penDown();
        }

        final double pocetStran = 50;
        double uhelRadiany = Math.PI / pocetStran;
        double uhelStupne = uhelRadiany * 360 / Math.PI;
        double delkaStrany = 2 * polomer * Math.tan(uhelRadiany);

        for (int i = 0; i < pocetStran; i++) {
            zofka.move(delkaStrany);
            zofka.turnLeft(uhelStupne);
        }

        zofka.penUp();
    }

    public void nakresliZmrzku() {
        nakresliKolecko(50);
        zofka.turnLeft(180);
        zofka.move(20);
        zofka.turnRight(90);
        nakresliRovnostrannyTrojuhelnik(100);
        zofka.turnRight(90);
    }
}

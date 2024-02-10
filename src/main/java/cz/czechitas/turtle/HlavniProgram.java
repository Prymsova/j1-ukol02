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
        /*
        nakresliRovnostrannyTrojuhelnik(50.0);
        nakresliCtverec(100.0);
        nakresliObdelnik(150.0, 250.0);

        zofka.turnRight(90);
        zofka.move(450);
        zofka.turnLeft(90);

        nakresliKolecko(50.0);
        nakresliKolecko(100);
        nakresliKolecko(200);
        */

        zofka.turnLeft(90);
        zofka.move(400);
        zofka.turnLeft(90);
        zofka.move(200);
        zofka.turnRight(180);

        nakresliZmrzku();

        zofka.turnRight(90);
        zofka.move(250);
        zofka.turnLeft(90);

        nakresliSnehulaka();

        zofka.turnRight(90);
        zofka.move(600);
        zofka.turnLeft(90);

        nakresliMasinku();
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

    public void nakresliRovnoramennyTrojuhelnik(double velikostStrany) {
        var velikostPrepony = Math.sqrt(2*Math.pow(velikostStrany, 2));

        if (!zofka.isPenDrawing()) {
            zofka.penDown();
        }
        zofka.move(velikostStrany);
        zofka.turnLeft(135.0);
        zofka.move(velikostPrepony);
        zofka.turnLeft(135.0);
        zofka.move(velikostStrany);
        zofka.turnLeft(90);
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
        zofka.turnRight(30);
        nakresliRovnostrannyTrojuhelnik(100);
        zofka.turnLeft(30);
        zofka.move(60);
        zofka.turnRight(90);
        nakresliKolecko(50);
        zofka.turnRight(90);
        zofka.move(60);
        zofka.turnLeft(180);
    }

    public void nakresliSnehulaka() {
        //nakresli spodni kouli
        zofka.turnRight(90);
        nakresliKolecko(100);
        zofka.turnLeft(90);

        //nakresli prostredni kouli
        zofka.move(200);
        zofka.turnRight(90);
        nakresliKolecko(70);
        zofka.turnLeft(90);

        //nakresli hlavu
        zofka.move(140);
        zofka.turnRight(90);
        nakresliKolecko(50);
        zofka.turnLeft(90);

        //nakresli ruce
        zofka.turnRight(180);
        zofka.move(70);
        zofka.turnLeft(90);
        zofka.move(70);
        zofka.turnRight(90);
        nakresliKolecko(30);
        zofka.turnRight(90);
        zofka.move(140);
        zofka.turnRight(90);
        nakresliKolecko(30);
        zofka.turnRight(90);

        //vrat se na zacatek
        zofka.move(70);
        zofka.turnRight(90);
        zofka.move(70+200);
        zofka.turnLeft(180);
    }

    public void nakresliMasinku() {
        nakresliObdelnik(200, 140);
        nakresliKolecko(70);

        // presun se ke stredni casti masinky
        zofka.turnLeft(90);
        zofka.move(140);
        zofka.turnRight(90);

        // nakresli prostredni cast masinky
        nakresliObdelnik(120, 220);
        zofka.turnLeft(90);
        zofka.move(80);
        nakresliKolecko(35);
        zofka.move(80);
        nakresliKolecko(35);
        zofka.move(60);

        // nakresli spicku
        zofka.turnLeft(90);
        zofka.move(35);
        zofka.turnRight(180);
        nakresliRovnoramennyTrojuhelnik(120);

        // jdi na zacatek
        zofka.move(35);
        zofka.turnRight(90);
        zofka.move(360);
        zofka.turnLeft(90);
    }
}

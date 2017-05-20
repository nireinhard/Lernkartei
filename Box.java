//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.

import java.util.ArrayList;

/**
 * Klasse, die eine Lernbox abbildet.
 * Eine Box besteht aus ANZFAECHER Fächer = Anz. der Stapel
 * Created by niklasreinhard on 20.05.17.
 */
public class Box {
    private final int ANZFAECHER = 5;

    private ArrayList<Stapel> box;

    public Box(Stapel s){
        this.box = new ArrayList<>();
        this.box.add(s);
        for(int i=1;i<ANZFAECHER;i++){
            this.box.add(new Stapel());
        }
    }

    public void abfragen(){
        int currentFach = 0;

        // gehe durch alle Fächer durch
        while(currentFach<ANZFAECHER) {
            Stapel tmp = box.get(currentFach);

            System.out.println("-----------------FACH "+ (currentFach+1) +"-----------------");

            if(tmp.getCounter() == 0){
                System.out.println("Keine Karten in diesem Fach");
            }
            //solange sich Karten im aktuellen Fach befinden
            while (tmp.getCounter() > 0) {

                // erhalte die abzufragende Karte und ihren Index
                KarteMap randomKarte = tmp.getRandomKarte();

                // Frage Karte ab
                if (Abfragen.karteAbfragen(randomKarte.getK())) {
                    System.out.println("Richtig!");
                    tmp.removeCard(randomKarte.getIndex());
                } else {
                    System.out.println("Falsch! Karte in Fach" + (currentFach + 2) + " verschoben!");
                    //Ordne Karte in den nächsten Stapel ein
                    tmp.moveCard(randomKarte.getIndex(), box.get(currentFach + 1));
                }

            }
            currentFach++;
        }

    }

    @Override
    public String toString() {
        return "Box{" +
                "ANZFAECHER=" + ANZFAECHER +
                ", box=" + box +
                '}';
    }

}

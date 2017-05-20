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
import java.util.Random;

/**
 * Diese Klasse beschreibt einen Stapel, der aus mehreren Karten bestehen kann
 * Created by niklasreinhard on 20.05.17.
 */
public class Stapel {
    private ArrayList<Karte> content;

    private int counter;

    {
        this.counter = 0;
    }

    public Stapel(ArrayList<Karte> content) {
        this.content = content;
    }

    public Stapel(){
        this.content = new ArrayList<>();
    }

    public int getCounter() {
        return counter;
    }

    public void addKarte(Karte k){
        content.add(k);
        counter++;
    }

    /**
     * Diese Methode verschiebt eine Karte in einen anderen Stapel
     * Einsatz: wenn User falsche Antwort eintippt
     * @param index der Index der entsprechenden Karte
     * @param p der Stapel, auf den die Karte verschoben werden soll
     */
    public void moveCard(int index, Stapel p){
        p.addKarte(content.get(index));
        removeCard(index);
    }

    /**
     * Löscht eine Karte aus dem Stapel
     * Einsatz: wenn User richtige Antwort eintippt
     * @param index der Index der entsprechenden Karte
     */
    public void removeCard(int index){
        content.remove(index);
        counter--;
    }

    public KarteMap getRandomKarte(){
        Random rd = new Random();
        int randomNumber = rd.nextInt(counter);
        return new KarteMap(randomNumber, content.get(randomNumber));
    }

    @Override
    public String toString() {
        return "Stapel{" +
                "content=" + content +
                '}';
    }
}

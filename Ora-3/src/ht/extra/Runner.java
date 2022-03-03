/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.extra;

/**
 *
 * @author Szabina Fodor
 */
class Runner extends Thread {

    public int tick = 1;

    public void run() {
        while (tick < 400000) {
            tick++;
        }
    }
}

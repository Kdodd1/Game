package com.company;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.awt.*;

public class Game extends Canvas implements Runnable{

    private static final long serialVersionUID = 4983030414942140047L;

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    public Game(){
        new Window(WIDTH, HEIGHT, "Deeeeez NUUUUUTS", this);
    }

    public synchronized void start(){

    }

    public void run(){

    }


    public static void main(String[] args) {
        new Game();

    }
}

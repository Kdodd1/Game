package com.company;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.awt.*;

public class Game extends Canvas implements Runnable{

    private static final long serialVersionUID = 4983030414942140047L;

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9; //Aspect Ratio

    private Thread thread;
    private boolean running = false;

    public Game(){
        new Window(WIDTH, HEIGHT, "Deeeeez NUUUUTS", this);
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();

    }
    public synchronized void Stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();

    }

    public static void main(String[] args) {
        new Game();

    }
}

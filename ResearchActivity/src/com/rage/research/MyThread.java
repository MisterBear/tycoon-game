package com.rage.research;

import android.graphics.Canvas;

public class MyThread extends Thread {
    //private GameView view;
    private boolean running = false;
    static final long FPS = 2;
   
    //public GameLoopThread(GameView view) {
    //      this.view = view;
    //}

    public void setRunning(boolean run) {
          running = run;
    }

    @Override
          public void run() {
                long ticksPS = 1000 / FPS;
                long startTime;
                long sleepTime;
                while (running) {
                       //Canvas c = null;
                       startTime = System.currentTimeMillis();
                       /*try {
                              c = view.getHolder().lockCanvas();
                              synchronized (view.getHolder()) {
                                     view.onDraw©;
                              }
                       } finally {
                              if (c != null) {
                                     view.getHolder().unlockCanvasAndPost();
                              }
                       }*/
                       sleepTime = ticksPS-(System.currentTimeMillis() - startTime);
                       try {
                              if (sleepTime > 0)
                                     sleep(sleepTime);
                              else
                                     sleep(10);
                       } catch (Exception e) {}
                }
          }
}  

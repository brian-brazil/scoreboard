package com.carolinarollergirls.scoreboard.file;

public abstract class ScoreBoardStreamToFile extends ScoreBoardToFile
{
  public ScoreBoardStreamToFile() { super(); }
  public ScoreBoardStreamToFile(String d) { super(d); }
  public ScoreBoardStreamToFile(String d, String f) { super(d, f); }

  public void start() throws Exception {
    synchronized (runLock) {
      if (!running) {
        doStart();
        running = true;
      }
    }
  }

  public void stop() {
    synchronized (runLock) {
      if (running) {
        running = false;
        doStop();
      }
    }
  }

  public boolean isRunning() { return running; }

  protected abstract void doStart() throws Exception;
  protected abstract void doStop();

  protected boolean running = false;
  protected Object runLock = new Object();
}

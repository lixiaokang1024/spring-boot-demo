package com.example.demo.aa;

public class Cell {
  private int x;
  private int y;

  public Cell(int x, int y) {
    super();
    this.x = x;
    this.y = y;
  }

  /**
   * @return the x
   */
  public int getX() {
    return x;
  }

  /**
   * @param x the x to set
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * @return the y
   */
  public int getY() {
    return y;
  }

  /**
   * @param y the y to set
   */
  public void setY(int y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return "Cell [x=" + x + ", y=" + y + "]";
  }

}
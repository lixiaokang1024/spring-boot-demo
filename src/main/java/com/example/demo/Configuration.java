package com.example.demo;

import com.example.demo.aa.Cell;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Configuration {
  public static void main(String[] args) {
    String s1 = "TH0101";
    String s2 = "TH0102";
    System.out.println("s1:" + s1.hashCode() + "s2:" + s2.hashCode());
    System.out.println(s1.hashCode() > s2.hashCode());
    List<Cell> cells = new ArrayList<>();
    cells.add(new Cell(1, 2));
    cells.add(new Cell(2, 3));
    cells.add(new Cell(1, 1));
    cells.add(new Cell(3, 2));
    testComparator(cells);
    System.out.println(cells);//[Cell [x=5, y=1], Cell [x=3, y=2], Cell [x=2, y=3]]
  }

  public static void testComparator(List<Cell> cells) {

    System.out.println(cells);//[Cell [x=2, y=3], Cell [x=5, y=1], Cell [x=3, y=2]]
    Collections.sort(cells, (o1, o2) -> {
      if (o1.getX() != o2.getX()) {
        return o1.getX() - o2.getX();
      }
      return o2.getY() - o1.getY();
    });
  }
}

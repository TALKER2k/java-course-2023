package edu.project2.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    private int row;
    private int col;
    private Type type;

    public enum Type { WALL, PASSAGE, PATH }

    public Cell(int row, int col, Type type) {
        this.row = row;
        this.col = col;
        this.type = type;
    }
}

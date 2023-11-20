package edu.project2.interfaces;

import edu.project2.models.Maze;

public interface Generator {
    Maze generate(int height, int width);
}

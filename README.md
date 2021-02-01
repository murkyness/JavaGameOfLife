# JavaGameOfLife
Java Game of Life

Doesn't work

There is something wrong with the cell updating code. I don't know what rule the cells are following but it's obviously not Conway's Game of Life. 

The two render();s in run() in Game.java are necessary. Otherwise the cells will tick but the screen won't update until two ticks later.

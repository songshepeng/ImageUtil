package com.example.command.commandutil;

/**
 * Created by baidu on 2018/10/9.
 */

public class LeftCommand implements Command {
  private  TetrisMachine machine;

    public LeftCommand(TetrisMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.toLeft();
    }
}

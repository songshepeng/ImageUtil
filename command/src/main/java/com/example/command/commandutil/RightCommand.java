package com.example.command.commandutil;

/**
 * Created by baidu on 2018/10/9.
 */

public class RightCommand implements Command {
  private  TetrisMachine machine;

    public RightCommand(TetrisMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.toRight();
    }
}

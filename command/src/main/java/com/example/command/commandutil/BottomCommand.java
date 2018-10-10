package com.example.command.commandutil;

/**
 * Created by baidu on 2018/10/9.
 */

public class BottomCommand implements Command {
  private  TetrisMachine machine;

    public BottomCommand(TetrisMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.fastToBottom();
    }
}

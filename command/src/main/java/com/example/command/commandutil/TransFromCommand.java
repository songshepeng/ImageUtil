package com.example.command.commandutil;

/**
 * Created by baidu on 2018/10/9.
 */

public class TransFromCommand implements Command {
  private  TetrisMachine machine;

    public TransFromCommand(TetrisMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.transfrom();
    }
}

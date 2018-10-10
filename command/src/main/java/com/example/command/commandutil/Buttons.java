package com.example.command.commandutil;

/**
 * Created by baidu on 2018/10/9.
 */

public class Buttons {
    private BottomCommand bottomCommand;
    private LeftCommand leftCommand;
    private RightCommand rightCommand;
    private TransFromCommand transFromCommand;

    public void setBottomCommand(BottomCommand bottomCommand){
        this.bottomCommand =bottomCommand;
    }

    public void setLeftCommand(LeftCommand leftCommand) {
        this.leftCommand = leftCommand;
    }

    public void setRightCommand(RightCommand rightCommand) {
        this.rightCommand = rightCommand;
    }

    public void setTransFromCommand(TransFromCommand transFromCommand) {
        this.transFromCommand = transFromCommand;
    }

    public void toLeft(){
        leftCommand.execute();
    }

    public void toRight(){
        rightCommand.execute();
    }

    public void toBottom(){
        bottomCommand.execute();
    }

    public void tranFrom(){
        transFromCommand.execute();
    }
}

package com.base.code.design.command.undo;

public interface Command {
	public void execute();
	public void undo();
}

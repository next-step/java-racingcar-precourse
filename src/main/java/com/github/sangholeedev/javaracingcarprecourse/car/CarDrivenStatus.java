package com.github.sangholeedev.javaracingcarprecourse.car;

public enum CarDrivenStatus {
	STOP(""), GO("-");

	private final String printString;

	CarDrivenStatus(String printString) {
		this.printString = printString;
	}

	public String print() {
		return printString;
	}
}

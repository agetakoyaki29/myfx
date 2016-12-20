package com.github.agetakoyaki29.javafx.scene.control;

import javafx.scene.canvas.Canvas;

public class GrowCanvas extends Canvas {

	@Override
	public boolean isResizable() {
		return true;
	}

	@Override
	public double minHeight(double width) {
		return 0;
	}
	@Override
	public double minWidth(double height) {
		return 0;
	}

	@Override
	public double maxHeight(double width) {
		return Double.POSITIVE_INFINITY;
	}
	@Override
	public double maxWidth(double height) {
		return Double.POSITIVE_INFINITY;
	}

	@Override
	public double prefHeight(double width) {
		return getWidth();
	}
	@Override
	public double prefWidth(double height) {
		return getWidth();
	}


}

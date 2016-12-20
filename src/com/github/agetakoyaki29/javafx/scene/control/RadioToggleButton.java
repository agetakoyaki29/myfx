package com.github.agetakoyaki29.javafx.scene.control;

import javafx.scene.Node;
import javafx.scene.control.ToggleButton;


public class RadioToggleButton extends ToggleButton {

	public RadioToggleButton() {
		super();
	}
	public RadioToggleButton(String text) {
		super(text);
	}
	public RadioToggleButton(String text, Node graphic) {
		super(text, graphic);
	}

	@Override
	public void fire() {
		if ((getToggleGroup() == null) || (!isSelected())) {
			super.fire();
		}
	}

}

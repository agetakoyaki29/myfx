package com.github.agetakoyaki29.javafx.scene.control;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;


public class UnFoTabPane extends TabPane {

	public UnFoTabPane() {
		super();
		init();
	}
	public UnFoTabPane(Tab... tabs) {
		super(tabs);
		init();
	}

	private void init() {
		// non focus
		setFocusTraversable(false);

		// focus selected tab content
//		getSelectionModel().selectedItemProperty().addListener((v, o, n) -> {
//			Tab tab = n;
//			if(tab == null) return;
//			if(tab.getContent() == null) return;
//			tab.getContent().requestFocus();
//		});

		focusedProperty().addListener((v, o, n) -> {
			Tab tab = getSelectionModel().getSelectedItem();
			if(tab == null) return;
			if(tab.getContent() == null) return;
			tab.getContent().requestFocus();
		});

		// tab trans key combination
		KeyCombination nkc1 = new KeyCodeCombination(KeyCode.TAB, KeyCombination.CONTROL_DOWN);
		KeyCombination pkc1 = new KeyCodeCombination(KeyCode.TAB, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN);
		KeyCombination nkc2 = new KeyCodeCombination(KeyCode.PAGE_DOWN, KeyCombination.CONTROL_DOWN);
		KeyCombination pkc2 = new KeyCodeCombination(KeyCode.PAGE_UP, KeyCombination.CONTROL_DOWN);

		addEventFilter(KeyEvent.KEY_PRESSED, evt -> {
			if(nkc1.match(evt) || nkc2.match(evt)) {
				if (getSelectionModel().getSelectedIndex() == (getTabs().size() - 1)) {
					getSelectionModel().selectFirst();
				} else {
					getSelectionModel().selectNext();
				}
				evt.consume();
			} else if(pkc1.match(evt) || pkc2.match(evt)) {
				if (getSelectionModel().getSelectedIndex() == 0) {
					getSelectionModel().selectLast();
				} else {
					getSelectionModel().selectPrevious();
				}
				evt.consume();
			}
		});
	}

}

package com.github.agetakoyaki29.javafx.scene.control;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class MainApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Tab[] tabs = {
				new Tab("a1", new TextArea("a1")),
				new Tab("a2", new TextArea("a2")),
				new Tab("a3", new TextArea("a3")),
				new Tab("a4", new TextArea("a4")),
		};
		UnFoTabPane tabPane = new UnFoTabPane(tabs);
		tabPane.setTabClosingPolicy(TabClosingPolicy.ALL_TABS);

		KeyCombination C_w = new KeyCodeCombination(KeyCode.W, KeyCombination.CONTROL_DOWN);
		KeyCombination C_t = new KeyCodeCombination(KeyCode.T, KeyCombination.CONTROL_DOWN);
		tabPane.addEventFilter(KeyEvent.KEY_PRESSED, evt -> {
			if(C_w.match(evt)) {
				tabPane.getTabs().remove(tabPane.getSelectionModel().getSelectedItem());
				evt.consume();
			} else if(C_t.match(evt)) {
				Tab tab = new Tab("un", new TextArea("null"));
				tabPane.getTabs().add(tab);
				tabPane.getSelectionModel().select(tab);
				evt.consume();
			}
		});

		Scene scene = new Scene(tabPane);
		scene.focusOwnerProperty().addListener((v, o, n) -> {
			System.out.println(n);
		});

		stage.setScene(scene);
		stage.show();
	}

}

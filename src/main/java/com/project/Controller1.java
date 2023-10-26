package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Controller1 implements initialize {
    private List<CompletableFuture<Void>> futures = new ArrayList<>();
    private int progress = 0;

    @FXML
    private Button button0, button1;
    @FXML
    private ImageView img00, img01, img02, img03, img04, img05, img06, img07, img08, img09, img10, img11, img12, img13,
            img14, img15, img16, img17, img18, img19, img20, img21, img22, img23;
    @FXML
    private Label loading00, loading01, loading02, loading03, loading04, loading05, loading06, loading07, loading08,
            loading09, loading10, loading11, loading12, loading13, loading14, loading15, loading16, loading17,
            loading18, loading19, loading20, loading21, loading22, loading23;
    @FXML
    private AnchorPane container;
    @FXML
    private Label text0;
    @FXML
    private Button buttonStopTask;
    @FXML
    private ProgressBar progressBar0;

    @FXML
    private void stopTask() {
        for (CompletableFuture<Void> future : futures) {
            future.cancel(true);
        }
    }

    @FXML
    public void initialize() {
        progress = 0;
        progressBar0.setProgress(0.0);
    }

    @FXML
    private void animateToView0(ActionEvent event) {
        UtilsViews.setViewAnimating("View0");
    }

    @FXML
    private void loadImage() {
        progressBar0.setProgress(0);
        LoadImage li00 = new LoadImage(loading00, img00, "/assets/image1.png", progressBar0, progress, text0);
        LoadImage li01 = new LoadImage(loading01, img01, "/assets/image1.png", progressBar0, progress, text0);
        LoadImage li02 = new LoadImage(loading02, img02, "/assets/image1.png", progressBar0, progress, text0);
        LoadImage li03 = new LoadImage(loading03, img03, "/assets/image1.png", progressBar0, progress, text0);
        LoadImage li04 = new LoadImage(loading04, img04, "/assets/image1.png", progressBar0, progress, text0);
        LoadImage li05 = new LoadImage(loading05, img05, "/assets/image1.png", progressBar0, progress, text0);
        LoadImage li06 = new LoadImage(loading06, img06, "/assets/image1.png", progressBar0, progress, text0);
        LoadImage li07 = new LoadImage(loading07, img07, "/assets/image1.png", progressBar0, progress, text0);
        LoadImage li08 = new LoadImage(loading08, img08, "/assets/image.png", progressBar0, progress, text0);
        LoadImage li09 = new LoadImage(loading09, img09, "/assets/image.png", progressBar0, progress, text0);
        LoadImage li10 = new LoadImage(loading10, img10, "/assets/image.png", progressBar0, progress, text0);
        LoadImage li11 = new LoadImage(loading11, img11, "/assets/image.png", progressBar0, progress, text0);
        LoadImage li12 = new LoadImage(loading12, img12, "/assets/image.png", progressBar0, progress, text0);
        LoadImage li13 = new LoadImage(loading13, img13, "/assets/image0.png", progressBar0, progress, text0);
        LoadImage li14 = new LoadImage(loading14, img14, "/assets/image0.png", progressBar0, progress, text0);
        LoadImage li15 = new LoadImage(loading15, img15, "/assets/image0.png", progressBar0, progress, text0);
        LoadImage li16 = new LoadImage(loading16, img16, "/assets/image0.png", progressBar0, progress, text0);
        LoadImage li17 = new LoadImage(loading17, img17, "/assets/image1.png", progressBar0, progress, text0);
        LoadImage li18 = new LoadImage(loading18, img18, "/assets/image1.png", progressBar0, progress, text0);
        LoadImage li19 = new LoadImage(loading19, img19, "/assets/image1.png", progressBar0, progress, text0);
        LoadImage li20 = new LoadImage(loading20, img20, "/assets/image0.png", progressBar0, progress, text0);
        LoadImage li21 = new LoadImage(loading21, img21, "/assets/image0.png", progressBar0, progress, text0);
        LoadImage li22 = new LoadImage(loading22, img22, "/assets/image0.png", progressBar0, progress, text0);
        LoadImage li23 = new LoadImage(loading23, img23, "/assets/image0.png", progressBar0, progress, text0);

        futures.add(CompletableFuture.runAsync(() -> li00.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li01.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li02.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li03.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li04.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li05.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li06.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li07.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li08.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li09.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li10.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li11.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li12.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li13.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li14.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li15.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li16.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li17.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li18.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li19.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li20.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li21.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li22.loadImageInBackground()));
        futures.add(CompletableFuture.runAsync(() -> li23.loadImageInBackground()));
    }
}
package com.project;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoadImage {
    private Label loading;
    private ImageView img;
    private Consumer<Image> callBack;
    private String imagePath;

    private ProgressBar progressBar;
    private static int progress;
    private Label progressLabel;

    public void delete() {
        loading.setVisible(false);
        img.setImage(null);
    }

    public LoadImage(Label loading, ImageView img, String imagePath, ProgressBar progressBar, int progress,
            Label progressLabel) {
        this.loading = loading;
        this.img = img;
        this.callBack = getImageLoadConsumer();
        this.imagePath = imagePath;

        this.progressBar = progressBar;
        this.progress = progress;
        this.progressLabel = progressLabel;

        loading.setVisible(true);
        img.setImage(null);

    }

    public Consumer<Image> getImageLoadConsumer() {
        return (image) -> {
            System.out.println("Image loaded");
            img.setImage(image);
            loading.setVisible(false);
            progressBar.setProgress(progressBar.getProgress() + 1.0 / 24);
            progress = progress + 1;
            progressLabel.setText("Progres: " + progress + " de 24: ");
        };
    }

    public void loadImageInBackground() {

        CompletableFuture.supplyAsync(() -> {
            try {
                Random random = new Random();
                while (!Thread.currentThread().isInterrupted()) {
                    Image image = new Image(getClass().getResource(imagePath).toString());
                    Thread.sleep(random.nextInt(5000 - 500 + 1) + 500);
                    return image;
                }
                return null;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        })
                .exceptionally(ex -> {
                    ex.printStackTrace();
                    return null;
                })
                .thenAcceptAsync(content -> {
                    if (content != null) {
                        callBack.accept(content);
                    } else {
                        img.setImage(null);
                        loading.setVisible(false);
                    }
                }, Platform::runLater);
    }
}
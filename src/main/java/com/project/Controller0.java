package com.project;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

public class Controller0 {
    private ExecutorService executor = Executors.newFixedThreadPool(3);
    private Future<?> f0, f1, f2;

    private boolean tasca0Running = false;
    private boolean tasca1Running = false;
    private boolean tasca2Running = false;

    @FXML
    private Button button0, button1, button2;
    @FXML
    private Button buttonTask0, buttonTask1, buttonTask2;
    @FXML
    private ProgressBar progressBar0;
    @FXML
    private ProgressBar progressBar1;
    @FXML
    private ProgressBar progressBar2;
    @FXML
    private AnchorPane container;
    @FXML
    private Label percentatge0, percentatge1, percentatge2;

    @FXML
    private void animateToView1(ActionEvent event) {
        UtilsViews.setViewAnimating("View1");
    }

    @FXML
    private void runTask0() {
        tasca0Running = !tasca0Running;
        if (tasca0Running) {
            buttonTask0.setText("Aturar");
            backgroundTask(0);
        } else {
            buttonTask0.setText("Iniciar");
            stopTask(0);
        }
    }

    @FXML
    private void runTask1() {
        tasca1Running = !tasca1Running;
        if (tasca1Running) {
            buttonTask1.setText("Aturar");
            backgroundTask(1);
        } else {
            buttonTask1.setText("Iniciar");
            stopTask(1);
        }
    }

    @FXML
    private void runTask2() {
        tasca2Running = !tasca2Running;
        if (tasca2Running) {
            buttonTask2.setText("Aturar");
            backgroundTask(2);
        } else {
            buttonTask2.setText("Iniciar");
            stopTask(2);
        }
    }

    private void backgroundTask(int index) {
        switch (index) {
            case 0:
                f0 = executor.submit(() -> runBackgroundTask(index, progressBar0, percentatge0, buttonTask0,1,1,1,1));
                break;
            case 1:
                f1 = executor.submit(() -> runBackgroundTask(index, progressBar1, percentatge1, buttonTask1,2,4,3,5));
                break;
            case 2:
                f2 = executor.submit(() -> runBackgroundTask(index, progressBar2, percentatge2, buttonTask2,4,6,3,8));
                break;
        }
    }

    private void runBackgroundTask(int index, ProgressBar progressBar, Label percentageLabel, Button button,int  minN, int maxN, int minS, int maxS) {
        try {
            for (int i = 0; i <= 100; i++) {
                final int currentValue = i;
                i = currentValue;
                Platform.runLater(() -> {
                    double random = randomNumber(minN, maxN)/100.0;
                    double progressValue = progressBar.getProgress() + random;
                    if (progressValue >=1.0){
                        progressValue = 1.0;
                        progressBar.setProgress(1.0);
                        percentageLabel.setText(progressValue * 100 + "%");
                    }
                    progressBar.setProgress(progressValue);
                    String formattedPercentage = String.format("%.0f%%", progressValue * 100);
                    percentageLabel.setText(formattedPercentage);
                }
                );

                Thread.sleep(randomNumber(minS, maxS) * 1000); 
            }
        } catch (InterruptedException e) {
            System.out.println("Carrèga detenida");
        }

        Platform.runLater(() -> {
            button.setText("Iniciar");
            if (index == 0){
                tasca0Running = false;
            }else if (index ==1){
                tasca1Running = false;
            }else if (index ==2){                
                tasca2Running = false;
            }
        });
    }

    public void stopTask(int index) {
        switch (index) {
            case 0:
                if (f0 != null && !f0.isDone()) {
                    f0.cancel(true);
                }
                progressBar0.setProgress(0);
                percentatge0.setText("0%");
                break;
            case 1:
                if (f1 != null && !f1.isDone()) {
                    f1.cancel(true);
                }
                progressBar1.setProgress(0);
                percentatge1.setText("0%");
                break;
            case 2:
                if (f2 != null && !f2.isDone()) {
                    f2.cancel(true);
                }
                progressBar2.setProgress(0);
                percentatge2.setText("0%");
                break;
        }
    }

    public void stopExecutor() {
        executor.shutdown();
    }

    public int randomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
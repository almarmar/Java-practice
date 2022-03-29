package example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Tab tabBarChart = new Tab("BarChart",createBarChart());
        Tab tabPieChart = new Tab("PieChart",createPieChart());
        TabPane root = new TabPane();
        root.getTabs().addAll(tabBarChart, tabPieChart);
        primaryStage.setTitle("March Weather");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    private Group createBarChart(){

        Group groupChart = new Group();
        String march1 = "1", march2 = "2",march3 = "3", march4 = "4", march5 = "5", march6 = "6",march7 = "7",march8 = "8",march9 = "9",
                march10 = "10",march11 = "11",march12 = "12",march13 = "13",march14 = "14",march15 = "15",march16 = "16",march17 = "17",march18 = "18",
                march19 = "19",march20 = "20",march21 = "21",march22 = "22",march23 = "23",march24 = "24",march25 = "25",march26 = "26",march27 = "27",
                march28 = "28",march29 = "29",march30 = "30",march31 = "31";
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc = new BarChart<>(xAxis,yAxis);
        bc.setTitle("March weather");
        xAxis.setLabel("March Days");
        yAxis.setLabel("Temperature");

        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data(march1,-2));
        series.getData().add(new XYChart.Data(march2,-5));
        series.getData().add(new XYChart.Data(march3,-2));
        series.getData().add(new XYChart.Data(march4,-4));
        series.getData().add(new XYChart.Data(march5,3));
        series.getData().add(new XYChart.Data(march6,-6));
        series.getData().add(new XYChart.Data(march7,-2));
        series.getData().add(new XYChart.Data(march8,-1));
        series.getData().add(new XYChart.Data(march9,5));
        series.getData().add(new XYChart.Data(march10,1));
        series.getData().add(new XYChart.Data(march11,1));
        series.getData().add(new XYChart.Data(march12,0));
        series.getData().add(new XYChart.Data(march13,-1));
        series.getData().add(new XYChart.Data(march14,0));
        series.getData().add(new XYChart.Data(march15,3));
        series.getData().add(new XYChart.Data(march16,-1));
        series.getData().add(new XYChart.Data(march17,2));
        series.getData().add(new XYChart.Data(march18,5));
        series.getData().add(new XYChart.Data(march19,2));
        series.getData().add(new XYChart.Data(march20,4));
        series.getData().add(new XYChart.Data(march21,4));
        series.getData().add(new XYChart.Data(march22,0));
        series.getData().add(new XYChart.Data(march23,6));
        series.getData().add(new XYChart.Data(march24,1));
        series.getData().add(new XYChart.Data(march25,4));
        series.getData().add(new XYChart.Data(march26,6));
        series.getData().add(new XYChart.Data(march27,-1));
        series.getData().add(new XYChart.Data(march28,2));
        series.getData().add(new XYChart.Data(march29,4));
        series.getData().add(new XYChart.Data(march30,7));
        series.getData().add(new XYChart.Data(march31,11));

        bc.getData().addAll(series);
        groupChart.getChildren().add(bc);
        return groupChart;
    }

    private Group createPieChart(){
        Group groupChart = new Group();

        ObservableList<PieChart.Data> pieChartdata= FXCollections.observableArrayList(
                new PieChart.Data("Subzero weather",10),
                new PieChart.Data("Positive weather",18),
                new PieChart.Data("Zero weather",3));
        PieChart chart = new PieChart(pieChartdata);
        chart.setTitle("March Weather");
        chart.setLegendSide(Side.LEFT);

        Label caption = new Label("");
        caption.setTextFill(Color.DARKBLUE);
        caption.setStyle("-fx-font: 16 arial;");
        groupChart.getChildren().add(caption);

        for (PieChart.Data data : chart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
                caption.setTranslateX(e.getSceneX()-caption.getWidth()/2);
                caption.setTranslateY(e.getSceneY()-caption.getHeight());
                caption.setText(data.getPieValue()+"");
                caption.toFront();
            });
        }
        groupChart.getChildren().add(chart);
        return groupChart;
    }
}

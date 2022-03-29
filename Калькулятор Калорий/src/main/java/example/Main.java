package example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main extends Application {
    private ObservableList<Product> data = FXCollections.observableArrayList();
    private HashMap<String, Double> productsList = new HashMap<>();
    private HashMap<String, Double> addList = new HashMap<>();
    private double sum =0;
    private  Label lbl = new Label();
    private  Label label = new Label();
    private  Label sp = new Label();

    public GridPane initRootLayout() {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25));

        Font fontBig = Font.font("Constantia", FontWeight.NORMAL,26);

        Label product = new Label("Название продукта:");
        product.setFont(fontBig);
        root.add(product,0,1);

        TextField productTextField = new TextField();
        productTextField.setFont(fontBig);
        root.add(productTextField,1,1);

        Label weight = new Label("Вес (г):");
        weight.setFont(fontBig);
        root.add(weight,0,2);

        TextField weightTextField = new TextField();
        weightTextField.setFont(fontBig);
        root.add(weightTextField,1,2);

        Button btnAdd= new Button("Добавить в список");
        btnAdd.setFont(fontBig);
        Button btnClear= new Button("Очистить");
        btnClear.setFont(fontBig);
        Button btnRes = new Button("Посчитать");
        btnRes.setFont(fontBig);
        root.add(sp, 0, 7);
        root.add(lbl,0,8);
        root.add(label,0,9);
        sp.setFont(fontBig);
        label.setFont(fontBig);
        //кнопка очистки
        btnClear.setOnAction(event ->{
            weightTextField.setText("");
            productTextField.setText("");
            label.setText("");
            sp.setText("");
            lbl.setText("");
            addList.clear();
            sum = 0;
        });
        //кнопка для добавления в список
        btnAdd.setOnAction(event ->{
            String list = "";
            String weightProduct = weightTextField.getText();
            String name = productTextField.getText();
            if (productsList.containsKey(name.toLowerCase())) {
                try {
                    addList.put(name.toLowerCase(), Double.parseDouble(weightProduct));
                    weightTextField.setText("");
                    productTextField.setText("");
                    if (sp.getText() != "") {
                        sum = 0;
                        sp.setText("");
                    }
                    for (String key : addList.keySet()) {
                        list += key + " ......... " + addList.get(key) + " г. \n";
                    }
                    label.setText(list);
                    label.setTextFill(Color.BLACK);
                } catch (Exception e) {
                    label.setText("Данного продукта нет в базе!");
                    sp.setText("");
                    label.setTextFill(Color.RED);
                }
            }else{
                list="";
                System.out.println(list);
                label.setText("Данного продукта нет в базе!");
                label.setTextFill(Color.RED);
                label.setFont(fontBig);
                sp.setText("");
            }
        });
        //кнопка подсчета калорий
        btnRes.setOnAction(event -> {
            try {
                String weightProduct = weightTextField.getText();
                String name = productTextField.getText();
                if (addList.isEmpty()) {
                    if (productsList.containsKey(name.toLowerCase())) {
                        double kef = productsList.get(name.toLowerCase()) / 100 * Integer.parseInt(weightProduct);
                        lbl.setText("Итог: " + kef + " ккал");
                        lbl.setTextFill(Color.GREEN);
                        lbl.setFont(fontBig);
                    }else{
                        System.out.println("неа");
                        lbl.setText("Данного продукта нет в базе!");
                        lbl.setTextFill(Color.RED);
                        lbl.setFont(fontBig);
                        sp.setText("");
                    }
                } else {
                    for (String key : addList.keySet()) {
                        double h = addList.get(key);
                        double kef = productsList.get(key) / 100 * h;
                        sum += kef;
                    }
                    sp.setText("Итог: " + sum + " ккал");
                    sp.setTextFill(Color.GREEN);
                }
            }catch (Exception e){
                lbl.setTextFill(Color.RED);
                lbl.setText("Данного продукта нет в базе!");
                lbl.setFont(fontBig);
                sp.setText("");
                lbl.setText("");
            }
        });
        root.add(btnAdd,0,5);
        root.add(btnRes,1,5);
        root.add(btnClear,2,5);
        return root;
    }
    //для считывания данных из файла в хэш
    @Override
    public void init(){
        try{
            Scanner scf = new Scanner(new File("data.txt"));
            while (scf.hasNextLine()) {
                String l[] = null;
                l = scf.nextLine().split(",");
                productsList.put(l[0].toLowerCase(), Double.parseDouble(l[1]));
            }
        } catch (IOException e) {
            System.out.println("Ошибка в данных или в пути к файлу с данными!");
        }
    }
    //для создания окна приложения
    @Override
    public void start(Stage primaryStage) {
        GridPane root = initRootLayout();
        Scene scene = new Scene(root,1200,700);
        primaryStage.setTitle("Калькулятор калорий");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

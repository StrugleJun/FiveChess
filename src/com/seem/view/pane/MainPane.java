package com.seem.view.pane;

import com.seem.utils.Constant;
import com.seem.utils.PropertiesUtils;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * 首页面
 * 1.垂直布局
 * 2.单机游戏，网络对战，游戏设置，退出游戏
 */
public class MainPane extends VBox implements EventHandler<MouseEvent> {

    private Stage primaryStage;

    private double windowWidth;
    private double windowHeight;

    private double btnWidth;
    private double btnHeight;

    public MainPane(Stage primaryStage) {
        this.primaryStage = primaryStage;
        initData();
        //-- 界面初始化
        initPaneConfig();
        //-- 界面内容填充
        initPaneContent();
    }

    private void initData() {
        windowWidth = PropertiesUtils.getDoubleProperties(Constant.WINDOW_WIDTH);
        windowHeight = PropertiesUtils.getDoubleProperties(Constant.WINDOW_HEIGHT);
        btnWidth = Double.parseDouble(PropertiesUtils.getProperties(Constant.PANE_BTN_WIDTH));
        btnHeight = Double.parseDouble(PropertiesUtils.getProperties(Constant.PANE_BTN_HEIGHT));
    }

    private void initPaneContent() {
        String[] btnNames = {"单机游戏", "网络对战", "游戏设置", "退出游戏"};
        for (String btnName : btnNames) {
            Button btn = new Button(btnName);

            //-- 设置按钮的大小。
            btn.setPrefSize(btnWidth,btnHeight);

            //-- 把按钮添加到布局中
            this.getChildren().add(btn);

            //-- 界面元素点击事件处理
            btn.setOnMouseClicked(this);
        }
    }

    private void initPaneConfig() {
        //-- 设置对其方式后，子组件间的间距保持不变！
        this.setAlignment(Pos.CENTER);
        //-- 设置外边距 子组件与入容器之间的间距
        //this.setPadding(new Insets(5));

        //-- 如果只需要对某个子组件设置
        //this.setMargin(元素,5);

        //-- 设置内边距 组件和组件之间的距离
        this.setSpacing(10);
        // @NamedArg("image") Image image,
        // @NamedArg("repeatX") BackgroundRepeat repeatX,
        // @NamedArg("repeatY") BackgroundRepeat repeatY,
        // @NamedArg("position") BackgroundPosition position,
        // @NamedArg("size") BackgroundSize size
        // 设置背景图片！
        Background background = new Background(
                        new BackgroundImage(
                                new Image("background.jpg"),
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.CENTER,
                                null)
        );

        this.setBackground(background);
    }

    /**
     * 鼠标的点击事件，来处理切换不同的场景！
     *
     * @param event
     */
    @Override
    public void handle(MouseEvent event) {
        Button btn = (Button) event.getSource();
        Scene scene = null;
        switch (btn.getText()) {
            case "单机游戏":
                MvMPane mvMPane = new MvMPane();
                scene = new Scene(mvMPane,windowWidth,windowHeight);
                primaryStage.setTitle("单机游戏");
                break;
            case "网络对战":
                primaryStage.setTitle("网络对战");
                break;
            case "游戏设置":
                primaryStage.setTitle("游戏设置");
                break;
            case "退出游戏":
                System.exit(0);
                break;
            default:
                break;
        }
        assert scene != null;
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
package com.seem.view;

import com.seem.utils.Constant;
import com.seem.utils.PropertiesUtils;
import com.seem.view.pane.MainPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * 游戏主体有三个界面
 * 1.登陆界面
 *   1.1 登陆
 *   1.2 注册
 *      -- 不加登陆页面
 * 2.选择界面
 *   2.1 单机游戏
 *   2.2 网络游戏
 *   2.3 游戏设置
 *   2.4 游戏退出
 * 3.游戏界面
 *   3.1 落子
 *   3.2 判断输赢
 *   3.3 悔棋
 *   3.4 保存棋谱
 */
public class MainView extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        //-- 不可以改变窗口的大小
        primaryStage.setResizable(false);
        primaryStage.setTitle("五子棋");

        //--  设置场景的舞台！
        Pane pane = new MainPane(primaryStage);
        //-- 设置窗体的大小
        double width = PropertiesUtils.getDoubleProperties(Constant.WINDOW_WIDTH);
        double height = PropertiesUtils.getDoubleProperties(Constant.WINDOW_HEIGHT);
        //-- 实例化 场景对象！
        Scene scene = new Scene(pane,width, height);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


}

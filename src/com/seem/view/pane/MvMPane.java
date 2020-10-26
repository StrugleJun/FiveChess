package com.seem.view.pane;

import com.seem.utils.Constant;
import com.seem.utils.PropertiesUtils;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * MvM : Man VS Machine
 * 人机界面！！
 * 棋盘
 * 14*14 单元格
 * <p>
 * 功能按钮
 * 1.认输
 * 2.悔棋
 * 3.存盘
 * 4.复盘
 * <p>
 * 整体是垂直布局分为上下两个部分
 * 1.棋盘
 * 2.功iu能按钮
 * <p>
 * 功能按钮又是一个水平布局！！
 */
public class MvMPane extends Pane implements EventHandler<MouseEvent> {

    private HBox hBox;
    private VBox vBox;
    private Canvas canvas;
    private GraphicsContext graphicsContext2D;

    private double margin;
    private double chessSize;
    private double fiveChessWidth;
    private double fiveChessHeight;
    private double canvasWidth;
    private double canvasHeight;

    public MvMPane() {
        initData();
        initElementAndConfig();
        drawChessPane();
        //-- 把棋盘和功能按钮添加到垂直布局中
        vBox.getChildren().add(canvas);
        vBox.getChildren().add(hBox);
        //-- 把垂直布局添加到当前Pane中
        this.getChildren().add(vBox);
        //-- 给面板本身设置点击事件用于监听落子
        this.setOnMouseClicked(event -> {

            //-- 1.获取鼠标点击的坐标
            //-- x的范围
            double x = event.getX();
            //-- y的范围
            double y = event.getY();
            System.out.println("x:" + x + "\ty" + y);

            //-- 2.将坐标转换成 1-14个方格
            //-- 绘制矩形时 公式： margin + i * chessSize = x
            int i = (int) ((x - margin) / fiveChessWidth);
            int j = (int) ((y - margin) / fiveChessHeight);

            //-- 3.判断i和j是否越界
            if (((i < 1 || i > 14) || (j < 1 || j > 14))) {
                //-- 越界弹出警告框！！
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("警告");
                alert.setHeaderText("点击在棋盘之外,无效!");
                //alert.setContentText("Careful with the next step!");
                alert.showAndWait();
                return;
            }

            //-- 没有越界,开始落子
            System.out.println("i:" + i + "\tj" + j);

            //double x, double y, double w, double h
            //margin + i * chessSize = x
            //-- x
            //-- y
            //-- w == h == chessSize
            graphicsContext2D.setFill(Color.WHITE);
            graphicsContext2D.fillOval(
                    (margin + i * chessSize) - chessSize / 2,
                    (margin + j * chessSize) - chessSize / 2,
                    chessSize,
                    chessSize);

            //-- 落子成功后，判断输赢！
        });
    }

    private void initData() {
        margin = PropertiesUtils.getDoubleProperties(Constant.FIVE_CHESS_MARGIN);
        chessSize = PropertiesUtils.getDoubleProperties(Constant.FIVE_CHESS_CHESS_SIZE);
        fiveChessWidth = PropertiesUtils.getDoubleProperties(Constant.FIVE_CHESS_WIDTH);
        fiveChessHeight = PropertiesUtils.getDoubleProperties(Constant.FIVE_CHESS_HEIGHT);
        canvasWidth = PropertiesUtils.getDoubleProperties(Constant.CANVAS_WIDTH);
        canvasHeight = PropertiesUtils.getDoubleProperties(Constant.CANVAS_HEIGHT);
    }

    /**
     * 实例化各种组件
     */
    private void initElementAndConfig() {
        //-- 整体是垂直布局
        vBox = new VBox();
        /*如果设置了对其方式,Canvas的位置有问题*/
        //vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(margin / 2);

        //-- 画布用于绘制棋盘
        canvas = new Canvas(canvasWidth,
                //-- 60 = 30 + 30 即chessSize + margin
                canvasHeight);

        //-- 通过画布获取画笔！
        graphicsContext2D = canvas.getGraphicsContext2D();

        //-- 水平布局 用于放置4个功能按钮
        hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        //-- 提供几个按钮之间的间距
        hBox.setSpacing(10);

        //-- 动态生成功能按钮并添加到水平布局中
        String[] btnNames = {"认输", "悔棋", "存盘", "复盘", "返回"};
        for (String btnName : btnNames) {
            Button btn = new Button(btnName);
            btn.setPrefSize(
                    PropertiesUtils.getDoubleProperties(Constant.PANE_BTN_WIDTH),
                    PropertiesUtils.getDoubleProperties(Constant.PANE_BTN_HEIGHT));
            btn.setOnMouseClicked(this);
            hBox.getChildren().add(btn);
        }
    }


    /**
     * 绘制具体的棋盘
     */
    private void drawChessPane() {
        //-- 绘制14*14的网格

        //-- 设置整个棋盘的背景颜色
        graphicsContext2D.setFill(Color.BURLYWOOD);
        //-- 给整个棋盘填充背景颜色
        // double x, double y, double w, double h
        //-- 画布多大就填充多大
        graphicsContext2D.fillRect(0, 0, canvasWidth, canvasHeight);

        //-- 设置颜色为黑色
        //graphicsContext2D.setFill(Color.BLACK);
        //for (int i = 1 ; i <= 14 ; i ++){
        //  for (int j = 1 ; j <= 14 ; j ++){
        //        graphicsContext2D.strokeRect(margin+chessSize,margin+chessSize, i*chessSize,j*chessSize);
        //    }
        //}


        //-- 绘制天元和四星
        //-- 棋盘为15X15的，共225各交叉点。五子棋盘中间一点成为天元，四周的四点叫做星。
        //-- 天元的点在7*7上，四星点在4*4上

        //-- 14个格子 15根线
        for (int i = 0; i < 15; i++) {
            graphicsContext2D.setLineWidth(2);    //设置线条宽度，解决重绘出现重叠问题
            //画横线   (60,30),(60,60),(60,90)  x轴坐标不变，变的是y轴坐标！  变化规律间隔一个单元格的大小！
            //--double x1, double y1, double x2, double y2
            graphicsContext2D.strokeLine(margin+chessSize, margin + chessSize * i, margin + chessSize + fiveChessWidth, margin + chessSize * i);
            //画竖线  (60,30),(90,30),(120,30)        y轴坐标不变，变得是x轴坐标
            graphicsContext2D.strokeLine(margin + chessSize * i + chessSize, margin, margin + chessSize * i + chessSize, canvasHeight - chessSize);
        }

        /**
         * 天元(7,7),四个星位(3,3),(3,11),(11,3),(11,11)
         **/
        for (int i = 3; i <= 14; i += 4)
            for (int j = 3; j <= 14; ) {
                graphicsContext2D.setFill(Color.BLACK);
                //画天元
                if (i == 7) {
                    j = 7;
                    graphicsContext2D.strokeOval(i * chessSize + margin + chessSize - 5, j * chessSize + margin + chessSize - 5, 10, 10);
                    graphicsContext2D.fillOval(i * chessSize + margin + chessSize - 5, j * chessSize + margin + chessSize - 5, 10, 10);
                    break;
                }
                //画星位
                else {
                    graphicsContext2D.strokeOval(i * chessSize + margin + chessSize - 5, j * chessSize + margin + chessSize - 5, 10, 10);
                    graphicsContext2D.fillOval(i * chessSize + margin + chessSize - 5, j * chessSize + margin + chessSize - 5, 10, 10);
                    j += 8;
                }
            }

        //边框加粗
        //graphicsContext2D.setLineWidth(3.0f);
        //graphicsContext2D.strokeRect(margin + chessSize, margin + chessSize, fiveChessWidth, fiveChessHeight);
    }


    /**
     * 按钮的鼠标点击事件！
     *
     * @param event
     */
    @Override
    public void handle(MouseEvent event) {
        Button btn = (Button) event.getSource();
        switch (btn.getText()) {
            case "悔棋":
                System.out.println("悔棋");
                break;
            case "认输":
                System.out.println("认输");
                break;
            case "存盘":
                System.out.println("存盘");
                break;
            case "复盘":
                System.out.println("复盘");
                break;
            case "返回":
                System.out.println("返回");
                break;
            default:
                break;
        }
    }
}

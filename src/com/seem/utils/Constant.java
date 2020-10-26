package com.seem.utils;

/**
 * 基础配置类
 *      记录程序中的各种配置
 *
 *      0.舞台的大小
 *      1.棋盘的大小
 *      2.棋子的宽度和高度
 *      3.棋盘和舞台之间的间距
 *
 */
public interface Constant {
    String JDBC_DRIVER= "jdbc.driverClass";
    String JDBC_URL = "jdbc.jdbcUrl";
    String JDBC_USERNAME = "jdbc.username";
    String JDBC_PASSWORD = "jdbc.password";

    String WINDOW_WIDTH="window.width";
    String WINDOW_HEIGHT="window.height";

    String CANVAS_WIDTH = "canvas.width";
    String CANVAS_HEIGHT = "canvas.height";

    String FIVE_CHESS_WIDTH = "fiveChess.width";
    String FIVE_CHESS_HEIGHT = "fiveChess.height";
    String FIVE_CHESS_CHESS_SIZE="fiveChess.chessSize";
    String FIVE_CHESS_MARGIN="fiveChess.margin";
    String FIVE_CHESS_LINE_WIDTH="fiveChess.lineWidth";
    String FIVE_CHESS_DEEPEN_LINE_WIDTH="fiveChess.deepenLineWidth";

    String PANE_BTN_WIDTH = "pane.btnWidth";
    String PANE_BTN_HEIGHT = "pane.btnHeight";


}

package test.lambda;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import service.Consumer;

import java.io.PrintStream;

/**
 * @author lxc
 * @Title: MyHttpServer
 * @ProjectName lambdaTest
 * @Description: TODO
 * @date 2019/2/20 13:48
 */
public class MyHttpServer extends AbstractVerticle {
    public static void main(String[] args) {
        // 创建服务
        MyHttpServer verticle = new MyHttpServer( );
        Vertx vertx = Vertx.vertx( );

        // 部署服务，会执行MyHttpServer的start方法
        vertx.deployVerticle(verticle);
    }

    @Override
    public void start() throws Exception {
        /*// 在这里可以通过this.vertx获取到当前的Vertx
        Vertx vertx = this.vertx;

        // 创建一个HttpServer
        HttpServer server = vertx.createHttpServer( );

        server.requestHandler(IRequest::senRequestRequestMessage);

        // 指定监听80端口
        server.listen(80);*/
        Vertx.vertx().createHttpServer().requestHandler(IRequest::senRequestRequestMessage).listen(80);
        PrintStream ps = System.out;
        Consumer<String> stringConsumer = ps::println;
        stringConsumer.accecpt("服务启动成功.........................");
    }
}

@FunctionalInterface
interface IRequest{
    public void sendRequest(HttpServerRequest request);

    public static void senRequestRequestMessage(HttpServerRequest request){
        // 获取到response对象
        HttpServerResponse response = request.response( );

        // 设置响应头
        response.putHeader("Content-type", "text/html;charset=utf-8");

        // 响应数据
        response.end("<h2>vert.x框架搭建成功!</h2>");
    }
}

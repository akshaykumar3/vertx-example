/**
 *
 */
package verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.core.logging.Logger;
import io.vertx.ext.web.Router;
import utils.LogFactory;

/**
 * @author akshay.kumar
 */
public class SimpleVerticle extends AbstractVerticle {

    private static final Logger logger = LogFactory.getLogger(SimpleVerticle.class);
    private HttpServer server = null;

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        vertx.eventBus().consumer("test-topic", handler -> {
            logger.info("handler.body() = "+handler.body().toString());
        });

        server = vertx.createHttpServer();
        Router router = Router.router(vertx);

        logger.info("Starting server");
        server.requestHandler(router::accept).listen(config().getInteger("server_port", 8080));
    }

    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        // TODO Auto-generated method stub
        super.stop(stopFuture);
    }

}

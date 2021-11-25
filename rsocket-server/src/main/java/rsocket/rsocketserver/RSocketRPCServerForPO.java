package rsocket.rsocketserver;

import com.test.rsocket.server.rsocketserver.ProductOrderRequest;
import com.test.rsocket.server.rsocketserver.ProductOrderResponse;
import com.test.rsocket.server.rsocketserver.ProductOrderService;
import com.test.rsocket.server.rsocketserver.ProductOrderServiceServer;
import io.netty.buffer.ByteBuf;
import io.rsocket.core.RSocketServer;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.server.TcpServerTransport;
import reactor.core.publisher.Mono;

import java.util.Optional;

public class RSocketRPCServerForPO {

    public static void main(String[] args) throws InterruptedException {
        RSocketServer.create().payloadDecoder(PayloadDecoder.ZERO_COPY)
                .acceptor((connectionSetupPayload, rSocket) -> Mono.just(new ProductOrderServiceServer(new DefaultService(), Optional.empty(), Optional.empty(), Optional.empty())))
                .bind(TcpServerTransport.create("localhost", 8888))
                .block();
        Thread.currentThread().join();
    }
    private static Mono<ProductOrderResponse> productOrderProtobufResponse = Mono.just(ProductOrderProtobufResponseBuilder.prepareProductOrderResponse());
    
    static class DefaultService implements ProductOrderService {

        @Override
        public Mono<ProductOrderResponse> getProductOrder(ProductOrderRequest message, ByteBuf metadata) {
            readRequest(message);
            return productOrderProtobufResponse;
        }
        private void readRequest(ProductOrderRequest request) {
    		request.getId();
    	}
    }

}

package rsocketclient.rsocketclient;

import com.test.rsocket.server.rsocketserver.ProductOrderRequest;
import com.test.rsocket.server.rsocketserver.ProductOrderResponse;
import com.test.rsocket.server.rsocketserver.ProductOrderServiceGrpc;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GRPCServerForPO {

    public static void main(String[] args) throws IOException, InterruptedException {
        io.grpc.Server start = ServerBuilder.forPort(9977)
                .addService(new DefaultService())
                .build()
                .start();
        start.awaitTermination();
    }

    private static ProductOrderResponse productOrderResponse = ProductOrderProtobufResponseBuilder.prepareProductOrderResponse();
    
    static class DefaultService extends ProductOrderServiceGrpc.ProductOrderServiceImplBase {
        @Override
        public void getProductOrder(ProductOrderRequest request,
                                    io.grpc.stub.StreamObserver<ProductOrderResponse> responseObserver) {
            readRequest(request);
            responseObserver.onNext(productOrderResponse);
            responseObserver.onCompleted();
        }
        private void readRequest(ProductOrderRequest request) {
    		request.getId();
    	}
    }
}

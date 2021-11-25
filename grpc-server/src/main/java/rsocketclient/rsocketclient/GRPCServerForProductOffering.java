package rsocketclient.rsocketclient;

import java.io.IOException;

import com.test.productOffering.model.ProductOfferingServiceGrpc.ProductOfferingServiceImplBase;
import com.test.productOffering.model.ProductOfferings;

import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class GRPCServerForProductOffering {

    public static void main(String[] args) throws IOException, InterruptedException {
        io.grpc.Server start = ServerBuilder.forPort(9988)
                .addService(new DefaultService())
                .build()
                .start();
        start.awaitTermination();
    }

    
    static class DefaultService extends ProductOfferingServiceImplBase {
    	
        @Override
		public void getProductOfferings(ProductOfferings request, StreamObserver<ProductOfferings> responseObserver) {
			ProductOfferingsReader.readRequest(request);
			responseObserver.onNext(request);
            responseObserver.onCompleted();
		}
    }
}
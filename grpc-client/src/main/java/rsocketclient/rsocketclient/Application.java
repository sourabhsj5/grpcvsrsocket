package rsocketclient.rsocketclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.productOffering.model.ProductOfferingServiceGrpc;
import com.test.productOffering.model.ProductOfferings;
import com.test.rsocket.server.rsocketserver.ProductOrderRequest;
import com.test.rsocket.server.rsocketserver.ProductOrderResponse;
import com.test.rsocket.server.rsocketserver.ProductOrderServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


@RestController
class HandleOrderController {

	ManagedChannel managedChannelOrder = ManagedChannelBuilder.forAddress("localhost", 9977).usePlaintext().build();
    ManagedChannel managedChannelOffering = ManagedChannelBuilder.forAddress("localhost", 9988).usePlaintext().build();
    ProductOrderServiceGrpc.ProductOrderServiceBlockingStub productOrderServiceStub = ProductOrderServiceGrpc
            .newBlockingStub(managedChannelOrder);
    ProductOfferingServiceGrpc.ProductOfferingServiceBlockingStub productOfferingServiceStub = ProductOfferingServiceGrpc
            .newBlockingStub(managedChannelOffering);
    static ProductOrderRequest productOrderRequest = ProductOrderRequest.newBuilder().setId("asdasdadas").build();
    static ProductOfferings productOfferingsRequest = ProductOfferingsRequestBuilder.prepareProductOfferingsRequest();
    @GetMapping("/handleOrder")
    public void handleOrder() {
    	ProductOrderResponse productResponse = productOrderServiceStub.getProductOrder(productOrderRequest);
       ProductOrderProtobufResponseReader.readProductOrderResponse(productResponse);
       ProductOfferings productOfferings = productOfferingServiceStub.getProductOfferings(productOfferingsRequest);
       ProductOfferingsReader.readRequest(productOfferings);
    }


}

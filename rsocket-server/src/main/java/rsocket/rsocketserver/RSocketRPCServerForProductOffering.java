package rsocket.rsocketserver;

import java.util.Optional;

import com.test.productOffering.model.ProductOfferingService;
import com.test.productOffering.model.ProductOfferingServiceServer;
import com.test.productOffering.model.ProductOfferings;

import io.netty.buffer.ByteBuf;
import io.rsocket.core.RSocketServer;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.server.TcpServerTransport;
import reactor.core.publisher.Mono;

public class RSocketRPCServerForProductOffering {

	public static void main(String[] args) throws InterruptedException {
		RSocketServer.create()
				.acceptor((connectionSetupPayload,
						rSocket) -> Mono.just(new ProductOfferingServiceServer(new DefaultService(), Optional.empty(),
								Optional.empty(), Optional.empty())))
				.bind(TcpServerTransport.create("localhost", 8899)).subscribe();
		Thread.currentThread().join();
	}

	static class DefaultService implements ProductOfferingService {

		@Override
		public Mono<ProductOfferings> getProductOfferings(ProductOfferings message, ByteBuf metadata) {
			ProductOfferingsReader.readRequest(message);
			return Mono.just(message);
		}

	}
}

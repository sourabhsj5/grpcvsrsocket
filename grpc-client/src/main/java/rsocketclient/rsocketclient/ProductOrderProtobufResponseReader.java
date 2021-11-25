package rsocketclient.rsocketclient;

import java.util.List;

import com.test.rsocket.server.rsocketserver.Billingaccount;
import com.test.rsocket.server.rsocketserver.Channel;
import com.test.rsocket.server.rsocketserver.Characteristic;
import com.test.rsocket.server.rsocketserver.Dutyfreeamount;
import com.test.rsocket.server.rsocketserver.Finalprice;
import com.test.rsocket.server.rsocketserver.Immediatepromotion;
import com.test.rsocket.server.rsocketserver.Itemtotalprice;
import com.test.rsocket.server.rsocketserver.Metadata;
import com.test.rsocket.server.rsocketserver.Orderitem;
import com.test.rsocket.server.rsocketserver.Ordertotalprice;
import com.test.rsocket.server.rsocketserver.Price;
import com.test.rsocket.server.rsocketserver.ProductOrderResponse;
import com.test.rsocket.server.rsocketserver.Promotion;
import com.test.rsocket.server.rsocketserver.Relatedparty;
import com.test.rsocket.server.rsocketserver.Standaloneprice;
import com.test.rsocket.server.rsocketserver.Taxamount;
import com.test.rsocket.server.rsocketserver.Taxincludedamount;
import com.test.rsocket.server.rsocketserver.Validfor;

public class ProductOrderProtobufResponseReader {

	public static void readProductOrderResponse(ProductOrderResponse response) {
		readBillingAccount(response.getBillingAccount());
		readChannels(response.getChannelList());
		response.getIsCustomerVisible();
		response.getDescription();
		response.getId();
		readImmediatePromotions(response.getImmediatepromotionList());
		response.getLastUpdate();
		response.getOrderDate();
		readOrderItems(response.getOrderItemList());
		response.getOrderPriceDate();
		readOrderTotalPriceList(response.getOrderTotalPriceList());
		readRelatedParties(response.getRelatedPartyList());
		response.getState();
	}

	private static void readRelatedParties(List<Relatedparty> relatedParties) {
		for (Relatedparty relatedparty: relatedParties) {
			relatedparty.getId();
			relatedparty.getRole();
		}
	}

	private static void readOrderTotalPriceList(List<Ordertotalprice> priceList) {
		for (Ordertotalprice ordertotalprice: priceList) {
			readFinalPrice(ordertotalprice.getFinalPrice());
			ordertotalprice.getPrice();
			ordertotalprice.getPriceType();
			ordertotalprice.getRecurringChargePeriod();
			ordertotalprice.getRecurringChargePeriodLength();
			readStandalonePrice(ordertotalprice.getStandalonePrice());
		}
	}

	private static void readStandalonePrice(Standaloneprice standaloneprice) {
		readDutyFreeAmount(standaloneprice.getDutyFreeAmount());
		readTaxAmount(standaloneprice.getTaxAmount());
		standaloneprice.getTaxRate();
 	}

	private static void readOrderItems(List<Orderitem> orderItems) {
		for (Orderitem oi: orderItems) {
			oi.getAction();
			readBillingAccount(oi.getBillingAccount());
			readCharacteristics(oi.getCharacteristicList());
			oi.getCreationDate();
			oi.getId();
			readItemTotalPriceList(oi.getItemTotalPriceList());
		}
	}

	private static void readItemTotalPriceList (List<Itemtotalprice> priceList) {
		for (Itemtotalprice price: priceList) {
			readFinalPrice(price.getFinalPrice());
			readPrice(price.getPrice());
			price.getPriceType();
			price.getRecurringChargePeriod();
			price.getRecurringChargePeriodLength();
			readStandalonePrice(price.getStandalonePrice());
		}
	}

	private static void readPrice(Price price) {
		readDutyFreeAmount(price.getDutyFreeAmount());
		readTaxAmount(price.getTaxAmount());
		readTaxIncludeAmount(price.getTaxIncludedAmount());
	}

	private static void readFinalPrice(Finalprice finalPrice) {
		readDutyFreeAmount(finalPrice.getDutyFreeAmount());
		readTaxAmount(finalPrice.getTaxAmount());
		readTaxIncludeAmount(finalPrice.getTaxIncludedAmount());
		finalPrice.getTaxRate();
	}

	private static void readTaxIncludeAmount(Taxincludedamount taxincludedamount) {
		taxincludedamount.getUnit();
		taxincludedamount.getValue();
	}

	private static void readTaxAmount(Taxamount taxamount) {
		taxamount.getUnit();
		taxamount.getValue();
	}

	private static void readDutyFreeAmount(Dutyfreeamount dutyfreeamount) {
		dutyfreeamount.getUnit();
		dutyfreeamount.getValue();
	}

	private static void readCharacteristics(List<Characteristic> characteristics) {
		for (Characteristic characteristic: characteristics) {
			readMetadata(characteristic.getMetadataList());
			characteristic.getName();
			characteristic.getValue();
		}
	}

	private static void readMetadata(List<Metadata> metadataList) {
		for (Metadata metadata: metadataList) {
			metadata.getMetadataType();
			metadata.getName();
			metadata.getValue();
		}
	}

	private static void readImmediatePromotions(List<Immediatepromotion> promotions) {
		for (Immediatepromotion promotion: promotions) {
			promotion.getId();
			readPromotion(promotion.getPromotion());
			promotion.getState();
			promotion.getStatus();
		}
	}

	private static void readPromotion(Promotion promotion) {
		promotion.getApplyPolicy();
		promotion.getDescription();
		promotion.getId();
		promotion.getName();
		promotion.getPriority();
		promotion.getType();
		readValidFor(promotion.getValidFor());
	}

	private static void readValidFor(Validfor validfor) {
		validfor.getEndDateTime();
		validfor.getStartDateTime();
	}

	private static void readChannels(List<Channel> channels) {
		for (Channel channel: channels) {
			channel.getId();
			channel.getName();
		}
	}

	private static void readBillingAccount(Billingaccount billingAccount) {
		billingAccount.getId();
	}
}

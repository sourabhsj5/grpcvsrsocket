package rsocket.rsocketserver;

import java.util.ArrayList;
import java.util.List;

import com.test.rsocket.server.rsocketserver.Billingaccount;
import com.test.rsocket.server.rsocketserver.Characteristic;
import com.test.rsocket.server.rsocketserver.Dutyfreeamount;
import com.test.rsocket.server.rsocketserver.Finalprice;
import com.test.rsocket.server.rsocketserver.Immediatepromotion;
import com.test.rsocket.server.rsocketserver.Metadata;
import com.test.rsocket.server.rsocketserver.Orderitem;
import com.test.rsocket.server.rsocketserver.Price;
import com.test.rsocket.server.rsocketserver.ProductOrderResponse;
import com.test.rsocket.server.rsocketserver.Promotion;
import com.test.rsocket.server.rsocketserver.Standaloneprice;
import com.test.rsocket.server.rsocketserver.Taxamount;
import com.test.rsocket.server.rsocketserver.Taxincludedamount;
import com.test.rsocket.server.rsocketserver.Validfor;

public class ProductOrderProtobufResponseBuilder {

	public static com.test.rsocket.server.rsocketserver.ProductOrderResponse prepareProductOrderResponse() {
		com.test.rsocket.server.rsocketserver.ProductOrderResponse.Builder response = ProductOrderResponse.newBuilder();
		response.setBillingAccount(prepareBillingAccount());
		response.addAllChannel(getChannels());
		response.setIsCustomerVisible(true);
		response.setDescription("this is a dummy response description");
		response.setId("dummyId");
		response.addAllImmediatepromotion(getImmediatePromotions());
		response.setLastUpdate("lastUpdateDate");
		response.setOrderDate("orderDate");
		response.addAllOrderItem(getOrderItems());
		response.setOrderPriceDate("orderPriceDate");
		response.addAllOrderTotalPrice(getOrderTotalPriceList());
		response.addAllRelatedParty(getRelatedParties());
		response.setState("COMPLETED");
		return response.build();
	}

	private static List<com.test.rsocket.server.rsocketserver.Relatedparty> getRelatedParties() {
		List<com.test.rsocket.server.rsocketserver.Relatedparty> relatedParties = new ArrayList<com.test.rsocket.server.rsocketserver.Relatedparty>();
		for (int i=0; i<10; i++) {
			com.test.rsocket.server.rsocketserver.Relatedparty.Builder relatedparty = com.test.rsocket.server.rsocketserver.Relatedparty.newBuilder();
			relatedparty.setId("relatedpartyId" + i);
			relatedparty.setRole("re;atedPartyRole" + i);
			relatedParties.add(relatedparty.build());
		}
		return relatedParties;
	}

	private static List<com.test.rsocket.server.rsocketserver.Ordertotalprice> getOrderTotalPriceList() {
		List<com.test.rsocket.server.rsocketserver.Ordertotalprice> priceList = new ArrayList<com.test.rsocket.server.rsocketserver.Ordertotalprice>();
		for (int i=0; i<10; i++) {
			com.test.rsocket.server.rsocketserver.Ordertotalprice.Builder ordertotalprice = com.test.rsocket.server.rsocketserver.Ordertotalprice.newBuilder();
			ordertotalprice.setFinalPrice(getFinalPrice(i));
			ordertotalprice.setPrice(getPrice(i));
			ordertotalprice.setPriceType("orderTotalPricePriceType" + i);
			ordertotalprice.setRecurringChargePeriod("recurringChargePeriod" + i);
			ordertotalprice.setRecurringChargePeriodLength(i);
			ordertotalprice.setStandalonePrice(getStandalonePrice(i));
			priceList.add(ordertotalprice.build());
		}
		return priceList;
	}

	private static com.test.rsocket.server.rsocketserver.Standaloneprice getStandalonePrice(int i) {
		com.test.rsocket.server.rsocketserver.Standaloneprice.Builder standaloneprice = Standaloneprice.newBuilder();
		standaloneprice.setDutyFreeAmount(getDutyfreeamount(i));
		standaloneprice.setTaxAmount(getTaxamount(i));
		standaloneprice.setTaxRate(i);
		return standaloneprice.build();
	}

	private static List<com.test.rsocket.server.rsocketserver.Orderitem> getOrderItems() {
		List<com.test.rsocket.server.rsocketserver.Orderitem> orderItems = new ArrayList<com.test.rsocket.server.rsocketserver.Orderitem>();
		for (int i=0; i<10; i++) {
			com.test.rsocket.server.rsocketserver.Orderitem.Builder oi = Orderitem.newBuilder();
			oi.setAction("orderItemAction" + i);
			oi.setBillingAccount(getBillingAccount(i));
			oi.addAllCharacteristic(getCharacteristics());
			oi.setCreationDate("creationDate" + i);
			oi.setId("id" + i);
			oi.addAllItemTotalPrice(getItemTotalPrice());
			orderItems.add(oi.build());
		}
		return orderItems;
	}

	private static List<com.test.rsocket.server.rsocketserver.Itemtotalprice> getItemTotalPrice () {
		List<com.test.rsocket.server.rsocketserver.Itemtotalprice> priceList = new ArrayList<com.test.rsocket.server.rsocketserver.Itemtotalprice>();
		for (int i=0; i<10; i++) {
			com.test.rsocket.server.rsocketserver.Itemtotalprice.Builder price = com.test.rsocket.server.rsocketserver.Itemtotalprice.newBuilder();
			price.setFinalPrice(getFinalPrice(i));
			price.setPrice(getPrice(i));
			price.setPriceType("priceType" + i);
			price.setRecurringChargePeriod("recurringChargePeriod" + i);
			price.setRecurringChargePeriodLength(i);
			price.setStandalonePrice(getStandalonePrice(i));
			priceList.add(price.build());
		}
		return priceList;
	}

	private static com.test.rsocket.server.rsocketserver.Price getPrice(int i) {
		com.test.rsocket.server.rsocketserver.Price.Builder price = Price.newBuilder();
		price.setDutyFreeAmount(getDutyfreeamount(i));
		price.setTaxAmount(getTaxamount(i));
		price.setTaxIncludedAmount(getTaxincludedamount(i));
		return price.build();
	}

	private static com.test.rsocket.server.rsocketserver.Finalprice getFinalPrice(int i) {
		com.test.rsocket.server.rsocketserver.Finalprice.Builder finalPrice = Finalprice.newBuilder();
		finalPrice.setDutyFreeAmount(getDutyfreeamount(i));
		finalPrice.setTaxAmount(getTaxamount(i));
		finalPrice.setTaxIncludedAmount(getTaxincludedamount(i));
		finalPrice.setTaxRate(i);
		return finalPrice.build();
	}

	private static com.test.rsocket.server.rsocketserver.Taxincludedamount getTaxincludedamount(int i) {
		com.test.rsocket.server.rsocketserver.Taxincludedamount.Builder taxincludedamount = Taxincludedamount.newBuilder();
		taxincludedamount.setUnit("taxIncludedAmount" + i);
		taxincludedamount.setValue(i);
		return taxincludedamount.build();
	}

	private static com.test.rsocket.server.rsocketserver.Taxamount getTaxamount(int i) {
		com.test.rsocket.server.rsocketserver.Taxamount.Builder taxamount = Taxamount.newBuilder();
		taxamount.setUnit("taxAmountUnit" + i);
		taxamount.setValue(i);
		return taxamount.build();
	}

	private static com.test.rsocket.server.rsocketserver.Dutyfreeamount getDutyfreeamount(int i) {
		com.test.rsocket.server.rsocketserver.Dutyfreeamount.Builder dutyfreeamount = Dutyfreeamount.newBuilder();
		dutyfreeamount.setUnit("dutyFreeAmountUnit" + i);
		dutyfreeamount.setValue(i);
		return dutyfreeamount.build();
	}

	private static List<com.test.rsocket.server.rsocketserver.Characteristic> getCharacteristics() {
		List<com.test.rsocket.server.rsocketserver.Characteristic> characteristics = new ArrayList<Characteristic>();
		for (int i=0; i<10; i++) {
			com.test.rsocket.server.rsocketserver.Characteristic.Builder characteristic = com.test.rsocket.server.rsocketserver.Characteristic.newBuilder();
			characteristic.addAllMetadata(getMetadata());
			characteristic.setName("characteristicName" + i);
			characteristic.setValue("characteristicValue" + i);
			characteristics.add(characteristic.build());
		}
		return characteristics;
	}

	private static List<com.test.rsocket.server.rsocketserver.Metadata> getMetadata() {
		List<com.test.rsocket.server.rsocketserver.Metadata> metadataList = new ArrayList<com.test.rsocket.server.rsocketserver.Metadata>();
		for (int i=0; i<10; i++) {
			com.test.rsocket.server.rsocketserver.Metadata.Builder metadata = Metadata.newBuilder();
			metadata.setMetadataType("metadataType" + i);
			metadata.setName("metadataName" + i);
			metadata.setValue("metadataValue" + i);
			metadataList.add(metadata.build());
		}
		return metadataList;
	}

	private static com.test.rsocket.server.rsocketserver.Billingaccount getBillingAccount(int i) {
		com.test.rsocket.server.rsocketserver.Billingaccount.Builder billingaccount = Billingaccount.newBuilder();
		billingaccount.setId("billingaccountid" + i);
		return billingaccount.build();
	}

	private static List<com.test.rsocket.server.rsocketserver.Immediatepromotion> getImmediatePromotions() {
		List<com.test.rsocket.server.rsocketserver.Immediatepromotion> promotions = new ArrayList<com.test.rsocket.server.rsocketserver.Immediatepromotion>();
		for (int i=0; i<10; i++) {
			com.test.rsocket.server.rsocketserver.Immediatepromotion.Builder promotion = Immediatepromotion.newBuilder();
			promotion.setId("promotionId" + i);
			promotion.setPromotion(getPromotion(i));
			promotion.setState("promotionState" + i);
			promotion.setStatus("promotionStatus" + i);
			promotions.add(promotion.build());
		}
		return promotions;
	}

	private static com.test.rsocket.server.rsocketserver.Promotion getPromotion(int i) {
		com.test.rsocket.server.rsocketserver.Promotion.Builder promotion = Promotion.newBuilder();
		promotion.setApplyPolicy("promotionApplyPolicy" + i);
		promotion.setDescription("promotionDescription" + i);
		promotion.setId("promotionId" + i);
		promotion.setName("promotionName" + i);
		promotion.setPriority(i);
		promotion.setType("promotionType" + i);
		promotion.setValidFor(getValidFor(i));
		return promotion.build();
	}

	private static com.test.rsocket.server.rsocketserver.Validfor getValidFor(int i) {
		com.test.rsocket.server.rsocketserver.Validfor.Builder validfor = Validfor.newBuilder();
		validfor.setEndDateTime("endDateTime" + i);
		validfor.setStartDateTime("startDateTime" + i);
		return validfor.build();
	}

	private static List<com.test.rsocket.server.rsocketserver.Channel> getChannels() {
		List<com.test.rsocket.server.rsocketserver.Channel> channels = new ArrayList<com.test.rsocket.server.rsocketserver.Channel>();
		for (int i=0; i<10; i++) {
			com.test.rsocket.server.rsocketserver.Channel.Builder channel = com.test.rsocket.server.rsocketserver.Channel.newBuilder();
			channel.setId("channelId"+i);
			channel.setName("channelName"+i);
			channels.add(channel.build());
		}
		return channels;
	}

	private static com.test.rsocket.server.rsocketserver.Billingaccount prepareBillingAccount() {
		com.test.rsocket.server.rsocketserver.Billingaccount.Builder account = com.test.rsocket.server.rsocketserver.Billingaccount.newBuilder();
		account.setId("accountId");
		return account.build();
	}
}

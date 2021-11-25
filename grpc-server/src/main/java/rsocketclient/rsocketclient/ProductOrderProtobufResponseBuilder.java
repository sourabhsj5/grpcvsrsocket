package rsocketclient.rsocketclient;

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

	public static ProductOrderResponse prepareProductOrderResponse() {
		ProductOrderResponse.Builder response = ProductOrderResponse.newBuilder();
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

	private static Standaloneprice getStandalonePrice(int i) {
		Standaloneprice.Builder standaloneprice = Standaloneprice.newBuilder();
		standaloneprice.setDutyFreeAmount(getDutyfreeamount(i));
		standaloneprice.setTaxAmount(getTaxamount(i));
		standaloneprice.setTaxRate(i);
		return standaloneprice.build();
	}

	private static List<Orderitem> getOrderItems() {
		List<Orderitem> orderItems = new ArrayList<Orderitem>();
		for (int i=0; i<10; i++) {
			Orderitem.Builder oi = Orderitem.newBuilder();
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

	private static Price getPrice(int i) {
		Price.Builder price = Price.newBuilder();
		price.setDutyFreeAmount(getDutyfreeamount(i));
		price.setTaxAmount(getTaxamount(i));
		price.setTaxIncludedAmount(getTaxincludedamount(i));
		return price.build();
	}

	private static Finalprice getFinalPrice(int i) {
		Finalprice.Builder finalPrice = Finalprice.newBuilder();
		finalPrice.setDutyFreeAmount(getDutyfreeamount(i));
		finalPrice.setTaxAmount(getTaxamount(i));
		finalPrice.setTaxIncludedAmount(getTaxincludedamount(i));
		finalPrice.setTaxRate(i);
		return finalPrice.build();
	}

	private static Taxincludedamount getTaxincludedamount(int i) {
		Taxincludedamount.Builder taxincludedamount = Taxincludedamount.newBuilder();
		taxincludedamount.setUnit("taxIncludedAmount" + i);
		taxincludedamount.setValue(i);
		return taxincludedamount.build();
	}

	private static Taxamount getTaxamount(int i) {
		Taxamount.Builder taxamount = Taxamount.newBuilder();
		taxamount.setUnit("taxAmountUnit" + i);
		taxamount.setValue(i);
		return taxamount.build();
	}

	private static Dutyfreeamount getDutyfreeamount(int i) {
		Dutyfreeamount.Builder dutyfreeamount = Dutyfreeamount.newBuilder();
		dutyfreeamount.setUnit("dutyFreeAmountUnit" + i);
		dutyfreeamount.setValue(i);
		return dutyfreeamount.build();
	}

	private static List<Characteristic> getCharacteristics() {
		List<Characteristic> characteristics = new ArrayList<Characteristic>();
		for (int i=0; i<10; i++) {
			Characteristic.Builder characteristic = Characteristic.newBuilder();
			characteristic.addAllMetadata(getMetadata());
			characteristic.setName("characteristicName" + i);
			characteristic.setValue("characteristicValue" + i);
			characteristics.add(characteristic.build());
		}
		return characteristics;
	}

	private static List<Metadata> getMetadata() {
		List<Metadata> metadataList = new ArrayList<Metadata>();
		for (int i=0; i<10; i++) {
			Metadata.Builder metadata = Metadata.newBuilder();
			metadata.setMetadataType("metadataType" + i);
			metadata.setName("metadataName" + i);
			metadata.setValue("metadataValue" + i);
			metadataList.add(metadata.build());
		}
		return metadataList;
	}

	private static Billingaccount getBillingAccount(int i) {
		Billingaccount.Builder billingaccount = Billingaccount.newBuilder();
		billingaccount.setId("billingaccountid" + i);
		return billingaccount.build();
	}

	private static List<Immediatepromotion> getImmediatePromotions() {
		List<Immediatepromotion> promotions = new ArrayList<Immediatepromotion>();
		for (int i=0; i<10; i++) {
			Immediatepromotion.Builder promotion = Immediatepromotion.newBuilder();
			promotion.setId("promotionId" + i);
			promotion.setPromotion(getPromotion(i));
			promotion.setState("promotionState" + i);
			promotion.setStatus("promotionStatus" + i);
			promotions.add(promotion.build());
		}
		return promotions;
	}

	private static Promotion getPromotion(int i) {
		Promotion.Builder promotion = Promotion.newBuilder();
		promotion.setApplyPolicy("promotionApplyPolicy" + i);
		promotion.setDescription("promotionDescription" + i);
		promotion.setId("promotionId" + i);
		promotion.setName("promotionName" + i);
		promotion.setPriority(i);
		promotion.setType("promotionType" + i);
		promotion.setValidFor(getValidFor(i));
		return promotion.build();
	}

	private static Validfor getValidFor(int i) {
		Validfor.Builder validfor = Validfor.newBuilder();
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

	private static Billingaccount prepareBillingAccount() {
		Billingaccount.Builder account = Billingaccount.newBuilder();
		account.setId("accountId");
		return account.build();
	}
}

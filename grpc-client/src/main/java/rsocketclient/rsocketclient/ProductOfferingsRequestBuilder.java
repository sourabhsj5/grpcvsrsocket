package rsocketclient.rsocketclient;

import java.util.ArrayList;
import java.util.List;

import com.test.productOffering.model.BundledGroupProductOffering;
import com.test.productOffering.model.BundledProdOfferGroupOption;
import com.test.productOffering.model.BundledProductOffering;
import com.test.productOffering.model.ProductOffering;
import com.test.productOffering.model.ProductOfferingCharacteristic;
import com.test.productOffering.model.ProductOfferingCharacteristicProperty;
import com.test.productOffering.model.ProductOfferingCharacteristicValue;
import com.test.productOffering.model.ProductOfferingType;
import com.test.productOffering.model.ProductOfferings;
import com.test.productOffering.model.ProductSpecificationRef;
import com.test.productOffering.model.VariantGroupRelationship;

public class ProductOfferingsRequestBuilder {

	public static ProductOfferings prepareProductOfferingsRequest() {
		ProductOfferings offerings = readRequest();
		return offerings;
	}
	
    public static ProductOfferings readRequest() {
    	ProductOfferings.Builder builder = ProductOfferings.newBuilder();
    	List<ProductOffering> productOfferings = new ArrayList<>();
    	for (int i=0;i<10;i++) {
    		productOfferings.add(readProductOffering());
    	}
    	builder.addAllProductOffering(productOfferings);
		return builder.build();
	}
    
	private static ProductOffering readProductOffering() {
		ProductOffering.Builder productOffering = ProductOffering.newBuilder();
		productOffering.setId("id");
		productOffering.setHref("href");
		productOffering.setVersion("version");
		productOffering.setName("name");
		productOffering.setIsBundle(false);
		productOffering.setDescription("description");
		productOffering.setValidFor("validFor");
		productOffering.setMustBeBundled(false);
		productOffering.setProductOfferingType(readProductOfferingType());
		productOffering.addAllProductSpecificationRef(readProductSpecificationRefList());
		productOffering.addAllProductOfferingCharacteristic(readProductOfferingCharacteristicList());
		productOffering.addAllVariantGroup(readVariantGroupList());
		productOffering.addAllBundledProdOfferGroupOption(readBundledProdOfferGroupOptionList());
		productOffering.addAllBundledProductOffering(readBundledProductOfferingList());
		return productOffering.build();
	}
	private static List<BundledProductOffering> readBundledProductOfferingList() {
		List<BundledProductOffering> bundledProductOfferingList = new ArrayList<>();
		for (int i=0; i<10; i++) {
			bundledProductOfferingList.add(readBundledProductOffering());
		}
		return bundledProductOfferingList;
	}
	private static BundledProductOffering readBundledProductOffering() {
		BundledProductOffering.Builder bundledProductOffering = BundledProductOffering.newBuilder();
		bundledProductOffering.setId("id");
		bundledProductOffering.setHref("href");
		bundledProductOffering.setName("name");
		bundledProductOffering.setDescription("description");
		bundledProductOffering.setProductOfferingType(readProductOfferingType());
		return bundledProductOffering.build();
	}
	private static List<BundledProdOfferGroupOption> readBundledProdOfferGroupOptionList() {
		List<BundledProdOfferGroupOption> list = new ArrayList<BundledProdOfferGroupOption>();
		for (int i=0; i<10; i++) {
			BundledProdOfferGroupOption.Builder bundledProdOfferGroupOption = BundledProdOfferGroupOption.newBuilder();
			bundledProdOfferGroupOption.setGroupOptionId("groupOptionId");
			bundledProdOfferGroupOption.setName("name");
			bundledProdOfferGroupOption.setProductOfferingType(readProductOfferingType());
			bundledProdOfferGroupOption.setNumberRelOfferLowerLimit(1);
			bundledProdOfferGroupOption.setNumberRelOfferUpperLimit(10);
			bundledProdOfferGroupOption.setBundleSameOffer(true);
			bundledProdOfferGroupOption.addAllBundledGroupProductOffering(readBundledGroupProductOfferingList());
			list.add(bundledProdOfferGroupOption.build());
		}
		return list;
	}
	private static List<BundledGroupProductOffering> readBundledGroupProductOfferingList() {
		List<BundledGroupProductOffering> bundledGroupProductOfferingList = new ArrayList<BundledGroupProductOffering>();
		for (int i=0;i<10;i++) {
			bundledGroupProductOfferingList.add(readBundledGroupProductOffering());
		}
		return bundledGroupProductOfferingList;
	}
	private static BundledGroupProductOffering readBundledGroupProductOffering() {
		BundledGroupProductOffering.Builder bundledGroupProductOffering = BundledGroupProductOffering.newBuilder();
		bundledGroupProductOffering.setId("id");
		bundledGroupProductOffering.setHref("href");
		bundledGroupProductOffering.setName("name");
		bundledGroupProductOffering.setDescription("description");
		bundledGroupProductOffering.setProductOfferingType(readProductOfferingType());
		return bundledGroupProductOffering.build();
	}
	private static List<VariantGroupRelationship> readVariantGroupList() {
		List<VariantGroupRelationship> variantGroupList = new ArrayList<VariantGroupRelationship>();
		for (int i=0; i<10; i++) {
			VariantGroupRelationship.Builder variantGroupRelationship = VariantGroupRelationship.newBuilder();
			variantGroupRelationship.setId("id");
			variantGroupRelationship.setHref("href");
			variantGroupList.add(variantGroupRelationship.build());
		}
		return variantGroupList;
	}
	private static List<ProductOfferingCharacteristic> readProductOfferingCharacteristicList() {
		List<ProductOfferingCharacteristic> list = new ArrayList<ProductOfferingCharacteristic>();
		for (int i=0;i<10;i++) {
			list.add(readProductOfferingCharacteristic());
		}
		return list;
	}
	private static ProductOfferingCharacteristic readProductOfferingCharacteristic() {
		ProductOfferingCharacteristic.Builder productOfferingCharacteristic = ProductOfferingCharacteristic.newBuilder();
		productOfferingCharacteristic.setName("name");
		productOfferingCharacteristic.setLocalizedName("localizedName");
		productOfferingCharacteristic.setConfigurable("true");
		productOfferingCharacteristic.setValueType("valueType");
		productOfferingCharacteristic.setUnitOfMeasure("unitOfMeasure");
		productOfferingCharacteristic.setMinCardinality("1");
		productOfferingCharacteristic.setMaxCardinality(10);
		productOfferingCharacteristic.addAllProductOfferingCharacteristicValue(readProductOfferingCharacteristicValueList());
		productOfferingCharacteristic.addAllProductOfferingCharacteristicProperty(readProductOfferingCharacteristicPropertyList());
		return productOfferingCharacteristic.build();
	}

	private static List<ProductOfferingCharacteristicProperty> readProductOfferingCharacteristicPropertyList() {
		List<ProductOfferingCharacteristicProperty> list = new ArrayList<ProductOfferingCharacteristicProperty>();
		for (int i=0;i<10;i++) {
			list.add(readProductOfferingCharacteristicProperty());
		}
		return list;
	}

	private static ProductOfferingCharacteristicProperty readProductOfferingCharacteristicProperty() {
		ProductOfferingCharacteristicProperty.Builder property = ProductOfferingCharacteristicProperty.newBuilder();
		property.setName("name");
		List<String> values = new ArrayList<String>();
		for (int i=0;i<10;i++) {
			values.add("value");
		}
		property.addAllValue(values);
		return property.build();
	}

	private static List<ProductOfferingCharacteristicValue> readProductOfferingCharacteristicValueList() {
		List<ProductOfferingCharacteristicValue> list = new ArrayList<ProductOfferingCharacteristicValue>();
		for (int i=0;i<10;i++) {
			list.add(readProductOfferingCharacteristicValue());
		}
		return list;
	}

	private static ProductOfferingCharacteristicValue readProductOfferingCharacteristicValue() {
		ProductOfferingCharacteristicValue.Builder value = ProductOfferingCharacteristicValue.newBuilder();
		value.setDefault("default");
		value.setLocalizedValue("localizedValue");
		value.setUnitOfMeasure("unitOfMeasure");
		value.setValue("value");
		value.setValueFrom("valueFrom");
		value.setValueTo("valueTo");
		value.setValueType("valueType");
		return value.build();
	}

	private static List<ProductSpecificationRef> readProductSpecificationRefList() {
		List<ProductSpecificationRef> productSpecificationRefList = new ArrayList<>();
		for (int i=0;i<10;i++) {
			productSpecificationRefList.add(readProductSpecificationRef());
		}
		return productSpecificationRefList;
	}
	private static ProductSpecificationRef readProductSpecificationRef() {
		ProductSpecificationRef.Builder productSpecificationRef = ProductSpecificationRef.newBuilder();
		productSpecificationRef.getId();
		productSpecificationRef.getHref();
		productSpecificationRef.getName();
		return productSpecificationRef.build();
	}
	private static ProductOfferingType readProductOfferingType() {
		ProductOfferingType.Builder productOfferingType = ProductOfferingType.newBuilder();
		productOfferingType.setId("id");
		productOfferingType.setHref("href");
		productOfferingType.setName("name");
		return productOfferingType.build();
	}


}

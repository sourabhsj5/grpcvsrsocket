package rsocketclient.rsocketclient;

import java.util.List;

import com.test.productOffering.model.BundledGroupProductOffering;
import com.test.productOffering.model.BundledProdOfferGroupOption;
import com.test.productOffering.model.BundledProductOffering;
import com.test.productOffering.model.ProductOffering;
import com.test.productOffering.model.ProductOfferingCharacteristic;
import com.test.productOffering.model.ProductOfferingType;
import com.test.productOffering.model.ProductOfferings;
import com.test.productOffering.model.ProductSpecificationRef;
import com.test.productOffering.model.VariantGroupRelationship;

public class ProductOfferingsReader {

    public static void readRequest(ProductOfferings request) {
    	//System.out.println("reading offering response total count" + request.getProductOfferingCount());
		List<ProductOffering> productOfferings = request.getProductOfferingList();
		for (ProductOffering productOffering: productOfferings) {
			readProductOffering(productOffering);
		}
	}
    
	private static void readProductOffering(ProductOffering productOffering) {
		productOffering.getId();
		productOffering.getHref();
		productOffering.getVersion();
		productOffering.getName();
		productOffering.getIsBundle();
		productOffering.getDescription();
		productOffering.getValidFor();
		productOffering.getMustBeBundled();
		readProductOfferingType(productOffering.getProductOfferingType());
		readProductSpecificationRef(productOffering.getProductSpecification());
		readProductSpecificationRefList(productOffering.getProductSpecificationRefList());
		readProductOfferingCharacteristicList(productOffering.getProductOfferingCharacteristicList());
		readVariantGroupList(productOffering.getVariantGroupList());
		readBundledProdOfferGroupOptionList(productOffering.getBundledProdOfferGroupOptionList());
		readBundledProductOfferingList(productOffering.getBundledProductOfferingList());
	}
	private static void readBundledProductOfferingList(List<BundledProductOffering> bundledProductOfferingList) {
		for (BundledProductOffering bundledProductOffering: bundledProductOfferingList) {
			readBundledProductOffering(bundledProductOffering);
		}
	}
	private static void readBundledProductOffering(BundledProductOffering bundledProductOffering) {
		bundledProductOffering.getId();
		bundledProductOffering.getHref();
		bundledProductOffering.getName();
		bundledProductOffering.getDescription();
		readProductOfferingType(bundledProductOffering.getProductOfferingType());			
	}
	private static void readBundledProdOfferGroupOptionList(
			List<BundledProdOfferGroupOption> bundledProdOfferGroupOptionList) {
		for (BundledProdOfferGroupOption bundledProdOfferGroupOption: bundledProdOfferGroupOptionList) {
			bundledProdOfferGroupOption.getGroupOptionId();
			bundledProdOfferGroupOption.getName();
			readProductOfferingType(bundledProdOfferGroupOption.getProductOfferingType());
			bundledProdOfferGroupOption.getNumberRelOfferLowerLimit();
			bundledProdOfferGroupOption.getNumberRelOfferUpperLimit();
			bundledProdOfferGroupOption.getBundleSameOffer();
			readBundledGroupProductOfferingList(bundledProdOfferGroupOption.getBundledGroupProductOfferingList());
		}
	}
	private static void readBundledGroupProductOfferingList(
			List<BundledGroupProductOffering> bundledGroupProductOfferingList) {
		for (BundledGroupProductOffering bundledGroupProductOffering: bundledGroupProductOfferingList) {
			readBundledGroupProductOffering(bundledGroupProductOffering);
		}
	}
	private static void readBundledGroupProductOffering(BundledGroupProductOffering bundledGroupProductOffering) {
		bundledGroupProductOffering.getId();
		bundledGroupProductOffering.getHref();
		bundledGroupProductOffering.getName();
		bundledGroupProductOffering.getDescription();
		readProductOfferingType(bundledGroupProductOffering.getProductOfferingType());
	}
	private static void readVariantGroupList(List<VariantGroupRelationship> variantGroupList) {
		for (VariantGroupRelationship variantGroupRelationship: variantGroupList) {
			variantGroupRelationship.getId();
			variantGroupRelationship.getHref();
		}
	}
	private static void readProductOfferingCharacteristicList(
			List<ProductOfferingCharacteristic> productOfferingCharacteristicList) {
		for (ProductOfferingCharacteristic productOfferingCharacteristic: productOfferingCharacteristicList) {
			readProductOfferingCharacteristic(productOfferingCharacteristic);
		}
		
	}
	private static void readProductOfferingCharacteristic(ProductOfferingCharacteristic productOfferingCharacteristic) {
		productOfferingCharacteristic.getName();
		productOfferingCharacteristic.getLocalizedName();
		productOfferingCharacteristic.getConfigurable();
		productOfferingCharacteristic.getValueType();
		productOfferingCharacteristic.getUnitOfMeasure();
		productOfferingCharacteristic.getMinCardinality();
		productOfferingCharacteristic.getMaxCardinality();
		productOfferingCharacteristic.getProductOfferingCharacteristicValueList();
		productOfferingCharacteristic.getProductOfferingCharacteristicPropertyList();
	}

	private static void readProductSpecificationRefList(List<ProductSpecificationRef> productSpecificationRefList) {
		for (ProductSpecificationRef productSpecificationRef: productSpecificationRefList) {
			readProductSpecificationRef(productSpecificationRef);
		}
	}
	private static void readProductSpecificationRef(ProductSpecificationRef productSpecificationRef) {
		productSpecificationRef.getId();
		productSpecificationRef.getHref();
		productSpecificationRef.getName();
	}
	private static void readProductOfferingType(ProductOfferingType productOfferingType) {
		productOfferingType.getId();
		productOfferingType.getHref();
		productOfferingType.getName();
	}
}


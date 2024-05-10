package farmer.in.AgriMarket.exception;

public class FarmerIdNotFoundException extends RuntimeException {
    public FarmerIdNotFoundException(String farmerId) {
        super("The given farmerID: "+farmerId+" not found in DB");
    }
}

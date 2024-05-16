package farmer.in.AgriMarket.dto.search;


import lombok.Data;

@Data
public class SearchProductByPriceRequest {
    private Double initialValue;
    private Double finalValue;
}

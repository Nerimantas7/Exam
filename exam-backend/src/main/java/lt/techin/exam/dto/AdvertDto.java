package lt.techin.exam.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertDto {
    private Long id;
    private String advertTitle;
    private String advertText;
    private int price;
    private String advertPlace;
    private Long categoryId;



}

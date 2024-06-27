package lt.techin.exam.dto;


import lombok.*;

@Data
@Getter
@Setter
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

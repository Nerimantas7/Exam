package lt.techin.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertCategoryDto {
    private Long id;
    private String advertCategory;
    private String categoryDescription;
}

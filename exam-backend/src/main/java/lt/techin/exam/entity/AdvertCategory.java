package lt.techin.exam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class AdvertCategory {

    @Id
    @Column(name ="category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name", nullable = false, unique = true)
    private String advertCategory;

    @Column(name = "category_description")
    private String categoryDescription;
}

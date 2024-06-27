package lt.techin.exam.entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "adverts")
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "advert_title", nullable = false)
    private String advertTitle;

    @Column(name = "advert_text", nullable = false)
    private String advertText;

    @Column(name = "advert_price", nullable = false)
    private int price;

    @Column(name = "advert_place", nullable = false)
    private String advertPlace;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="category_id")
    private AdvertCategory advertCategory;
}

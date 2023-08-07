package org.itstep.auto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.itstep.image.Image;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auto")
public class Auto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "auto", cascade = CascadeType.ALL)
    private Set<Image> images;
}

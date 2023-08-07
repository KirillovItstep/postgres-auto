package org.itstep.image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.itstep.auto.Auto;

import javax.persistence.*;
import java.util.Arrays;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "image")
public class Image{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;

    @Lob
    @Column(name = "bytes")
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] bytes;

    @ManyToOne
    @JoinColumn(name="auto_id", nullable = true)
    private Auto auto;

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bytes=" + Arrays.toString(bytes) +
                ", auto=" + auto.getId() +
                '}';
    }
}

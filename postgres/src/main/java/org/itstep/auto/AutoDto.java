package org.itstep.auto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AutoDto{
    private int id;
    private String name;
    private Set<String> images;
}

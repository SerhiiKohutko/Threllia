package org.example.threllia.Modal.Shop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.example.threllia.Modal.Shop.shop_enum.ApparelProductType;
import org.example.threllia.Modal.Shop.shop_enum.ApparelSizeType;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@AllArgsConstructor
public class ApparelProduct extends Product{

    @ElementCollection
    @MapKeyColumn(name="size")
    @Column(name = "quantity")
    @CollectionTable(name="size_quantity", joinColumns=@JoinColumn(name="id"))
    private Map<ApparelSizeType, Integer> sizeToQuantityMap;

    private ApparelProductType type;

    public ApparelProduct(){
        sizeToQuantityMap = new HashMap<>();
        for (ApparelSizeType key : ApparelSizeType.values()){
            sizeToQuantityMap.putIfAbsent(key, 0);
        }
    }

}

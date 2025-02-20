package vn.iotstar.api.bai3api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class ProductEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "product_name", length = 200, columnDefinition = "nvarchar(200) not null")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id") // Cột FK trong bảng Products
    private Category category;
}

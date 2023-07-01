package net.plantsystem.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author rames on 2023-03-16
 */
@Table(name = "battery")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Battery implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "postcode")
    private Long postcode;

    @Column(name = "capacity")
    private Double capacity;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "status")
    private Character status;

    @Override
    public String toString() {
        return "Battery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postcode=" + postcode +
                ", capacity=" + capacity +
                ", remarks='" + remarks + '\'' +
                ", status=" + status +
                '}';
    }
}

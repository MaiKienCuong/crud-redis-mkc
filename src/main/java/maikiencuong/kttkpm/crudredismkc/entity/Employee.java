package maikiencuong.kttkpm.crudredismkc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee implements Serializable {
    private Long id;
    private String name;
}

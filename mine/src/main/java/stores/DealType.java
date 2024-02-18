package stores;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import jakarta.validation.constraints.NotNull;

@Data
@Table
public class DealType {
    @Id
    private Long id;
    
    @NotNull(message = "Выберите хотя бы один тип сделки.")
    private String type;
}



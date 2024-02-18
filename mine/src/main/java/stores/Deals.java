package stores;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.NumberFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@Table
public class Deals {
    @Id
    private Long id;
    private Long typeId;
    
    @NotBlank(message = "Тикер не может быть пустым.")
    @Size(min = 3, message = "Должно быть больше 3х символов")
    private String ticker;
    @NotBlank(message = "Номер заказа не может быть пустым.")
    private String orderNumber;
    @NotBlank(message = "Номер сделки не может быть пустым.")
    private String dealNumber;

    @NotBlank(message = "Количество сделки не может быть пустым.")
    private String dealQuantity;

    @NotBlank(message = "Цена сделки не может быть пустой.")
    private String dealPrice;

    @NotBlank(message = "Общая стоимость сделки не может быть пустой.")
    private String dealTotalCost;

    @NotBlank(message = "Трейдер сделки не может быть пустым.")
    private String dealTrader;

    @NotBlank(message = "Комиссия за сделку не может быть пустой.")
    private String dealCommission;

}









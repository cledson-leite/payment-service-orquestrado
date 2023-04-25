package com.cledsonLeite.payment.adapter.out.message;



import com.cledsonLeite.payment.application.core.domain.Sale;
import com.cledsonLeite.payment.application.core.domain.enums.SaleEvent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SaleMessage {
	
	private Sale sale;
	private SaleEvent event;
	

}

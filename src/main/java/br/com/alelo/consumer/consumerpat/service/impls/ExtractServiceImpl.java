package br.com.alelo.consumer.consumerpat.service.impls;

import br.com.alelo.consumer.consumerpat.dto.BuyDTO;
import br.com.alelo.consumer.consumerpat.entity.Card;
import br.com.alelo.consumer.consumerpat.entity.Establishment;
import br.com.alelo.consumer.consumerpat.entity.Extract;
import br.com.alelo.consumer.consumerpat.entity.Type;
import br.com.alelo.consumer.consumerpat.respository.ExtractRepository;
import br.com.alelo.consumer.consumerpat.service.interfaces.EstablishmentService;
import br.com.alelo.consumer.consumerpat.service.interfaces.ExtractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ExtractServiceImpl implements ExtractService {
    @Autowired
    private ExtractRepository extractRepository;

    @Autowired
    private EstablishmentService establishmentService;

    public void insert(BuyDTO buy) {
        Establishment establishment = Establishment.builder()
                .id(buy.getEstablishment().getId())
                .name(buy.getEstablishment().getName())
                .type(Type.builder()
                        .id(buy.getEstablishment().getType().getId())
                        .build())
                .build();
        Extract extract = Extract.builder()
                .productDescription(buy.getProductDescription())
                .dateBuy(LocalDateTime.now())
                .card(Card.builder()
                        .number(buy.getCardNumber())
                        .build())
                .value(buy.getValue())
                .build();

        extract.setEstablishment(establishmentService.save(establishment));
        extractRepository.save(extract);
    }
}

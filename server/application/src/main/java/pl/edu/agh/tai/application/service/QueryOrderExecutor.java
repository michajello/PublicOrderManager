package pl.edu.agh.tai.application.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.parameters.P;
import pl.edu.agh.tai.dbmodel.entity.DocumentType;
import pl.edu.agh.tai.dbmodel.entity.OrderKind;
import pl.edu.agh.tai.dbmodel.repository.OrderRepository;
import pl.edu.agh.tai.dbmodel.entity.Order;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QueryOrderExecutor {

    private static final List<String> voivodeshipIDs = IntStream.rangeClosed(1, 16)
            .boxed()
            .map(i -> i.toString())
            .collect(Collectors.toList());

    private static final List<String> orderModeIDs = IntStream.rangeClosed(1, 9)
            .boxed()
            .map(i -> i.toString())
            .collect(Collectors.toList());

    private static final LocalDate MIN_DATE = LocalDate.of(1000, 11, 11);
    private static final LocalDate MAX_DATE = LocalDate.of(3000, 11, 11);

    private final OrderRepository orderRepository;
    private final int page;
    private final int size;
    private final LocalDate startDate;
    private final LocalDate finishDate;
    private final List<String> voivodshipIds;
    private final List<String> orderModeIds;
    private final List<DocumentType> orderTypeIds;
    private final List<OrderKind> orderKindIds;


    public QueryOrderExecutor(OrderRepository orderRepository, int page, int size,
                              LocalDate startDate, LocalDate finishDate, Integer voivodshipId,
                              Integer orderModeId, Integer orderTypeId, Integer orderKindId) {
        this.orderRepository = orderRepository;
        this.page = page;
        this.size = size;
        this.startDate = startDate != null ? startDate : MIN_DATE;
        this.finishDate = finishDate != null ? finishDate : MAX_DATE;
        this.voivodshipIds = initVoivodeshipsID(voivodshipId);
        this.orderModeIds = initOrderModeIds(orderModeId);
        this.orderTypeIds = initOrderTypes(orderTypeId);
        this.orderKindIds = initOrderKinds(orderKindId);
    }


    private List<String> initVoivodeshipsID(Integer voivodeshipId) {
        return voivodeshipId == null ? QueryOrderExecutor.voivodeshipIDs: Arrays.asList(voivodeshipId.toString());
    }

    private List<String> initOrderModeIds(Integer orderModeId) {
        return orderModeId == null ? QueryOrderExecutor.orderModeIDs : Arrays.asList(orderModeId.toString());
    }

    private List<DocumentType> initOrderTypes(Integer orderTypeId) {
        if (orderTypeId == null) {
            return Arrays.asList(DocumentType.values());
        }
        DocumentType documentType = DocumentType.get(orderTypeId);
        return documentType == null ? Arrays.asList(DocumentType.values()) : Arrays.asList(documentType);
    }

    private List<OrderKind> initOrderKinds(Integer orderKindId) {
        if (orderKindId == null) {
            return Arrays.asList(OrderKind.values());
        }
        OrderKind orderKind = OrderKind.get(orderKindId);
        return orderKind == null ? Arrays.asList(OrderKind.values()) : Arrays.asList(orderKind);
    }

    public List<Order> performQuery() {
        return orderRepository.searchByParameters(startDate, finishDate,
                voivodshipIds,
                orderModeIds,
                orderTypeIds,
                orderKindIds,
                PageRequest.of(page, size)
        );
//                .getContent();

//        if (startDate == null && finishDate == null){
//            return orderRepository.findAll(PageRequest.of(page, size)).getContent();
//        }
//        else if(startDate == null){
//            return orderRepository.findByDataPublikacjiBefore(finishDate, PageRequest.of(page, size)).getContent();
//        }else if(finishDate == null) {
//            return orderRepository.findByDataPublikacjiAfter(startDate, PageRequest.of(page, size)).getContent();
//        }
//        return orderRepository.findByDataPublikacjiAfterAndDataPublikacjiBefore(startDate,finishDate, PageRequest.of(page, size)).getContent();
    }
}

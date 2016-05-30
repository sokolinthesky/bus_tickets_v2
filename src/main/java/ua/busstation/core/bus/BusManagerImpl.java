package ua.busstation.core.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ua.busstation.dao.convertors.BusConvertor;
import ua.busstation.dao.repository.BusRepository;

@ComponentScan
@Component
@EnableTransactionManagement
public class BusManagerImpl implements BusManager {

    @Autowired
    private BusRepository busRepository;

    @Override
    public Bus findOne(String id) {
        return BusConvertor.convertToBus(busRepository.findOne(id));
    }
}

package person.liufan.bookstore.mapper;

import person.liufan.bookstore.entity.OrderBook;

public interface OrderBookMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderBook record);

    int insertSelective(OrderBook record);

    OrderBook selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderBook record);

    int updateByPrimaryKey(OrderBook record);
}
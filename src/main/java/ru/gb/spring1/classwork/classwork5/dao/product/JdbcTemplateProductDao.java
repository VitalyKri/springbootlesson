package ru.gb.classwork5.dao.product;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.gb.classwork5.entity.Product;

import java.util.List;


//@Component
@RequiredArgsConstructor
public class JdbcTemplateProductDao implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> findAll() {
        List<Product> query = jdbcTemplate.query("select * from product",
                (rs, rowNum) -> Product.builder()
                        .id(rs.getLong("id"))
                        .title(rs.getString("title"))
                        .cost(rs.getBigDecimal("cost"))
                        .build()

        );
        return query;
    }

    @Override
    public Product findById(Long id) {
        return  null;
    }

}
